package com.tekarch.accounts_module.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("/accounts")
    public String getUser(){
        return "This is a Account_Module";
    }
}
