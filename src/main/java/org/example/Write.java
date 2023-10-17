package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

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