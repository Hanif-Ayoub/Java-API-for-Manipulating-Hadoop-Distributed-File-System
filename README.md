# Java API for Interacting with HDFS
## Introduction
This project presents a Java API tailored for effortless interaction with Hadoop Distributed File System (HDFS). It specializes in efficient data reading and writing in HDFS. The project demonstrates writing data to an HDFS file and creating an application to read from HDFS and rewrite locally. It offers developers a straightforward way to integrate HDFS functionalities into Java applications.

## Maven Dependencies
```xml
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-client</artifactId>
    <version>2.7.3</version>
</dependency>
```

## Reading from HDFS in Java

### Java Code

```java
public class Read {
    public static void main() {
        Configuration cf = new Configuration();
        cf.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fileSystem = FileSystem.get(cf);
        Path path = new Path("/SDIA/CPP/Cours/CoursCPP1");
        FSDataInputStream fsdis = fileSystem.open(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fsdis, StandardCharsets.UTF_8));
        String ligne = null;
        while ((ligne = reader.readLine()) != null) {
            System.out.println(ligne);
        }
        fsdis.close();
        fileSystem.close();
    }
}
```


## Writing To HDFS in Java

### Code Java
```java
public class Write {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(configuration);
        Path path = new Path("/SDIA/CPP/Cours/CoursCPP1");
        FSDataOutputStream fsdos = fs.create(path);
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fsdos, StandardCharsets.UTF_8));
        br.write("SDIA 2");
        br.newLine();
        br.write("SDIA 2");
        br.close();
        fs.close();
    }
}
```