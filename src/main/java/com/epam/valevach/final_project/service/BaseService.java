package com.epam.valevach.final_project.service;

public interface BaseService<T> {
    void create(T entity);

    T read(Integer id);

    void delete(T entity);

    void update(T entity);
}
