plugins {
    kotlin("jvm") version "1.5.10"
}

group = "com.run3wide"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.0.3")
}
