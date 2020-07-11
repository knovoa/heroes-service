package com.samples.app.heroes.service;

import com.samples.app.heroes.model.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HeroServiceTest {

    @Autowired
    HeroService heroService;

    @Test
    void shouldGetAllHeroes() {
        List<Hero> heroes = heroService.getHeroes("");
        assertFalse(heroes.isEmpty());
    }

    @Test
    void shouldGetAllHeroesByTerm() {
        List<Hero> heroes = heroService.getHeroes("Wol");
        assertEquals(1, heroes.size());
    }

    @Test
    void shouldGetHeroById() {
        Hero hero = heroService.getHeroById(1L);
        assertEquals("Charles Xavier", hero.getName());
        assertEquals("Profesor X", hero.getAlias());
    }
}
