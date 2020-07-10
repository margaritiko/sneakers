load("@rules_java//java:defs.bzl", "java_library")

package(
    default_visibility = ["//src/com/source:__pkg__", "//:__pkg__"],
)

java_library(
    name = "random",
    srcs = glob(["random/**/*.java"]),
    deps = ["//:dagger"],
)

java_library(
    name = "limits",
    srcs = glob(["limits/**/*.java"]),
    deps = ["//:dagger"],
)