package fr.univtln.m2.gui.dao;



import fr.univtln.m2.gui.entities.SimpleEntity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public interface DAO<T extends SimpleEntity> extends AutoCloseable {

    EntityManager getEntityManager();

    Class<T> getMyType();

    default void persist(T t) {
        getEntityManager().persist(t);
    }

    default T merge(T t) {
        return getEntityManager().merge(t);
    }

    default void refresh(T t) {
        getEntityManager().refresh(t);
    }

    default void clear() {
        getEntityManager().clear();
    }

    default List<T> findAll() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getMyType());
        Root<T> rootEntry = cq.from(getMyType());
        CriteriaQuery<T> all = cq.select(rootEntry);

        TypedQuery<T> allQuery = getEntityManager().createQuery(all);
        return allQuery.getResultList();    }

    default T find(long id) {
        return getEntityManager().find(getMyType(), id);
    }

    @Override
    default void close() {
        getEntityManager().close();
    }

    default void flush() {
        getEntityManager().flush();
    }

    default EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }


}