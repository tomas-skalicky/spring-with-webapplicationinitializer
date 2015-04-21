package cz.skalicky.hello.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 05.08.2014
 */
@Controller
@RequestMapping("")
public class HelloController {

    @RequestMapping(value = "/world/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(value = "/tom/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String goodMorningTom() {
        return "Good morning Tom";
    }

}
