package br.com.mendonca.accountapi.repository;

import br.com.mendonca.accountapi.repository.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
