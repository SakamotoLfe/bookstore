package com.example.bookstore.service;

import com.example.bookstore.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class created to make the generic services to the entire system.
 *
 * @author Alfredo Marin
 * @version ALPHA-0.0.1
 * @since 12/10/2019
 */

@Service
public abstract class GenericService<T> {

    private static final Logger LOGGER = Logger.getLogger(GenericService.class.getName());

    @Autowired
    protected abstract GenericRepository getGenericRepository();

    public List<T> findAll() {
        return getGenericRepository().findAll();
    }

    public Optional<T> findById(UUID id) {
        return getGenericRepository().findById(id);
    }

    public T save(T entity) {
        return (T) getGenericRepository().save(entity);
    }

    public Collection<T> saveAll(Collection<T> entities) {
        return getGenericRepository().saveAll(entities);
    }
}
