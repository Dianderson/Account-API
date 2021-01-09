package br.com.mendonca.accountapi.resource;

import br.com.mendonca.accountapi.repository.model.Customer;
import br.com.mendonca.accountapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer")
public class CustomerResource {

    private final CustomerRepository customerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody @Valid Customer customer){
        return customerRepository.save(customer);
    }

}
