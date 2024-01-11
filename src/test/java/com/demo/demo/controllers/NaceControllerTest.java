package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import com.demo.demo.services.NaceDataService;
import com.demo.demo.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.assertj.core.api.Assertions.assertThat;


public class NaceControllerTest extends AbstractTest {

    @Autowired
    private NaceDataService service;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    /** GET METHODS TEST*/
    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
        NaceEntity expected = TestUtils.createEntity(996L, 4, "99", "99",
                "Activities of extraterritorial organisations and bodies", "null- activities of international organisations such as the United Nations and the specialised agencies of the United Nations system, regional bodies etc., the International Monetary Fund, the World Bank, the World Customs Organisation, the Organisation f",
                "null- activities of diplomatic and consular missions when being determined by the country of their location rather than by the country they represent\"",
                "", "", "9900");

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.get("/nace/996")
                                .accept(MediaType.APPLICATION_JSON))
                        .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(mapToJson(expected));
    }

    @Test
    public void returns404whenNoEntityFound() throws Exception {

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.get("/nace/20000000")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void returns404whenWrongURL() throws Exception {

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.get("/naces/2")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void returns400whenBadRequest() throws Exception {

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.get("/nace/badRequest")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    /** PUT METHODS TEST*/
    @Test
    public void modifyByIdWhenExists() throws Exception {
        // given
        NaceEntity expected = TestUtils.createEntity(996L, 4, "99", "99",
                "Description modified",
                "Item includes modified",
                "other modifications",
                "", "", "9900");

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.put("/nace/996")
                                .header("Content-Type", "application/json")
                                .content(mapToJson(expected))
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(mapToJson(expected));
    }

    @Test
    public void addWhenDoesNotExists() throws Exception {
        // given
        NaceEntity expected = TestUtils.createEntity(2L, 4, "99", "99",
                "Description modified",
                "Item includes modified",
                "other modifications",
                "", "", "9900");

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.put("/nace/997")
                                .header("Content-Type", "application/json")
                                .content(mapToJson(expected))
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).contains(mapToJson(expected).substring(0,9));
        assertThat(response.getContentAsString()).contains(mapToJson(expected).substring(13));
    }


    /** PUT METHODS TEST - MODIFY-CREATE*/
    @Test
    public void canModifyByIdWhenExistsTest() throws Exception {
        // given
        NaceEntity expected = TestUtils.createEntity(996L, 4, "99", "99",
                "Description modified",
                "Item includes modified",
                "other modifications",
                "", "", "9900");

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.put("/naceTests/996")
                                .header("Content-Type", "application/json")
                                .content(mapToJson(expected))
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(mapToJson(expected));
    }

    @Test
    public void canCreateWhenNotExistsTest() throws Exception {
        // given
        NaceEntity expected = TestUtils.createEntity(null, 4, "99", "99",
                "Description modified",
                "Item includes modified",
                "other modifications",
                "", "", "9900");

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.put("/naceTests/2000")
                                .header("Content-Type", "application/json")
                                .content(mapToJson(expected))
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).contains(mapToJson(expected).substring(0,9));
        assertThat(response.getContentAsString()).contains(mapToJson(expected).substring(13));


    }

    @ParameterizedTest
    @ValueSource(strings = {"/nace/2", "/naceTests/2"})
    public void givenPutMethodsThenreturn400WhenBadRequest(String url) throws Exception {

        // when
        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.put(url)
                                .header("Content-Type", "application/json")
                                .content("Bad Request")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
         }

}
