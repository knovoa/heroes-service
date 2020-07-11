package com.samples.app.heroes.service;

import com.samples.app.heroes.model.Hero;
import com.samples.app.heroes.repository.HeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroServiceMockTest {

    @Mock
    private HeroRepository heroRepository;

    @InjectMocks
    private HeroServiceImpl heroService;

    @Test
    void shouldReturnAllHeroesFromMockList() {
        Hero hero = new Hero();
        hero.setId(1L);
        hero.setName("Peter Parker");
        hero.setAlias("Spiderman");

        Iterable<Hero> heroes = Collections.singletonList(hero);
        when(heroRepository.findAll()).thenReturn(heroes);
        assertThat(heroService.getHeroes(null).size()).isEqualTo(1);
    }
}
