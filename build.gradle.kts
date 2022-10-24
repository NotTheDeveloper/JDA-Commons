import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

publishing {
    repositories {
        maven {
            name = "jda-commons"
            url = uri("https://maven.pkg.github.com/BlockyDotJar/JDA-Commons")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    api("net.dv8tion:JDA:5.0.0-alpha.22")
    api("org.slf4j:slf4j-api:2.0.3")

    compileOnly("com.google.errorprone:error_prone_annotations:2.16")
    compileOnly("org.jetbrains:annotations:23.0.0")
}

group = "dev.blocky.library"
version = "1.2.0-pr.5"
description = "This is an extension of the Java Discord API from Austin Keener, which adds lots of utility methods and classes."

java {
    sourceCompatibility = JavaVersion.VERSION_17

    withSourcesJar()
    withJavadocJar()
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Automatic-Module-Name"] = "jdacommons"
    }
}

val shadowJar by tasks.getting(ShadowJar::class) {
    minimize()
}
