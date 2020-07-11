package com.samples.app.heroes.service;

import com.samples.app.heroes.model.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class HeroServiceTest {

    @Autowired
    HeroService heroService;

    @Test
    void shouldGetAllHeroesWhenTermIsNull() {
        List<Hero> heroes = heroService.getHeroes(null);
        assertThat(heroes).isNotNull().isNotEmpty();
    }

    @Test
    void shouldGetAllHeroesWhenTermIsEmpty() {
        List<Hero> heroes = heroService.getHeroes("");
        assertThat(heroes).isNotNull().isNotEmpty();
    }

    @Test
    void shouldGetAllHeroesByTerm() {
        List<Hero> heroes = heroService.getHeroes("Wol");
        assertThat(heroes.size()).isEqualTo(1);
        assertThat(heroes.get(0).getName()).isEqualTo("James Howlett");
    }

    @Test
    void shouldGetHeroById() {
        Hero hero = heroService.getHeroById(1L);
        assertThat(hero).isNotNull();
        assertThat(hero.getName()).isEqualTo("Charles Xavier");
    }
}
