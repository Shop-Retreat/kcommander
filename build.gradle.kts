plugins {
    kotlin("jvm") version "1.5.21"
    id("org.jetbrains.dokka") version "1.5.0"
    id("com.jfrog.artifactory") version "latest.release"
    `maven-publish`
    `java-library`
}

group = "net.shopretreat"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")
    implementation("com.discord4j:discord4j-core:3.1.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.1-native-mt")
}

java {
    withSourcesJar()
}

tasks {
    kotlinSourcesJar {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }
}

publishing {
    publications {
        create<MavenPublication>("kcommander") {
            artifactId = "kcommander"
            from(components["java"])

            artifact(tasks.kotlinSourcesJar) {
                classifier = "sources"
            }

            pom {
                name.set("KCommander")
                description.set("A command framework for Discord4J and Kotlin")
                url.set("https://github.com/Shop-Retreat/kcommander")
            }
        }
    }
}

artifactory {
    setContextUrl("https://shopretreat.jfrog.io/artifactory")

    publish {
        repository {
            setRepoKey("shopretreat-gradle-dev")
            setUsername("username")
            setPassword("password")
        }

        defaults {
            publications("kcommander")
        }
    }
}