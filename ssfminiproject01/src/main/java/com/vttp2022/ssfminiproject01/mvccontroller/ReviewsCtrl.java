package com.vttp2022.ssfminiproject01.mvccontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vttp2022.ssfminiproject01.mvcmodels.Reviews;
import com.vttp2022.ssfminiproject01.mvcservice.ReviewsSvc;

@Controller
@RequestMapping("/")
public class ReviewsCtrl {
    
    @Autowired
    private ReviewsSvc reviewsSvc;

    @GetMapping("/reviews.json")
    public String getReviews(Model model){
        Optional<Reviews> opt = reviewsSvc.getReviews();
        if(opt.isEmpty()) return "results";
        model.addAttribute("results", opt.get());
        return "results";
    }
}
