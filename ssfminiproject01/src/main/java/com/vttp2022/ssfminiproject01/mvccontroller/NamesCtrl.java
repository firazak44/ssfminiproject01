package com.vttp2022.ssfminiproject01.mvccontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vttp2022.ssfminiproject01.mvcmodels.Names;
import com.vttp2022.ssfminiproject01.mvcmodels.Results;
import com.vttp2022.ssfminiproject01.mvcservice.NamesSvc;

@Controller
public class NamesCtrl {

    @Autowired
    NamesSvc namesSvc;

    @GetMapping ("/lists/names")
    public String getNames(MultiValueMap<String, String> value, Model model){
        String bkl = value.getFirst("list");
        List<NamesSvc> bkn = new ArrayList<NamesSvc>();
        model.addAttribute("bknl", bkn);
       return "bknList";
    }

}
