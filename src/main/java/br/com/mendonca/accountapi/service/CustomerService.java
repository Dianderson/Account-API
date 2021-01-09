package br.com.mendonca.accountapi.service;

import br.com.mendonca.accountapi.repository.CustomerRepository;
import br.com.mendonca.accountapi.repository.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
