package br.com.mendonca.accountapi.repository;

import br.com.mendonca.accountapi.repository.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
}
