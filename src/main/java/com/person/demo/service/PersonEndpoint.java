/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.person.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Service;
import person.*;

@Service
@Slf4j
@Features(features = "org.apache.cxf.ext.logging.LoggingFeature")
public class PersonEndpoint implements PersonServicePortType {

    BackendService backendService;

    public PersonEndpoint(BackendService backendService) {
        this.backendService = backendService;
    }

    @Override
    public PersonsResponse getPersonsByName(PersonByNameRequest parameters) {
        PersonsResponse personsResponse = new PersonsResponse();
        try {
            personsResponse.getPerson().addAll(
                    backendService.getPersonsByName(parameters.getFirstname(),
                            parameters.getLastname()));
        } catch (Exception e) {
            log.error("Error while setting values for person object", e);
        }
        return personsResponse;
    }

    @Override
    public PersonResponse getPersonById(PersonByIdRequest parameters) {
        PersonResponse personResponse = new PersonResponse();
        try {
            personResponse.setPerson(backendService.getPersonById(parameters.getId()));
        }  catch (Exception e) {
            log.error("Error while setting values for person object", e);
        }
        return personResponse;
    }

    @Override
    public PersonResponse getPersonByPesel(PersonByPeselRequest parameters) {
        PersonResponse personResponse = new PersonResponse();
        try {
            personResponse.setPerson(backendService.getPersonByPesel(parameters.getPesel()));
        }  catch (Exception e) {
            log.error("Error while setting values for person object", e);
        }
        return personResponse;
    }
}
