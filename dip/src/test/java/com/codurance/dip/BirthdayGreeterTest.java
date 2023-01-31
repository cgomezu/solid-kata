package com.codurance.dip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BirthdayGreeterTest {

    @InjectMocks
    private BirthdayGreeter birthdayGreeter;

    @Mock
    Greeter sendGreeter;

    @Test
    public void whenBirthdayGreeterCallGreeterSend_thenGreeterCallSuccessSendGreetings() {
        doNothing().when(sendGreeter).sendGreetings();
        birthdayGreeter.send();
        verify(sendGreeter, times(1)).sendGreetings();
    }
}