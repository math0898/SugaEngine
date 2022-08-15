# Suga Engine

The Suga Engine is a complete game engine written in Java written from scratch.

## Installation

Installation is the same across Linux, Windows, and Mac.

### Dependencies

The Suga Engine requires Java 18 Runtime to be installed on the consumer's system. Developers should have the Java 18
Development Kit, and their choice of build system. Included are instructions for Maven and Gradle.

### Gradle

1. **Create Secrets File**

Create a new file. In this example I've named mine `secrets.properties`. Replace the file contents with your GitHub 
username and token.

```properties
USERNAME=YOUR_GITHUB_USERNAME
TOKEN=YOUR_GITHUB_TOKEN
```

<u>**Make sure to add this file to your .gitignore!!!**</u>

2. **Load Secrets File With Gradle**

Place the following at the top of your `build.gradle` file. 

```groovy
def secrets = new Properties()
file("secrets.properties").withInputStream { secrets.load(it) }
```

Remember to change the file name if you used a different name for part 1.

3. **Add GitHub Packages Repository**

```groovy
repositories {

    // ...

    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/math0898/SugaEngine")
        credentials {
            username = project.findProperty("gpr.user") ?: secrets.getProperty("USERNAME")
            password = project.findProperty("gpr.key") ?: secrets.getProperty("TOKEN")
        }
    }

    // ...

}
```

4. **Add Suga Engine Dependency**

```groovy
dependencies {
    
    // ...
    
    implementation 'io.github.math0898:suga-engine:2.3.2'
    
    // ...
}
```

Make sure to replace this version with the desired version.

### Maven

```xml
<dependencies>
    <dependency>
        <groupId>io.github.math0898</groupId>
        <artifactId>suga-engine</artifactId>
        <version>2.3.2</version>
    </dependency>
</dependencies>
```

Make sure to replace this version with the desired version.
