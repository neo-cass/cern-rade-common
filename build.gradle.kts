plugins {
    id ("java-library")
    id ("cern.devops.cbng.dependency")
    id("cern.devops.cbng.project")
    //when using the cbng publication dependnecy, the source and target compatibility (or java toolchain)
    //can be overwritten. In this case you must set autoconfigureJvm=false in gradle.properties
    id("cern.devops.cbng.publication")
}

configurations.configureEach {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("cern.cmw:cmw-data:PRO")
    implementation("cern.japc:japc-value:PRO")
    implementation("cern.japc:japc:PRO")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.named<Jar>("jar") {
    val jarName = project.findProperty("jarName")
    if(jarName!=null){
        archiveFileName.set(jarName as String)
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))

    }
    withJavadocJar()
    withSourcesJar()
}
