/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/8.0.2/userguide/building_java_projects.html
 */

plugins {
    `java-library`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit test framework.
    // testImplementation("junit:junit:4.13.2")
    implementation("org.apache.xmlgraphics:batik-svggen:1.7")
    implementation("org.apache.xmlgraphics:batik-swing:1.7")
    // This dependency is used by the application.
    // implementation("com.google.guava:guava:31.1-jre")
}

// application {
//     // Define the main class for the application.
//     mainClass.set("edu.duke.cs.jflap.JFLAP")
// }

// tasks.jar { // could also be a new task rather than the default one
//     manifest {
//         attributes["Main-Class"] = "edu.duke.cs.jflap.JFLAP"
//     }
// }