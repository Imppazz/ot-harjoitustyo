package vesiputous.dao;

import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Ilmari
 * @param <T>
 * @param <K>
 */
public interface Dao<T, K> {

    /**
     *
     * @param key
     * @return
     * @throws SQLException
     */
    T findOne(K key) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    List<T> findAll() throws SQLException;

    /**
     *
     * @param key
     * @throws SQLException
     */
    void delete(K key) throws SQLException;
    
    /**
     *
     * @param o
     * @throws SQLException
     */
    void add(T o) throws SQLException;
    
    /**
     *
     * @param o
     * @throws SQLException
     */
    void update(T o) throws SQLException;
}