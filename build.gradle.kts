import jdk.nashorn.internal.objects.NativeRegExp.test
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.41"
}

/*
test {
    useJUnitPlatform()
}
*/

group = "SC-ZOO-GROUP-ID"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

/*
dependencies {
    testImplementation "org.junit.jupiter:junit-jupiter-api:5.3.1"
    testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:5.3.1"
}

 */

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

