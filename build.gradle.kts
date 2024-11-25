plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
}

group = "com.drapegnik"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootRun {
    systemProperty("spring.profiles.active", "dev")
}

tasks.register("showEnv") {
    doLast {
        println("\nJava version:\t${System.getProperty("java.version")}")
        val kotlinVersion = org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java.`package`.implementationVersion
        println("Kotlin version:\t$kotlinVersion")
    }
}

ktlint {
    version.set("1.4.1")
    verbose.set(true)
    android.set(false)
    enableExperimentalRules.set(true)
    outputToConsole.set(true)
    ignoreFailures.set(false)
}
