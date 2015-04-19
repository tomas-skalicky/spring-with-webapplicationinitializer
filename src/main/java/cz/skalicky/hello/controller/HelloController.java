package cz.skalicky.hello.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 05.08.2014
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@RestController
@RequestMapping("")
public class HelloController {

    @RequestMapping(value = "/world/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(value = "/tom/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloTom() {
        return "Hello Tom";
    }

}
