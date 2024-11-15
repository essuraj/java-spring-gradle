plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}
group = "org.bel"
version = "0.0.1-SNAPSHOT"

subprojects {
	apply(plugin = "java")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")

	group = "org.bel"
	version = "0.0.1-SNAPSHOT"


	repositories {
		mavenCentral()
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}
	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(21)
		}
	}


	tasks.withType<Test> {
		useJUnitPlatform()
	}

}


