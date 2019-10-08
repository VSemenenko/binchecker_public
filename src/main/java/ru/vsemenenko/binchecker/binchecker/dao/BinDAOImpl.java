package ru.vsemenenko.binchecker.binchecker.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vsemenenko.binchecker.binchecker.model.Bin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BinDAOImpl implements BinDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Bin getByValue(Bin value) {
        return entityManager.find(Bin.class, value);
    }

    @Override
    public void add(Bin value) {
        entityManager.persist(value);
    }

    @Override
    public List<Bin> getAll() {
        return entityManager.createQuery("SELECT b FROM " + Bin.class + " b", Bin.class).getResultList();
    }

    @Override
    public Bin getById(long id) {
        return entityManager.find(Bin.class, id);
    }

    @Override
    public List<Bin> getLastTen() {
        return entityManager.createQuery("FROM Bin b ORDER BY b.id DESC").setMaxResults(10).getResultList();
    }


}
