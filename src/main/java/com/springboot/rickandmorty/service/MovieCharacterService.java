package com.springboot.rickandmorty.service;

import com.springboot.rickandmorty.model.MovieCharacter;

import java.util.List;

public interface MovieCharacterService {
    void syncExternalCharacters();

    MovieCharacter getRandomCharacter();

    List<MovieCharacter> findAllByNameContains(String namePart);
}
