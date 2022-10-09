package com.vttp2022.ssfminiproject01.mvccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vttp2022.ssfminiproject01.mvcmodels.Reviews;
import com.vttp2022.ssfminiproject01.mvcmodels.User;
import com.vttp2022.ssfminiproject01.mvcservice.RedisRepo;
import com.vttp2022.ssfminiproject01.mvcservice.ReviewsSvc;

@Controller
@RequestMapping("/reviews")
public class ReviewsCtrl {
    
    @Autowired
    ReviewsSvc reviewsSvc;

    @Autowired
    RedisRepo redisrepo;
    
    @Autowired
    User user;
    
    @GetMapping("/searchreviews")
    public String search(Model model,
        @RequestParam (required = !true)String title,
        @RequestParam (required = !true)String author){
        model.addAttribute("title", title);
        model.addAttribute("author", author);
        return "indexsearchlistBR";
    }

}
