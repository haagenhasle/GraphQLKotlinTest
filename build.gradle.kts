val graphqlKotlinClientVersion = "3.6.4"

group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.3.72"
    id("com.expediagroup.graphql") version "3.6.4"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.expediagroup:graphql-kotlin-client:$graphqlKotlinClientVersion")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

graphql {
    client {
        sdlEndpoint = "https://navikt.github.io/pdl/pdl-api-sdl.graphqls"
        packageName = "pdl.generated"
        allowDeprecatedFields = false
        queryFiles = mutableListOf(file("${project.projectDir}/src/main/resources/hentPerson.graphql"))
		converters = mutableMapOf("DateTime" to com.expediagroup.graphql.plugin.generator.ScalarConverterMapping("java.time.LocalDateTime", "pdl.graphqlscalars.DateTimeScalarConverter")) 
    }
}
