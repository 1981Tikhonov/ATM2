package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WithdrawOperation implements Operation {
    private int amount;

    public WithdrawOperation(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute() {
        ATM atm = ATM.getInstance();
        if (amount <= 0) {
            System.out.println("Неправильная сумма. Введите положительную сумму.");
            return;
        }

        if (amount > atm.getTotalBalance()) {
            System.out.println("Недостаточно средств.");
            return;
        }

        Map<Integer, Integer> cash = new TreeMap<>((a, b) -> b - a); // Сортировка номиналов по убыванию
        cash.putAll(atm.getCash());
        int remainingAmount = amount;
        Map<Integer, Integer> withdrawal = new HashMap<>();

        for (int denomination : cash.keySet()) {
            if (remainingAmount == 0) break;
            int count = Math.min(remainingAmount / denomination, cash.get(denomination));
            if (count > 0) {
                withdrawal.put(denomination, count);
                remainingAmount -= denomination * count;
            }
        }

        if (remainingAmount > 0) {
            System.out.println("Невозможно выдать эту сумму имеющимися номиналами.");
            return;
        }

        // Снятие наличных в банкомате
        for (Map.Entry<Integer, Integer> entry : withdrawal.entrySet()) {
            atm.removeCash(entry.getKey(), entry.getValue());
        }

        System.out.printf("Вы вывели сумму %d. Ваш новый баланс %d%n", amount, atm.getTotalBalance());
    }
}
