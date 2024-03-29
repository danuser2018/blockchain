import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val commonsCodecVersion: String by project
val jacksonVersion: String by project
val kotestVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.6.21"
    `maven-publish`
    id("org.sonarqube") version "3.3"
    jacoco
}

group = "me.danuser2018"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-codec:commons-codec:$commonsCodecVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "me.danuser2018"
            artifactId = "blockchain"
            version = "0.1.0"

            from(components["java"])
        }
    }
}

sonarqube {
    properties {
        property("sonar.projectKey", "danuser2018_blockchain")
        property("sonar.organization", "danuser2018")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}