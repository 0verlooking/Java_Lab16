package com.chmnu_ki_123.c3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FilterWords {

    // Метод для фільтрації слів
    public static String filterWords(String[] words, String regex) {
        if (words == null || regex == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }

        Pattern pattern = Pattern.compile(regex);
        return java.util.Arrays.stream(words)
                .filter(word -> word != null && !pattern.matcher(word).matches())
                .collect(Collectors.joining(" "));
    }

    // Метод для знаходження слів, що відповідають патерну
    public static List<String> findMatchingWords(String sentence, String regex) {
        if (sentence == null || regex == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }

        Pattern pattern = Pattern.compile(regex);
        List<String> matchingWords = new ArrayList<>();

        for (String word : sentence.split("\\s+")) {
            if (word != null && pattern.matcher(word).matches()) {
                matchingWords.add(word);
            }
        }

        return matchingWords;
    }

    // Тестування
    public static void main(String[] args) {
        String regex = "\\d+";  // Патерн для чисел
        String[] words = {"hello", "123", "world", "456"};

        // Фільтрація слів
        String filteredWords = FilterWords.filterWords(words, regex);
        System.out.println("Filtered words: " + filteredWords);  // Виведе: hello world

        // Знаходження слів, що відповідають патерну
        String sentence = "hello 123 world 456";
        List<String> matchingWords = FilterWords.findMatchingWords(sentence, regex);
        System.out.println("Matching words: " + matchingWords);  // Виведе: [123, 456]
    }
}
