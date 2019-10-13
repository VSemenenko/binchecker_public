package ru.vsemenenko.binchecker.binchecker.dto;

import ru.vsemenenko.binchecker.binchecker.model.Bank;
import ru.vsemenenko.binchecker.binchecker.model.Bin;

import java.util.List;

public class BankBinListDTO {
    private Bank bank;

    private List<Bin> BinList;

    public BankBinListDTO(Bank bank, List<Bin> binList) {
        this.bank = bank;
        BinList = binList;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Bin> getBinList() {
        return BinList;
    }

    public void setBinList(List<Bin> binList) {
        BinList = binList;
    }
}
