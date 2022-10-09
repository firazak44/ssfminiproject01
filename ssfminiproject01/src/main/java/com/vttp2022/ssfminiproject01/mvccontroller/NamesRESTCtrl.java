package com.vttp2022.ssfminiproject01.mvccontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vttp2022.ssfminiproject01.mvcmodels.Names;
import com.vttp2022.ssfminiproject01.mvcservice.NamesSvc;

@RestController

public class NamesRESTCtrl {
    private static final Logger logger = LoggerFactory.getLogger(NamesCtrl.class);

    @Autowired
    NamesSvc namesSvc;

    @GetMapping ("/api/lists/names")
    public Names getNames(Model model) throws Exception{
        logger.info(" " + namesSvc.getNameLists());
        return namesSvc.getNameLists();
    }

}
