package com.example.demo.utils;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ResultCaptor<T> implements Answer<T> {
    private T result = null;

    public T getResult() {
        return result;
    }

    @Override
    public T answer(InvocationOnMock invocationOnMock) throws Throwable {
        //noinspection unchecked
        result = (T) invocationOnMock.callRealMethod();
        return result;
    }
}
