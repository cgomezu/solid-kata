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
public class WithdrawAccountServiceTest {

    @Mock
    private Clock clock;

    @Mock
    private TransactionRepository transactionRepository;

    private WithdrawAccountService service;

    private static final LocalDate TODAY = LocalDate.of(2017, 9, 6);

    private static final int POSITIVE_AMOUNT = 100;
    private static final int NEGATIVE_AMOUNT = -POSITIVE_AMOUNT;

    @Before
    public void setUp() {
        service = new WithdrawAccountService(transactionRepository, clock);
        given(clock.today()).willReturn(TODAY);
    }

    @Test
    public void withdraw_amount_from_the_account() {

        service.withdraw(POSITIVE_AMOUNT);

        verify(transactionRepository).add(refEq(new Transaction(TODAY, NEGATIVE_AMOUNT)));
    }

}