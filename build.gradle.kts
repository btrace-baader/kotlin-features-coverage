import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    jacoco
}

group = "JaCoCoCCmwe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("junit:junit:4.10")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

jacoco {
    toolVersion = "0.8.3"
    reportsDir = file("$buildDir/jacoco")
}

tasks.withType<Test> {
    useJUnitPlatform { }
}

tasks.withType<JacocoReport> {
    dependsOn(tasks.withType<Test>().names)
    reports {
        xml.isEnabled = true
        csv.isEnabled = false
        html.isEnabled = false
    }
}