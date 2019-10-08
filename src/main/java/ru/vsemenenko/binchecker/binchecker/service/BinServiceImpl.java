package ru.vsemenenko.binchecker.binchecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsemenenko.binchecker.binchecker.dao.BinDAO;
import ru.vsemenenko.binchecker.binchecker.model.Bin;

import java.util.List;

@Service
public class BinServiceImpl implements BinService{

    @Autowired
    BinDAO binDAO;

    @Override
    public List<Bin> getAll() {
        return binDAO.getAll();
    }

    @Override
    public Bin getById(long id) {
        return binDAO.getById(id);
    }

    @Override
    public Bin getByValue(Bin value) {
        return binDAO.getByValue(value);
    }

    @Override
    public void add(Bin value) {
        binDAO.add(value);
    }

    @Override
    public List<Bin> getLastTen() {
        return binDAO.getLastTen();
    }
}
