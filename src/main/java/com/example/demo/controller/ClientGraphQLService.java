package com.example.demo.controller;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.dto.CustomerRequest;
//import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@AllArgsConstructor
public class ClientGraphQLService {
private ClientRepository clientRepository;
private CustomerMapper customerMapper;
@QueryMapping
public List<Client> allCustomers(){
    return clientRepository.findAll();
}
@QueryMapping
    public Client customerById(@Argument Long id){
        return clientRepository.findById(id).get() ;
    }
    @MutationMapping
    public Client saveCustomer(@Argument CustomerRequest customer){
  Client c= customerMapper.from(customer);
    return clientRepository.save(c);
    }
}
