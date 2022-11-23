package com.springboot.rickandmorty.repository;

import com.springboot.rickandmorty.model.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Long> {
    List<MovieCharacter> findAllByExternalIdIn(Set<Long> externalIds);

    List<MovieCharacter> findAllByNameContains(String namePart);
}
