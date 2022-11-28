package com.egeuniversity.LanguageLearning.Service.Generic;

import com.egeuniversity.LanguageLearning.Model.Generic.BaseEntity;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseEntityServiceImpl<K extends Serializable & Comparable<K>, E extends BaseEntity<K, ?>>
        implements BaseEntityService<K, E>{

    private final Class<E> objectClass;

    private final JpaRepository<E, K> repository;

    @SuppressWarnings("unchecked")
    public BaseEntityServiceImpl(JpaRepository<E, K> repository) {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.objectClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
        this.repository = repository;
    }

    protected final Class<E> getObjectClass() {
        return objectClass;
    }

    public E getById(K id) {
        return repository.findById(id).orElse(null);
    }

    public void save(E entity) throws ServiceException {
        repository.saveAndFlush(entity);
    }

    public void create(E entity) throws ServiceException {
        save(entity);
    }

    public void update(E entity) throws ServiceException {
        save(entity);
    }

    public void delete(E entity) throws ServiceException {
        repository.delete(entity);
    }

    public void flush() {
        repository.flush();
    }

    public List<E> list() {
        return repository.findAll();
    }

    public Long count() {
        return repository.count();
    }

}
