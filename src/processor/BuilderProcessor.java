package processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedAnnotationTypes("com.common.annotations.BuilderProperty")
public class BuilderProcessor extends AbstractProcessor {

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (TypeElement annotation: annotations) {
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);

            // Looking through all annotated methods and choosing only setters with one argument.
            Map<Boolean, List<Element>> annotatedMethods = annotatedElements.stream().collect(
                    Collectors.partitioningBy(element -> (
                            (ExecutableType) element.asType()).getParameterTypes().size() == 1
                            && element.getSimpleName().toString().startsWith("set")
                    )
            );

            List<Element> setters = annotatedMethods.get(true);
            List<Element> otherMethods = annotatedMethods.get(false);

            // Let's inform user about incorrect annotated methods.
            otherMethods.forEach(element -> processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                    "@BuilderProperty must be applied to a setter with one argument."));

            if (setters.isEmpty())
                continue;

            // Getting class'name.
            String className = ((TypeElement) setters.get(0).getEnclosingElement()).getQualifiedName().toString();

            // A map between names of setters and types of their arguments.
            Map<String, String> setterMap = setters.stream().collect(
                    Collectors.toMap(
                            setter -> setter.getSimpleName().toString(),
                            setter -> ((ExecutableType) setter.asType()).getParameterTypes().get(0).toString()
                    )
            );

            try {
                generateClass(className, setterMap);
            } catch (IOException e) {
                System.out.println("Failed to make builder class's sources. Reason: " + e.getMessage() + ".");
            }
        }

        return true;
    }


    private void generateClass(String className, Map<String, String> setterMap) throws IOException {

        // Making names for classes.
        String packageName = null;
        int lastDot = className.lastIndexOf('.');
        if (lastDot > 0) {
            packageName = className.substring(0, lastDot);
        }

        String simpleClassName = className.substring(lastDot + 1);
        String builderClassName = className + "Builder";
        String builderSimpleClassName = builderClassName.substring(lastDot + 1);


        JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(builderClassName);

        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {

            if (packageName != null) {
                out.println(String.format("package %s;\n", packageName));
            }

            out.println(String.format("public class %s {\n", builderSimpleClassName));
            out.println(String.format("    private %s object = new %s();\n", simpleClassName, simpleClassName));
            out.println(String.format("    public %s build() {\n        return object;\n    }\n", simpleClassName));

            setterMap.entrySet().forEach(setter -> {
                String methodName = setter.getKey();
                String argumentType = setter.getValue();

                out.print(String.format("    public %s %s", builderSimpleClassName, methodName));
                out.println(String.format("(%s value) {", argumentType));
                out.println(String.format("        object.%s(value);", methodName));
                out.println(String.format("        return this;"));
                out.println("    }\n");

            });

            out.println("}");
        }
    }
}
