package org.example;

public class ATMSimulator {
    public static void main(String[] args) {
        ATM atm = ATM.getInstance();

        // Внесение денег в банкомат
        Operation depositOperation1 = new DepositOperation(5000, 2);
        depositOperation1.execute();
        Operation depositOperation2 = new DepositOperation(1000, 5);
        depositOperation2.execute();
        Operation depositOperation3 = new DepositOperation(500, 10);
        depositOperation3.execute();
        Operation depositOperation4 = new DepositOperation(100, 20);
        depositOperation4.execute();
        Operation depositOperation5 = new DepositOperation(50, 30);
        depositOperation5.execute();

        // Проверка баланса
        Operation checkBalanceOperation = new CheckBalanceOperation();
        checkBalanceOperation.execute();

        // Снятие денег из банкомата
        Operation withdrawOperation1 = new WithdrawOperation(8750);
        withdrawOperation1.execute();
        Operation withdrawOperation2 = new WithdrawOperation(150);
        withdrawOperation2.execute();
        Operation withdrawOperation3 = new WithdrawOperation(12350);
        withdrawOperation3.execute();
        Operation withdrawOperation4 = new WithdrawOperation(100000);
        withdrawOperation4.execute();

        // Повторная проверка баланса
        checkBalanceOperation.execute();
    }

}
