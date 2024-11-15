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
	extra["springCloudVersion"] = "2023.0.3"

	dependencies {
		implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
		implementation("org.springframework.boot:spring-boot-starter")
		implementation("org.springframework.boot:spring-boot-starter-web")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}
	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(21)
		}
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

}


