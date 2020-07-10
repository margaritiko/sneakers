load("@rules_java//java:defs.bzl", "java_binary")

load("@dagger//:workspace_defs.bzl", "dagger_rules")

dagger_rules()

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
	        "//src/com/source:boutique",
	        "//src/com/common:limits",
	        "//src/com/common:random",],
)

