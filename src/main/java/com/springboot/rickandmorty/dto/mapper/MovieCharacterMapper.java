package com.springboot.rickandmorty.dto.mapper;

import com.springboot.rickandmorty.dto.CharacterResponseDto;
import com.springboot.rickandmorty.dto.external.ApiCharacterDto;
import com.springboot.rickandmorty.model.Gender;
import com.springboot.rickandmorty.model.MovieCharacter;
import com.springboot.rickandmorty.model.Status;
import org.springframework.stereotype.Component;

@Component
public class MovieCharacterMapper {

    public MovieCharacter parseApiCharacterResponseDto(ApiCharacterDto dto) {
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setName(dto.getName());
        movieCharacter.setGender(Gender.valueOf(dto.getGender().toUpperCase()));
        movieCharacter.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        movieCharacter.setExternalId(dto.getId());

        return movieCharacter;
    }

    public CharacterResponseDto toResponseDto(MovieCharacter movieCharacter) {
        CharacterResponseDto dto = new CharacterResponseDto();
        dto.setId(movieCharacter.getId());
        dto.setExternalId(movieCharacter.getExternalId());
        dto.setStatus(movieCharacter.getStatus());
        dto.setGender(movieCharacter.getGender());
        dto.setName(movieCharacter.getName());
        return dto;
    }
}
