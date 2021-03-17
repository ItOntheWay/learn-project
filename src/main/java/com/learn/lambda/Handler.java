package com.learn.lambda;

public interface Handler<T> {
    void handle(T t);
}
