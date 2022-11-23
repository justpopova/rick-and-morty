package com.springboot.rickandmorty.dto;

import com.springboot.rickandmorty.model.Gender;
import com.springboot.rickandmorty.model.Status;
import lombok.Data;

@Data
public class CharacterResponseDto {
    private Long id;
    private Long externalId;
    private String name;
    private Status status;
    private Gender gender;
}
