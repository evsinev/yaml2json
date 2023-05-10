Convert yaml to json
==========================

Converts snakeyaml-engine to gson

## Setup with dependency managers

### Maven

```xml
<repositories>
    <repository>
        <id>pne</id>
        <name>payneteasy repo</name>
        <url>https://maven.pne.io</url>
    </repository>
</repositories>

<dependency>
  <groupId>com.payneteasy</groupId>
  <artifactId>yaml2json</artifactId>
  <version>1.0-1</version>
</dependency>

<dependency>
    <groupId>org.snakeyaml</groupId>
    <artifactId>snakeyaml-engine</artifactId>
    <version>2.5</version>
</dependency>

```

### Gradle

```groovy
compile 'com.payneteasy:yaml2json:1.0-1'
```

How to use
------------

```java
YamlParser     parser  = new YamlParser();
ExampleRequest request = parser.parseFile(new File("example-01.yaml"), ExampleRequest.class);
```

## License

The ApiServlet library is licensed under the Apache License 2.0
