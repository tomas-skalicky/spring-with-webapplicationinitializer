package cz.skalicky.hello.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.skalicky.hello.config.ComponentScanConfig;

/**
 * @author Tomas Skalicky
 *         <p>
 *         Created on 05.08.2014
 *         <p>
 *         Copyright (c) 2014, Check24 Vergleichsportal GmbH
 */
@ContextConfiguration(classes = ComponentScanConfig.class)
@WebAppConfiguration
public class HelloIT extends AbstractTestNGSpringContextTests {

    @Inject
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeMethod
    public void initMockMvc() {

        mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void shouldReturnHelloWorld() throws Exception {

        // @formatter:off
        final MvcResult result = mockMvc.perform(
                    get("/world/")
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        // @formatter:on

        final String responseString = result.getResponse().getContentAsString();
        assertThat(responseString, is("Hello World"));
    }

    @Test
    public void shouldReturnGoodMorningTom() throws Exception {

        // @formatter:off
        final MvcResult result = mockMvc.perform(
                    get("/tom/")
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        // @formatter:on

        final String responseString = result.getResponse().getContentAsString();
        assertThat(responseString, is("Good morning Tom"));
    }

}
