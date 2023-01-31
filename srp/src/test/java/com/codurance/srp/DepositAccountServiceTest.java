package com.codurance.srp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DepositAccountServiceTest {

    @Mock
    private Clock clock;

    @Mock
    private TransactionRepository transactionRepository;

    private DepositAccountService service;

    private static final LocalDate TODAY = LocalDate.of(2017, 9, 6);

    private static final int POSITIVE_AMOUNT = 100;

    @Before
    public void setUp() {
        service = new DepositAccountService(transactionRepository, clock);
        given(clock.today()).willReturn(TODAY);
    }

    @Test
    public void deposit_amount_into_the_account() {

        service.deposit(POSITIVE_AMOUNT);

        verify(transactionRepository).add(refEq(new Transaction(TODAY, POSITIVE_AMOUNT)));
    }


}