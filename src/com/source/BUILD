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
    srcs = glob(["designer/**/*.java"]),
    deps = [":colors", ":brands", ":sneakers", ":company", "//:dagger"],
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

java_library(
    name = "boutique",
    srcs = glob(["boutique/**/*.java"]),
    deps = [":factory", ":sneakers", "//:dagger"],
)

java_library(
    name = "company",
    srcs = glob(["company/**/*.java"]),
    deps = ["//src/com/common:random", "//:dagger"],
)

java_library(
    name = "customer",
    srcs = glob(["customer/**/*.java"]),
    deps = ["//src/com/common:annotations"],
)