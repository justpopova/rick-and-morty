package com.springboot.rickandmorty.controller;

import com.springboot.rickandmorty.dto.CharacterResponseDto;
import com.springboot.rickandmorty.dto.mapper.MovieCharacterMapper;
import com.springboot.rickandmorty.model.MovieCharacter;
import com.springboot.rickandmorty.service.MovieCharacterService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-characters")
public class MovieCharacterController {
    private final MovieCharacterService characterService;
    private final MovieCharacterMapper mapper;

    public MovieCharacterController(MovieCharacterService characterService,
                                    MovieCharacterMapper mapper) {
        this.characterService = characterService;
        this.mapper = mapper;
    }

    @GetMapping("/random")
    @ApiOperation(value = "det random character")
    public CharacterResponseDto getRandom() {
        MovieCharacter character = characterService.getRandomCharacter();
        return mapper.toResponseDto(character);
    }

    @GetMapping("/by-name")
    @ApiOperation(value = "get character by name")
    public List<CharacterResponseDto> findAllByName(@RequestParam("name") String namePart) {
        return characterService.findAllByNameContains(namePart)
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
