package ru.vsemenenko.binchecker.binchecker.dao;


import org.springframework.stereotype.Repository;
import ru.vsemenenko.binchecker.binchecker.model.Bank;
import ru.vsemenenko.binchecker.binchecker.model.Bin;

import java.util.List;

@Repository
public interface BinDAO {

    List<Bin> getAll();

    Bin getById(long id);

    Bin getByValue(Bin value);

    void add(Bin value);

    List<Bin> getLastTen();

    boolean checkBin(Bin bin);

    Bank getBankByBinValue(Bin bin);

}
