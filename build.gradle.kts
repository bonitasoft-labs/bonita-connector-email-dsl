plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
    `maven-publish`
}
group = "org.bonitasoft.connectors"
version = "6.1.0"

repositories {
    mavenLocal()
    jcenter()
    maven("http://repositories.rd.lan/maven/all/")
}

dependencies {
    implementation("org.bonitasoft.connectors:bonita-connector-email-impl:6.1.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.bonitasoft.engine.dsl:process-kotlin-dsl:0.0.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}


publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
        }
    }
}