package com.example.demo.controller;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.dto.CustomerRequest;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Client;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@WebService(serviceName = "CustomerWS")
public class CustomerSoapService {
    private ClientRepository  clientRepository;
   private CustomerMapper customerMapper;
   @WebMethod
    public List<Client> clientList(){
        return clientRepository.findAll();
    }
    @WebMethod
    public Client clientById(@WebParam Long id){
       return clientRepository.findById(id).get();
    }
    @WebMethod
    public Client saveCustomer(@WebParam(name="customer") CustomerRequest customerRequest){
   Client client    =customerMapper.from(customerRequest);
       return  clientRepository.save(client);
    }






}
