package org.example;

public class DepositOperation implements Operation{
    private int denomination;
    private int count;

    public DepositOperation(int denomination, int count) {
        this.denomination = denomination;
        this.count = count;
    }

    @Override
    public void execute() {
        ATM atm = ATM.getInstance();
        atm.addCash(denomination, count);
        System.out.printf("Ваш депозит %d счет за %d номинал. Ваш новый баланс %d%n",
                count, denomination, atm.getTotalBalance());
    }


}
