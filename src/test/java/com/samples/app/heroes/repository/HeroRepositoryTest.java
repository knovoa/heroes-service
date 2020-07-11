package com.samples.app.heroes.repository;

import com.samples.app.heroes.model.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class HeroRepositoryTest {

    @Autowired
    private HeroRepository heroRepository;

    @Test
    void shouldGetAllHeroes() {
        Iterable<Hero> heroes = heroRepository.findAll();
        assertThat(heroes).isNotEmpty();
    }

    @Test
    void shouldGetHeroById() {
        Optional<Hero> optionalHero = heroRepository.findById(1L);
        assertThat(optionalHero).isPresent();
        assertThat(optionalHero.get().getName()).isEqualTo("Charles Xavier");
        assertThat(optionalHero.get().getAlias()).isEqualTo("Profesor X");
    }

    @Test
    void shouldAddNewHero() {
        Hero newHero = new Hero();
        newHero.setName("Tony Stark");
        newHero.setAlias("Ironman");
        Hero hero = heroRepository.save(newHero);
        assertThat(hero.getId()).isNotNull();
        assertThat(hero.getId()).isInstanceOf(Long.class);
    }
}
