package com.chmnu_ki_123.c3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterWordsTest {

    @Test
    void testFilterWords() {
        String[] words = {"banana", "day", "laptop", "6832", "lesson"};
        String regex = "\\d+";  // Патерн для чисел

        String result = FilterWords.filterWords(words, regex);

        assertEquals("banana day laptop lesson", result);
    }

    @Test
    void testFindMatchingWords() {
        String sentence = "banana day 1431 hi 28234";
        String regex = "\\d+";

        List<String> matchingWords = FilterWords.findMatchingWords(sentence, regex);

        assertEquals(List.of("1431", "28234"), matchingWords);
    }

    @Test
    void testEmptyWordsArray() {
        String[] words = {};
        String regex = "\\d+";  // Патерн для чисел

        String result = FilterWords.filterWords(words, regex);

        assertEquals("", result);
    }

    @Test
    void testEmptySentence() {
        String sentence = "";
        String regex = "\\d+";  // Патерн для чисел

        List<String> matchingWords = FilterWords.findMatchingWords(sentence, regex);

        assertEquals(List.of(), matchingWords);
    }
}
