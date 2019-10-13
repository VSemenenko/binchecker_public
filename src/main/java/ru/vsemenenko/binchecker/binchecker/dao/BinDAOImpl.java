package ru.vsemenenko.binchecker.binchecker.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vsemenenko.binchecker.binchecker.model.Bank;
import ru.vsemenenko.binchecker.binchecker.model.Bin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BinDAOImpl implements BinDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Bin getByValue(Bin bin) {
        return (Bin) entityManager.createQuery("select b from Bin b where b.value = :val").setParameter("val", bin.getValue()).getSingleResult();
    }

    @Override
    public void add(Bin value) {
        entityManager.persist(value);
    }

    @Override
    public List<Bin> getAll() {
        return entityManager.createQuery("SELECT b FROM Bin b").getResultList();
    }


    @Override
    public Bin getById(long id) {
        return entityManager.find(Bin.class, id);
    }

    @Override
    public List<Bin> getLastTen() {
        return entityManager.createQuery("FROM Bin b ORDER BY b.id DESC").setMaxResults(10).getResultList();
    }

    @Override
    public boolean checkBin(Bin bin) {
        return (boolean) entityManager.createQuery("SELECT CASE WHEN (count (b) >0 and EXISTS (SELECT b FROM b WHERE b.value = :val)) then true else false end from Bin b").setParameter("val", bin.getValue()).getSingleResult();
    }

    @Override
    public Bank getBankByBinValue(Bin bin) {
        return (Bank) entityManager.createQuery("select b.bank from Bin b where b.value = :val").setParameter("val", bin.getValue()).getSingleResult();
    }
}
