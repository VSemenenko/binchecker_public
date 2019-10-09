package ru.vsemenenko.binchecker.binchecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.vsemenenko.binchecker.binchecker.model.Bin;
import ru.vsemenenko.binchecker.binchecker.service.BinService;

import java.util.List;

@RestController
public class BinRestController {

    @Autowired
    BinService binService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Bin mvcmethod(@RequestParam(value = "value")int value){
        int val = value;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Bin> response = restTemplate.exchange(
                "https://lookup.binlist.net/"+value,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Bin>(){});
        Bin bin = response.getBody();
        return bin;
    }
}
