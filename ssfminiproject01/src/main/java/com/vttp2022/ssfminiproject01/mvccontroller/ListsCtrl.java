package com.vttp2022.ssfminiproject01.mvccontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vttp2022.ssfminiproject01.mvcmodels.Lists;
import com.vttp2022.ssfminiproject01.mvcmodels.User;
import com.vttp2022.ssfminiproject01.mvcservice.ListsSvc;
import com.vttp2022.ssfminiproject01.mvcservice.RedisRepo;

@Controller
@RequestMapping("/")
public class ListsCtrl {

    @Autowired
    User user;

    @Autowired
    ListsSvc listsSvc;

    @Autowired
    RedisRepo redisrepo;

    @GetMapping("/index")
    public String getToIndex(Model model, @RequestParam(required = !true) String userName){
        model.addAttribute("username", userName);
        // this.user=userName;
        return "lookupBSL";
    }

    @GetMapping("/lists/best-sellers")
    public String lookupBSL(Model model,@RequestParam(required = !true) String looKup,@RequestParam(required = !true) User username){
        String lookup = looKup;
        CopyOnWriteArrayList<Lists> lists = listsSvc.getLists(looKup);
        redisrepo.setLookuplists(lists);
        user = redisrepo.getUsername(username);

        model.addAttribute("user", user);
        model.addAttribute("lookup", lookup);
        model.addAttribute("results", lists);
        return "lookupBSLres";
    }

    // @GetMapping("/result")
    // public String getResult(Model model){
    //     model.addAttribute("username", user);
    //     return "result";
    // }

}
