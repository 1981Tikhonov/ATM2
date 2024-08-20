package org.example;

public class CheckBalanceOperation implements Operation{
    @Override
    public void execute() {
        ATM atm = ATM.getInstance();
        System.out.printf("Ваш текущий баланс: %d%n", atm.getTotalBalance());
    }


}
