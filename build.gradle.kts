plugins {
    id("java")
}

group = "org.htilssu"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    maven("https://jogamp.org/deployment/maven")
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")


//    implementation("org.jogamp.jogl:jogl-all:2.4.0")
//    implementation ("org.jogamp.gluegen:gluegen-rt-main:2.4.0")
//    implementation ("org.jogamp.jogl:jogl-all-main:2.4.0")
}

tasks.test {
    useJUnitPlatform()
}