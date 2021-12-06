package searchbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import searchbar.ResultDTO;
import searchbar.enumeration.SearchByEnum;
import searchbar.service.SearchbarService;

@RestController
public class SearchbarController {

    @Autowired
    private SearchbarService service;

    @GetMapping("/menu")
    public ResultDTO getMenu(@RequestParam("searchby") String searchBy, @RequestParam String term) {
        return service.getMenu(searchBy, term);
    }

}