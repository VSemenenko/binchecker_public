package ru.vsemenenko.binchecker.binchecker.testdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vsemenenko.binchecker.binchecker.model.Bin;
import ru.vsemenenko.binchecker.binchecker.service.BinService;

@Component
public class TestData {

    @Autowired
    BinService binService;

 public void initData(){
        binService.add(new Bin(789465));
        binService.add(new Bin(741258));
        binService.add(new Bin(852369));
        binService.add(new Bin(654489));
        binService.add(new Bin(122468));
        binService.add(new Bin(794231));
        binService.add(new Bin(456876));
        binService.add(new Bin(851367));
        binService.add(new Bin(916473));
        binService.add(new Bin(975346));
        binService.add(new Bin(964178));
        binService.add(new Bin(163894));
        binService.add(new Bin(266841));
        binService.add(new Bin(321697));
    }
}
