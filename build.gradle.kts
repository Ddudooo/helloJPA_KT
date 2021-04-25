plugins {
    kotlin("jvm") version "1.4.32"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.5.0-RC"
}

group = "study"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.hibernate:hibernate-core:5.4.30.Final")
    implementation("com.h2database:h2:1.4.199")
}
