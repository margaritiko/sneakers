load("@rules_java//java:defs.bzl", "java_library")

package(
    default_visibility = ["//:__pkg__"],
)

java_library(
    name = "brands",
    srcs = glob(["brands/**/*.java"]),
    deps = ["//src/com/common:random", "//:dagger"],
)

java_library(
    name = "colors",
    srcs = glob(["colors/**/*.java"]),
    deps = ["//src/com/common:limits", "//src/com/common:random", "//:dagger"],
)

java_library(
    name = "designer",
    srcs = glob(["designer/service/**/*.java"]),
    deps = [":colors", ":brands", ":sneakers", "//:dagger"],
)

java_library(
    name = "price",
    srcs = ["price/estimator/PriceEstimator.java"],
    deps = ["//src/com/common:random", ":sneakers", "//:dagger"],
)

java_library(
    name = "sneakers",
    srcs = glob(["sneakers/models/**/*.java"]),
    deps = [":colors", ":brands", "//:dagger"],
)

java_library(
    name = "factory",
    srcs = glob(["factory/**/*.java"]),
    deps = [":designer", ":price", ":sneakers", "//:dagger"],
)