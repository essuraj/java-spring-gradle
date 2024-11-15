plugins {
    id("java")
}

group = "org.bel"
version = "0.0.1-SNAPSHOT"

dependencies {
    // Spring Boot dependencies
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-ldap")

    // PostgreSQL driver
    runtimeOnly("org.postgresql:postgresql")

    // JSON Web Token library
    implementation("io.jsonwebtoken:jjwt:0.9.1")
}
