package com.samples.app.heroes.service;

import com.samples.app.heroes.bean.HeroDTO;
import com.samples.app.heroes.model.Hero;

import java.util.List;

public interface HeroService {

    List<Hero> getHeroes(String term);
    Hero getHeroById(Long id);
    HeroDTO save(HeroDTO heroDTO);
    HeroDTO update(HeroDTO heroDTO, Long id);
    void delete(Long id);
}
