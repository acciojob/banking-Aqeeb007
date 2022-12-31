package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
        // minimum balance is 0 by default
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount > maxWithdrawalLimit)
            throw new Exception("Maximum Withdraw Limit Exceed");
        if(amount > getBalance())
            throw new Exception("Insufficient Balance");
            setBalance(getBalance()-amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest =(getBalance()*rate*years)/100;
        return interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double i = (double) times*years;
        double j = (rate/times)+1;
        j = Math.pow(j,i);
        return j*getBalance();
    }

}
