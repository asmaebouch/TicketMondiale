package com.example.demo.Config;

import com.example.demo.controller.CustomerSoapService;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CXFSoapWebServiceConfig {
@Autowired
    private Bus bus;
@Autowired

private CustomerSoapService customerSoapService;
@Bean
    public EndpointImpl endpoint(){
    EndpointImpl endpoint=new EndpointImpl(bus,customerSoapService);
    endpoint.publish("/CustomerService");
    return endpoint;
}





}
