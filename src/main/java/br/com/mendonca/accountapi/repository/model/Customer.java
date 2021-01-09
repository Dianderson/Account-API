package br.com.mendonca.accountapi.repository.model;

import br.com.mendonca.accountapi.resource.dto.request.CreateCustomerRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Column(unique = true)
    private String email;
    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;
    @NotNull
    private LocalDate birthDate;

    public static Customer of(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setCpf(request.getCpf());
        customer.setBirthDate(request.getBirthDate());
        return customer;
    }
}
