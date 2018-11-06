package kg.gov.mf.loan.core.service;

import java.util.List;

public interface GenericService<E>
{
    void add(E entity);
    void update(E entity);
    void remove(E entity);
    E getById(Long id);
    List<E> list();
}