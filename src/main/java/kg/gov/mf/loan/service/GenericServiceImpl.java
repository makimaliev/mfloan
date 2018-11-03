package kg.gov.mf.loan.service;

import kg.gov.mf.loan.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public abstract class GenericServiceImpl<E> implements GenericService<E>
{
    @Autowired
    protected GenericDao<E> dao;

    @Override
    public void add(E entity) {
        dao.create(entity);
    }

    @Override
    public void update(E entity) {
        dao.edit(entity);
    }

    @Override
    public void remove(E entity) {
        dao.deleteById(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public E getById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> list() {
        return dao.findAll();
    }
}