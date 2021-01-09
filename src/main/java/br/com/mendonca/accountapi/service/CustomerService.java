package br.com.mendonca.accountapi.service;

import br.com.mendonca.accountapi.repository.CustomerRepository;
import br.com.mendonca.accountapi.repository.model.Customer;
import br.com.mendonca.accountapi.resource.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse save(Customer customer) {
        return CustomerResponse.of(customerRepository.save(customer));
    }
}
