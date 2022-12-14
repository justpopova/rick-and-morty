package com.springboot.rickandmorty.controller;

import com.springboot.rickandmorty.model.Gender;
import com.springboot.rickandmorty.model.MovieCharacter;
import com.springboot.rickandmorty.model.Status;
import com.springboot.rickandmorty.service.MovieCharacterService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MovieCharacterControllerTest {
    @MockBean
    private MovieCharacterService characterService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldReturnRandomCharacter() {
        MovieCharacter rick = new MovieCharacter();
        rick.setId(1L);
        rick.setExternalId(1L);
        rick.setName("Rick Sanchez");
        rick.setGender(Gender.valueOf("MALE"));
        rick.setStatus(Status.valueOf("ALIVE"));

        Mockito.when(characterService.getRandomCharacter()).thenReturn(rick);

        RestAssuredMockMvc.when()
                .get("movie-characters/random")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(1))
                .body("name", Matchers.equalTo("Rick Sanchez"))
                .body("status", Matchers.equalTo("ALIVE"))
                .body("gender", Matchers.equalTo("MALE"));
    }

    @Test
    public void shouldFindCharacterByNamePart() {
        MovieCharacter rick = new MovieCharacter();
        rick.setId(1L);
        rick.setExternalId(1L);
        rick.setName("Rick Sanchez");
        rick.setGender(Gender.valueOf("MALE"));
        rick.setStatus(Status.valueOf("ALIVE"));

        MovieCharacter morty = new MovieCharacter();
        morty.setId(2L);
        morty.setExternalId(2L);
        morty.setName("Morty Smith");
        morty.setGender(Gender.valueOf("MALE"));
        morty.setStatus(Status.valueOf("ALIVE"));

        List<MovieCharacter> characters = new ArrayList<>();
        characters.add(rick);
        characters.add(morty);

        String namePart = "Sm";

        Mockito.when(characterService.findAllByNameContains(namePart)).thenReturn(characters);

        RestAssuredMockMvc
                .given()
                .queryParam("name", namePart)
                .when()
                .get("/movie-characters/by-name")
                .then()
                .statusCode(200)
                .body("size()", Matchers.equalTo(2))
                .body("[0].id", Matchers.equalTo(1))
                .body("[0].externalId", Matchers.equalTo(1))
                .body("[0].name", Matchers.equalTo("Rick Sanchez"))
                .body("[0].gender", Matchers.equalTo("MALE"))
                .body("[0].status", Matchers.equalTo("ALIVE"))
                .body("[1].id", Matchers.equalTo(2))
                .body("[1].externalId", Matchers.equalTo(2))
                .body("[1].name", Matchers.equalTo("Morty Smith"))
                .body("[1].gender", Matchers.equalTo("MALE"))
                .body("[1].status", Matchers.equalTo("ALIVE"));
    }
}