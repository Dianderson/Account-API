package br.com.mendonca.accountapi.service;

import br.com.mendonca.accountapi.repository.CustomerRepository;
import br.com.mendonca.accountapi.repository.model.Customer;
import br.com.mendonca.accountapi.resource.dto.response.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
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
        Customer customerToBeUpdated = customerRepository
                .findById(customer.getId())
                .orElseThrow(() -> new RuntimeException(String.format("Customer with id %s not found", customer.getId())));

        if (customer.getName() != null && !customer.getName().isEmpty()) {
            customerToBeUpdated.setName(customer.getName());
        }
        if (customer.getEmail() != null && !customer.getEmail().isEmpty()) {
            customerToBeUpdated.setEmail(customer.getEmail());
        }

        return CustomerResponse.of(customerRepository.save(customerToBeUpdated));
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
