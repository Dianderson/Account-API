package br.com.mendonca.accountapi.service;

import br.com.mendonca.accountapi.repository.CustomerRepository;
import br.com.mendonca.accountapi.repository.model.Customer;
import br.com.mendonca.accountapi.resource.dto.request.UpdateCustomerRequest;
import br.com.mendonca.accountapi.resource.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse save(Customer customer) {
        return CustomerResponse.of(customerRepository.save(customer));
    }

    public CustomerResponse findById(Long id) {
        return customerRepository
                .findById(id)
                .map(CustomerResponse::of)
                .orElseThrow(() -> new RuntimeException(String.format("Customer with id %s not found", id)));
    }

    public CustomerResponse update(Customer customer) {
        return CustomerResponse.of(customerRepository.save(customer));
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerResponse> findAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(CustomerResponse::of)
                .collect(Collectors.toList());
    }
}
