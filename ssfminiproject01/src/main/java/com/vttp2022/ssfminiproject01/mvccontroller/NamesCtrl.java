package com.vttp2022.ssfminiproject01.mvccontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vttp2022.ssfminiproject01.mvcmodels.Names;
import com.vttp2022.ssfminiproject01.mvcservice.NamesSvc;

@Controller
public class NamesCtrl {
    
    @Autowired
    private NamesSvc namesSvc;

    @GetMapping
    public String getNames(Model model){
        Optional<Names> opt = namesSvc.getNames();
        if(opt.isEmpty()) return "results";
        model.addAttribute("results", opt.get());
        return "results";
    }
}
