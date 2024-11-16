package org.bel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.bel.util.model.StandardResponse;
@RestController
public class HomeController {


    @GetMapping("/")
    public StandardResponse<String> home() {
        return new StandardResponse<String>(true, "Hello, World!", null);

    }


}