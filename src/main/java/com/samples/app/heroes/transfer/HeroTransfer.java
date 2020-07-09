package com.samples.app.heroes.transfer;

import com.samples.app.heroes.bean.HeroDTO;
import com.samples.app.heroes.model.Hero;
import org.springframework.stereotype.Component;

@Component
public class HeroTransfer {

    public Hero transferHero(HeroDTO heroDTO) {
        Hero hero = new Hero();
        hero.setId(heroDTO.getId());
        hero.setName(heroDTO.getName());
        hero.setAlias(heroDTO.getAlias());
        return hero;
    }

    public HeroDTO transferHeroDTO(Hero hero) {
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(hero.getId());
        heroDTO.setName(hero.getName());
        heroDTO.setAlias(hero.getAlias());
        return heroDTO;
    }
}
