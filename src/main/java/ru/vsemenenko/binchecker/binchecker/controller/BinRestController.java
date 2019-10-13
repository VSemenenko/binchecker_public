package ru.vsemenenko.binchecker.binchecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.vsemenenko.binchecker.binchecker.dto.BankBinListDTO;
import ru.vsemenenko.binchecker.binchecker.model.Bank;
import ru.vsemenenko.binchecker.binchecker.model.Bin;
import ru.vsemenenko.binchecker.binchecker.service.BinService;

import java.util.List;

@RestController
public class BinRestController {

    @Autowired
    BinService binService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<BankBinListDTO> checkBin(@RequestBody Bin bin){
        Bank bank;
        if(binService.checkBin(bin)){
            bank =  binService.getBankByBinValue(bin);
            return new ResponseEntity<BankBinListDTO>(new BankBinListDTO(bank, null),HttpStatus.OK);
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Bin> response = restTemplate.exchange(
                "https://lookup.binlist.net/" + bin.getValue(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Bin>() {
                });
        if(HttpStatus.OK.equals(response.getStatusCode())){
            bin.compliteBin(response.getBody());
            binService.add(bin);
        } else {
            return new ResponseEntity<BankBinListDTO>((BankBinListDTO) null, HttpStatus.NOT_FOUND);
        }
//        if(!binService.checkBin(bin)) {
//            RestTemplate restTemplate = new RestTemplate();
//        int binValue = bin.getValue();
//        ResponseEntity<Bin> response = restTemplate.exchange(
//                "https://lookup.binlist.net/" + binValue,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<Bin>() {
//                });
//        if(HttpStatus.OK.equals(response.getStatusCode())){
//            bin = response.getBody();
//            bin.setValue(binValue);
//            binService.add(bin);
//        }
//    }else {
//        bin = binService.getByValue(bin);
//    }
        return new ResponseEntity<BankBinListDTO>(new BankBinListDTO(bin.getBank(), binService.getLastTen()), HttpStatus.OK);
    }
}
