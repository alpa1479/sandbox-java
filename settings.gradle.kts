rootProject.name = "sandbox-java"

pluginManagement {
    val springDependencyManagement: String by settings
    val springframeworkBoot: String by settings

    plugins {
        id("io.spring.dependency-management") version springDependencyManagement
        id("org.springframework.boot") version springframeworkBoot
    }
}

include("examples:anonymous-classes-vs-lambda-expressions")
include("examples:lambda-expressions")
include("examples:java-memory-model")
include("examples:usage-of-optional-class")
