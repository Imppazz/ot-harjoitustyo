package vesiputous.dao;

import java.sql.SQLException;
import java.util.*;

public interface Dao<T, K> {

    T findOne(K key) throws SQLException;

    List<T> findAll() throws SQLException;

    void delete(K key) throws SQLException;
    
    void add(T o) throws SQLException;
    
    void update(T o) throws SQLException;
}