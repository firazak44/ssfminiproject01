package com.vttp2022.ssfminiproject01.mvccontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpSession;

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

    String lookup;

    @Autowired
    User user;

    @Autowired
    ListsSvc listsSvc;

    @Autowired
    RedisRepo redisRepo;

    @GetMapping("/")
    public String login(Model model, @RequestParam(required = !true) String userName, HttpSession session){
        model.addAttribute("username", userName);
        return "index";
    }

    @GetMapping("/index")
    public String getinBSL(Model model, @RequestParam(required = !true) String userName){
        model.addAttribute("username", userName);
        // this.user=userName;
        return "lookupBSL";
    }

    @GetMapping("/lists/best-sellers")
    public String lookupBSL(Model model,@RequestParam(required = !true) String looKup,@RequestParam(required = !true) String username) {
        lookup = looKup;
        CopyOnWriteArrayList<Lists> lists = listsSvc.getLists(looKup);
        redisRepo.setLookuplists(lists);
        user = redisRepo.getUser(username);
        // try {
        //     lists = listsSvc.getLists(looKup);

        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        model.addAttribute("username", username);
        model.addAttribute("lookup", lookup);
        model.addAttribute("results", lists);
        return "lookupBSLres";
    }

}
