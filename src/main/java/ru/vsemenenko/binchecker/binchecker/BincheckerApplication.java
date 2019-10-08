package ru.vsemenenko.binchecker.binchecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.vsemenenko.binchecker.binchecker.model.Bin;
import ru.vsemenenko.binchecker.binchecker.service.BinService;
import ru.vsemenenko.binchecker.binchecker.testdata.TestData;

@SpringBootApplication
public class BincheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BincheckerApplication.class, args);
    }

    @Bean(initMethod = "initData")
    public TestData initialData() {
        return new TestData();
    }

}
