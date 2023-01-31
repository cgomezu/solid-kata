package com.codurance.srp;

public class WithdrawAccountService {

    private TransactionRepository transactionRepository;

    private Clock clock;

    public WithdrawAccountService(TransactionRepository transactionRepository, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
    }

    public void withdraw(int amount) {
        transactionRepository.add(new Transaction(clock.today(), -amount));
    }
}
