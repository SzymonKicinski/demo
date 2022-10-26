package com.person.demo.configuration;

import com.person.demo.service.PersonEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(PersonEndpoint personEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, personEndpoint);
        endpoint.publish("/service/person");
        return endpoint;
    }
}
