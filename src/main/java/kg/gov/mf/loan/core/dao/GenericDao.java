package kg.gov.mf.loan.core.dao;

import java.util.List;

public interface GenericDao<E> {

    void create(E entity);
    E edit(E entity);
    void deleteById(E entity);
    E findById(Long id);
    List<E> findAll();
}