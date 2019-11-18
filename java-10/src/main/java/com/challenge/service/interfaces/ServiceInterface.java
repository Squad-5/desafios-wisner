package com.challenge.service.interfaces;

import org.springframework.stereotype.Component;

public interface ServiceInterface<T> {
    T save(T object);
}
