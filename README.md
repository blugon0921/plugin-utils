# Plugin Utils

[![PluginPlus](https://img.shields.io/badge/plus-1.2.4-blue.svg)]()
<br><br>
[![Java](https://img.shields.io/badge/Java-21-FF7700.svg?logo=java)]()
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-186FCC.svg?logo=kotlin)]()
[![PaperMC](https://img.shields.io/badge/PaperMC-222222.svg)]()


<br>
<br>

### Use API


## Maven
```xml
<repositories>
    <repository>
        <id>kr.blugon</id>
        <url>https://repo.blugon.kr/repository/maven-public/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>kr.blugon</groupId>
        <artifactId>plugin-utils</artifactId>
        <version>VERSION</version>
    </dependency>
</dependencies>
```


## Groovy
```groovy
repositories {
    maven { 'https://repo.blugon.kr/repository/maven-public/' }
}

dependencies {
    implementation 'kr.blugon:plugin-utils:VERSION'
}
```

## Kotlin DSL
```kotlin
repositories {
    maven("https://repo.blugon.kr/repository/maven-public/")
}

dependencies {
    implementation("kr.blugon:plugin-utils:VERSION")
}
```
