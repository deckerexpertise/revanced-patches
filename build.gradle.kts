plugins {
    kotlin("jvm") version "1.8.20"
}

group = "app.revanced"

val githubUsername: String = project.findProperty("gpr.user") as? String ?: System.getenv("GITHUB_ACTOR")
val githubPassword: String = project.findProperty("gpr.key") as? String ?: System.getenv("GITHUB_TOKEN")

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://maven.pkg.github.com/revanced/revanced-patcher")
        credentials {
            username = githubUsername
            password = githubPassword
        }
    }
    // Required for FlexVer-Java
    maven {
        url = uri("https://repo.sleeping.town")
        content {
            includeGroup("com.unascribed")
        }
    }
}

dependencies {
    implementation("app.revanced:revanced-patcher:12.0.0")
    implementation("app.revanced:multidexlib2:2.5.3-a3836654")
    // Required for meta
    implementation("com.google.code.gson:gson:2.10.1")
    // Required for FlexVer-Java
    implementation("com.unascribed:flexver-java:1.0.2")
    // A dependency to the Android library unfortunately fails the build,
    // which is why this is required for the patch change-oauth-client-id
    compileOnly(project("dummy"))
}
kotlin {
    jvmToolchain(11)
}
tasks {
    register<DefaultTask>("generateBundle") {
        description = "Generate dex files from build and bundle them in the jar file"
        dependsOn(build)erateMeta"))    }
}

