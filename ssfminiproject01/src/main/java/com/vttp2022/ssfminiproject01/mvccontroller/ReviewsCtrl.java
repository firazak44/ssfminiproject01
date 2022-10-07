package com.vttp2022.ssfminiproject01.mvccontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vttp2022.ssfminiproject01.mvcmodels.Query;
import com.vttp2022.ssfminiproject01.mvcmodels.Reviews;
import com.vttp2022.ssfminiproject01.mvcservice.ReviewsSvc;

@Controller
// @RequestMapping(path="/reviews")
public class ReviewsCtrl {
    
    @Autowired
    ReviewsSvc reviewsSvc;

    @GetMapping("/reviews")
    public String search(Model model,
        @RequestParam int isbn,
        @RequestParam String title,
        @RequestParam String author){
        Query q = new Query();
        q.setIsbn(isbn);
        q.setTitle(title);
        q.setAuthor(author);
        List<Reviews> rv = reviewsSvc.getReviews(q);
        model.addAttribute("isbn", isbn);
        model.addAttribute("title", title);
        model.addAttribute("author", author);
        model.addAttribute("results", rv);
        return "indexsearchBR";
    }

}
