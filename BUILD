load("@rules_java//java:defs.bzl", "java_binary", "java_plugin")
load("@dagger//:workspace_defs.bzl", "dagger_rules")

dagger_rules()

java_plugin(
    name = "annotations_processor",
    generates_api = 1,
    srcs = glob(["src/processor/*.java"]),
    processor_class = "processor.BuilderProcessor"
)

java_binary(
    name = "SneakersMain",
    srcs = glob(["src/main/*.java"]),
    main_class = "main/Main",
    deps = ["//:dagger",
            "//src/com/source:brands",
	        "//src/com/source:colors",
	        "//src/com/source:designer",
	        "//src/com/source:price",
	        "//src/com/source:sneakers",
	        "//src/com/source:factory",
	        "//src/com/source:company",
	        "//src/com/source:customer",
	        "//src/com/source:boutique",
	        "//src/com/common:limits",
	        "//src/com/common:random",
	        "//src/com/common:annotations"],
     plugins = ["//:annotations_processor"]
)