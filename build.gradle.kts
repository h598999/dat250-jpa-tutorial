plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.hibernate.orm:hibernate-platform:6.6.0.Final"))
    implementation("org.hibernate.orm:hibernate-core:6.6.0.Final")
    implementation("jakarta.transaction:jakarta.transaction-api:2.0.0")
    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")
    // Uncomment if using H2 for tests
    // implementation("com.h2database:h2:2.2.220")
    implementation("org.postgresql:postgresql:42.7.4")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "no.hvl.dat250.jpa.tutorial.basicexample.Main"
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

