package ru.vsemenenko.binchecker.binchecker.testdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vsemenenko.binchecker.binchecker.model.Bank;
import ru.vsemenenko.binchecker.binchecker.model.Bin;
import ru.vsemenenko.binchecker.binchecker.model.Country;
import ru.vsemenenko.binchecker.binchecker.service.BinService;

import java.util.Random;

@Component
public class TestData {

    @Autowired
    BinService binService;

 public void initData(){
        for(int i = 0; i<15; i++){
            binService.add(getBin());
        }
    }

    private Bin getBin(){
       return new Bin(Integer.parseInt(String.format("%06d", new Random().nextInt(999999))), "mastercard", "credit","Platinum",
                new Country("RU", "Russian Federation", "RUB",
                        60, 100), new Bank("SAVINGS BANK OF THE RUSSIAN FEDERATION (SBERBANK)", "www.sbrf.ru"));
    }
}
