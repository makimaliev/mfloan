package kg.gov.mf.loan.service;

import kg.gov.mf.loan.model.MFLog;

import java.util.List;

public interface GenericService<E>
{
    void add(E entity);
    void update(E entity);
    void remove(E entity);
    E getById(Long id);
    List<E> list();
}