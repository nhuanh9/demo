package com.company.service;

import java.util.List;

public interface GeneralService<T> {
    void create(T t);

    void delete(int id);

    void update(int id, T t);

    T findById(int id);

    T findIndexById(int id);

    List<T> findAll();

    void display();
}
