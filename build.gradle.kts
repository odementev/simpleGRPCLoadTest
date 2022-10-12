group = "qa"
version = "0.1.0"
plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jmailen.kotlinter") version "3.4.0"
}


repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("us.abstracta.jmeter:jmeter-java-dsl:0.56") {
        exclude("org.apache.jmeter", "bom")
    }
    implementation("us.abstracta.jmeter:jmeter-java-dsl-graphql:0.56"){
        exclude("org.apache.jmeter", "bom")
    }
    implementation("org.assertj:assertj-core:3.22.0")
    implementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.21")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    implementation("org.simpleframework:simple-xml:2.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

    implementation("com.sealwu:kscript-tools:1.0.2")

}

tasks {
    test {
        ignoreFailures = true

        useJUnitPlatform()

        jvmArgs = listOf("-Xms4G", "-Xmx14G", "-XX:+DisableExplicitGC")

        testLogging {
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
            showCauses = true
        }
    }
}
