load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "SneakersMain",
    srcs = ["src/main/Main.java"],
    main_class = "main/Main",
    deps = ["//src/com/source:brands", 
	    "//src/com/source:colors", 
	    "//src/com/source:designer", 
	    "//src/com/source:price", 
	    "//src/com/source:sneakers", 
	    "//src/com/source:factory",
	    "//src/com/common:limits",
	    "//src/com/common:random"],
)

