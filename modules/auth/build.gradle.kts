plugins {
    id("java")
}

group = "org.bel"
version = "0.0.1-SNAPSHOT"

dependencies {
    // Spring Boot dependencies
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-ldap")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.ldap:spring-ldap-core")
    // PostgreSQL driver
    runtimeOnly("org.postgresql:postgresql")

    // JSON Web Token library
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")
}
