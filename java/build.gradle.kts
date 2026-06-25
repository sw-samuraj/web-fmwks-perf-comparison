plugins {
    application
}

application {
    mainClass = "blog.swsamuraj.Hello"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "blog.swsamuraj.Hello"
    }
}
