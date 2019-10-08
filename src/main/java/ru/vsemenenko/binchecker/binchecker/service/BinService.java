package ru.vsemenenko.binchecker.binchecker.service;

import org.springframework.stereotype.Service;
import ru.vsemenenko.binchecker.binchecker.model.Bin;

import java.util.List;

@Service
public interface BinService {
    List<Bin> getAll();

    Bin getById(long id);

    Bin getByValue(Bin value);

    void add(Bin value);

    List<Bin> getLastTen();

}
