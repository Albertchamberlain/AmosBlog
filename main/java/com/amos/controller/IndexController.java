package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Amos
 * @date 2020-10-27 23:39
 */


@Controller
public class IndexController {
    @GetMapping("/")
    public String index()
    {
        return "index";
    }
}
