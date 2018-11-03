package kg.gov.mf.loan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class GenericDaoImpl<E> implements GenericDao<E>
{
    @PersistenceContext
    protected EntityManager entityManager;

    private Class<E> entityClass;

    @Autowired
    public void setEntity() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperClass.getActualTypeArguments()[0];
    }

    @Override
    public void create(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public E edit(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void deleteById(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public E findById(Long id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        List<E> list = entityManager.createQuery("SELECT p FROM " + entityClass +" p").getResultList();
        return list;
    }
}
