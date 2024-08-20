package org.example;

import java.util.HashMap;
import java.util.Map;


public class ATM {
    private static ATM instance;
    private Map<Integer, Integer> cash;

    private ATM() {
        cash = new HashMap<>();
        // Инициализация купюр разного достоинства
        cash.put(50, 0);
        cash.put(100, 0);
        cash.put(500, 0);
        cash.put(1000, 0);
        cash.put(5000, 0);
    }

    public static ATM getInstance() {
        if (instance == null) {
            instance = new ATM();
        }
        return instance;
    }

    public Map<Integer, Integer> getCash() {
        return cash;
    }

    public void addCash(int denomination, int count) {
        cash.put(denomination, cash.getOrDefault(denomination, 0) + count);
    }

    public void removeCash(int denomination, int count) {
        cash.put(denomination, cash.getOrDefault(denomination, 0) - count);
    }

    public int getTotalBalance() {
        return cash.entrySet().stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();
    }
}
