package ru.vsemenenko.binchecker.binchecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vsemenenko.binchecker.binchecker.model.Bin;
import ru.vsemenenko.binchecker.binchecker.service.BinService;

import java.net.URL;
import java.util.List;

@Controller
public class BinController {

    @Autowired
    BinService binService;

    @RequestMapping("/")
    public String adminPage(Model model) {
        List<Bin> binList = binService.getLastTen();
        model.addAttribute("bins", binList);
        return "index";
    }
}
