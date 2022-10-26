/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package com.person.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.feature.Features;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Features(features = "org.apache.cxf.ext.logging.LoggingFeature")
public class PersonEndpoint {

    BackendService backendService;

    public PersonEndpoint(BackendService backendService) {
        this.backendService = backendService;
    }


}
