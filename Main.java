package com.company;
/*
* @author Stavnichuk Dmytro
*
* Classname : Main
*
* */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();
        // creating string for logs file
        String myString = new String(Files.readAllBytes(Paths
                .get("logs.txt")));

        String[] lines = myString.split("\\n");
        System.out.println("TXT FILE CONSIST OF : "+System.lineSeparator());
        System.out.println(lines.length + " LINES "+System.lineSeparator());

        int errorLinesCount = 0;

        // cycle for founding and counting error lines
        for (int i = 0; i < lines.length ; i++) {

            if (lines[i].contains("ERROR")){
                errorLinesCount++;
            }

        }
        System.out.println("Finding ERRORS using String.split"+System.lineSeparator());
        System.out.println("Found " +errorLinesCount + " errors");
        LocalDateTime finish = LocalDateTime.now();

        System.out.println("Time : "+ ChronoUnit.MILLIS.between(start, finish) + " ms");

        //same errors but with file.lines methods
        System.out.println("-------------------------------");
        System.out.println("Finding errors using Files.lines"+System.lineSeparator());

        start = LocalDateTime.now();
        final long errors = Files.lines(Paths.get("logs.txt"))
                .filter(line -> line.contains("ERROR"))
                .count();

        System.out.println("Found " +errors+ " errors");
        finish = LocalDateTime.now();

        System.out.println("Time: "+ ChronoUnit.MILLIS.between(start, finish) + "  ms");

        String logs3 = "";

        // record into new file
        Path path = Paths.get("logsAfter.txt");

        Files.write(path, logs3.getBytes());





    }
}

