package br.com.mendonca.accountapi.resource.dto.request;

import lombok.Data;

@Data
public class UpdateCustomerRequest {

    private String name;
    private String email;

}
