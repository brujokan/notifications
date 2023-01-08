package com.soma.notifications.domain.mapper;

public interface Mapper<T, V> {

    public T map(V input);
}
