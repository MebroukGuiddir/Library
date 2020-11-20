package fr.univtln.m2.gui.dao;

import fr.univtln.m2.gui.App;
import fr.univtln.m2.gui.entities.SimpleEntity;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;

@Getter
public abstract class AbstractDAO<T extends SimpleEntity> implements DAO<T>  {

    private Class<T> myType;

    private EntityManager entityManager = Persistence
            .createEntityManagerFactory(App.properties.getProperty("pu")).createEntityManager();

    public AbstractDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.myType = (Class) genericSuperclass.getActualTypeArguments()[0];
    }
}
