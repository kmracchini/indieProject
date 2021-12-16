package com.stitchable.persistence;

import com.stitchable.entity.SessionFactoryProvider;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
@Log4j2
/**
 * Generic dao used to access entity information in database
 */

public class GenericDao<T> {

    private final Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the entity type, for example User
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets the session from the session factory provider
     * @return Session the session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets an entity by id.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the by id
     */
    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Gets all entities.
     *
     * @return the all
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Deletes an entity.
     *
     * @param entity the entity
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Saves or updates an entity.
     *
     * @param entity the entity
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Inserts an entity into the database.
     *
     * @param entity the entity
     * @return the int
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Gets an entity by an exact match in the database for the specified property
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equals
     */
    public List<T> getByPropertyEquals(String propertyName, String value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> queryResults = session.createQuery(query).getResultList();
        session.close();
        return queryResults;
    }

    /**
     * Gets an entity by an approximate match in the database for the specified property
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath,"%" + value + "%"));
        List<T> queryResults = session.createQuery(query).getResultList();
        session.close();
        return queryResults;
    }

    /**
     * Gets an entity by a property greater than
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by greater than
     */
    public List<T> getByGreaterThan(String propertyName, int value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.greaterThanOrEqualTo(root.get(propertyName), value));
        List<T> queryResults = session.createQuery(query).getResultList();
        session.close();
        return queryResults;
    }

    /**
     * Gets an entity by a property less than
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by less than
     */
    public List<T> getByLessThan(String propertyName, int value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.lessThanOrEqualTo(root.get(propertyName), value));
        List<T> queryResults = session.createQuery(query).getResultList();
        session.close();
        return queryResults;
    }

    /**
     * Gets a unique result by passing in the property name and value
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equals unique
     */
    public T getByPropertyEqualsUnique(String propertyName, String value) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        T entity = session.createQuery(query).uniqueResult();
        session.close();
        return entity;
    }
}
