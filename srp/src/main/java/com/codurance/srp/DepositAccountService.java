package com.codurance.srp;

public class DepositAccountService {

    private TransactionRepository transactionRepository;
    private Clock clock;

    public DepositAccountService(TransactionRepository transactionRepository, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
    }

    public void deposit(int amount) {
        transactionRepository.add(new Transaction(clock.today(), amount));
    }
}
