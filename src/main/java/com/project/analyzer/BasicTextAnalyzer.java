package com.project.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BasicTextAnalyzer {

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static int countLines(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] lines = text.split("\\r?\\n");
        return lines.length;
    }

    public static int countCharacters(String text) {
        if (text == null) return 0;
        return text.length();
    }

    public static String readFile(String filename) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {
            String strCurrentLine;
            while ((strCurrentLine = br.readLine()) != null) {
                contentBuilder.append(strCurrentLine).append("\n");
            }
        }
        return contentBuilder.toString();
    }

    public static void main(String[] args) {
        String filename = "text.txt";
        String text = "";
        try {
            text = readFile(filename);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        int numWords = countWords(text);
        int numLines = countLines(text);
        int numCharacters = countCharacters(text);

        System.out.println("Number of words: " + numWords);
        System.out.println("Number of lines: " + numLines);
        System.out.println("Number of characters: " + numCharacters);
    }
}