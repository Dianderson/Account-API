package br.com.mendonca.accountapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {

    @GetMapping
    public String teste(){
        return "Teste Controller!!!";
    }

}
