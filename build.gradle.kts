plugins {
    `java-library`
    `maven-publish`
}

publishing {
    repositories {
        maven {
            name = "jda-commons"
            url = uri("https://maven.pkg.github.com/BlockyDotJar/JDA-Commons")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_PASSWORD")
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
    implementation("net.dv8tion:JDA:5.0.0-alpha.18")
    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("ch.qos.logback:logback-classic:1.3.0-beta0")
    implementation("com.google.errorprone:error_prone_annotations:2.15.0")
}

group = "dev.blocky.library"
version = "1.1.6"
description = "This is an extension of the Java Discord API from Austin Keener, which adds lots of utility methods. "

java {
    sourceCompatibility = JavaVersion.VERSION_1_8

    withSourcesJar()
    withJavadocJar()
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Automatic-Module-Name"] = "dev.blocky.library.jda-commons"
    }
}
