package com.springboot.rickandmorty.service;

import com.springboot.rickandmorty.model.Gender;
import com.springboot.rickandmorty.model.MovieCharacter;
import com.springboot.rickandmorty.model.Status;
import com.springboot.rickandmorty.repository.MovieCharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class MovieCharacterServiceImplTest {

    @Mock
    private MovieCharacterService movieCharacterService;

    @Test
    void saveDtosToDb() {
        MovieCharacter bethSmith = new MovieCharacter();
        bethSmith.setName("Beth Smith");
        bethSmith.setStatus(Status.ALIVE);
        bethSmith.setGender(Gender.FEMALE);

        MovieCharacter albertEinstein = new MovieCharacter();
        albertEinstein.setName("Albert Einstein");
        albertEinstein.setStatus(Status.DEAD);
        albertEinstein.setGender(Gender.MALE);
    }
}