package com.example.demo.mapper;

import com.example.demo.dto.CustomerRequest;
import com.example.demo.model.Client;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
@Component
public class CustomerMapper {
private ModelMapper modelMapper=new ModelMapper();
    public Client from(CustomerRequest customerRequest){
       // Client client=new Client();
      //  client.setNom(customerRequest.Nom());
        //client.setAddress(customerRequest.Address());
       //
        //client.setTelephone(customerRequest.telephone());
        return      modelMapper.map(customerRequest,Client.class);



    }
}
