package org.itenas.oop.jdbc.repository;

import java.util.List;

public interface CrudRepository<T> {
    boolean insert(T data);
    boolean update(T data);
    boolean delete(int id);
    List<T> getAll();
}
// INTERFACE
// GENERIC