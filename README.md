# CodeThink Common

[![Latest release](https://img.shields.io/github/release/codethink-cn/codethink-common.svg)](https://github.com/codethink-cn/codethink-common/releases/latest)
[![Build by Gradle](https://img.shields.io/badge/Build%20by-Gradle-06A0CE?logo=Gradle&labelColor=02303A)](https://gradle.org/?from=codethink-common)

`CodeThink Common` 是 `CodeThink Technologies` 开发的工具库，包含常用的接口和工具类。

## 使用

最新组件版本可在[此处](https://nexus.codethink.cn/#browse/browse:maven-public:cn%2Fcodethink%2Fcodethink-common%2Fmaven-metadata.xml)浏览。

### Gradle Groovy DSL

只需要在 `build.gradle` 中添加如下语句，刷新 `Gradle` 后即可使用 `CodeThink Common`。

```groovy
repositories {
    maven {
        url('https://repo.codethink.cn/public')
    }
}

dependencies {
    implementation('cn.codethink:codethink-common:' + codethinkCommonVersion)
}
```

### Gradle Kotlin DSL

只需要在 `build.gradle.kts` 中添加如下语句，刷新 `Gradle` 后即可使用 `CodeThink Common`。

```groovy
repositories {
    maven {
        url("https://repo.codethink.cn/public")
    }
}

dependencies {
    implementation("cn.codethink:codethink-common:${codethinkCommonVersion}")
}
```

### Maven

只需要在 `pom.xml` 中添加如下语句，刷新 `Maven` 后即可使用 `CodeThink Common`。

```xml
<repositories>
    <repository>
        <id>codethink</id>
        <name>CodeThink Repository</name>
        <url>https://repo.codethink.cn/public</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>cn.codethink</groupId>
        <artifactId>codethink-common</artifactId>
        <version>${codethink.common.version}</version>
    </dependency>
</dependencies>
```

## 许可

### 开源许可

`CodeThink Common` 在 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 许可证下发布。

```text
Copyright 2023 CodeThink Technologies and contributors.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## 鸣谢

> [IntelliJ IDEA](https://zh.wikipedia.org/zh-hans/IntelliJ_IDEA) 是一个在各个方面都最大程度地提高开发人员的生产力的 IDE，适用于 JVM 平台语言。

特别感谢 [JetBrains](https://www.jetbrains.com/?from=codethink-common) 为开源项目提供免费的 [IntelliJ IDEA](https://www.jetbrains.com/idea/?from=codethink-common) 等 IDE 的授权  
[<img src=".github/icons/jetbrains.png" width="200"/>](https://www.jetbrains.com/?from=codethink-common)

