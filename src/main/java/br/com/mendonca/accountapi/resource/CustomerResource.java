package br.com.mendonca.accountapi.resource;

import br.com.mendonca.accountapi.repository.model.Customer;
import br.com.mendonca.accountapi.resource.dto.request.CreateCustomerRequest;
import br.com.mendonca.accountapi.resource.dto.response.CustomerResponse;
import br.com.mendonca.accountapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer")
public class CustomerResource {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse save(@RequestBody @Valid CreateCustomerRequest request) {
        return customerService.save(Customer.of(request));
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable Long id) {
        return customerService.findById(id);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }

    @GetMapping
    public List<CustomerResponse> findAll() {
        return customerService.findAll();
    }
}
