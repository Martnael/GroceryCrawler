package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.Services;

@RequestMapping("grocerycrawler")
@RestController
public class CrawlerController {

    @Autowired
    private Services crawlerServices;

    @GetMapping("updatecategories")
    public void updateCategories() {

    }

}
