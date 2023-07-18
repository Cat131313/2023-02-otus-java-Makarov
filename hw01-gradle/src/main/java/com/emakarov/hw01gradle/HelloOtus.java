package com.emakarov.hw01gradle;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        List<String> words = List.of("Test", "test2");
        Multiset<String> counts = HashMultiset.create();
        for (String word : words) {
            counts.add(word);
        }
        System.out.printf(counts.toString());
    }
}