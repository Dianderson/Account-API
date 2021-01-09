package br.com.mendonca.accountapi.resource.dto.response;

import br.com.mendonca.accountapi.repository.model.Customer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerResponse {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;

    public static CustomerResponse of(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setCpf(customer.getCpf());
        customerResponse.setBirthDate(customer.getBirthDate());
        return customerResponse;
    }
}
