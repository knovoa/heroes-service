package com.samples.app.heroes.service;

import com.samples.app.heroes.bean.HeroDTO;
import com.samples.app.heroes.model.Hero;
import com.samples.app.heroes.repository.HeroRepository;
import com.samples.app.heroes.transfer.HeroTransfer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final HeroTransfer heroTransfer;

    public HeroServiceImpl(HeroRepository heroRepository, HeroTransfer heroTransfer) {
        this.heroRepository = heroRepository;
        this.heroTransfer = heroTransfer;
    }

    @Transactional(readOnly = true)
    public List<Hero> getHeroes(String term) {
        List<Hero> heroes = new ArrayList<>();
        if (term != null && !term.isEmpty()) {
            heroRepository.findByTerm(term).forEach(heroes::add);
        } else {
            heroRepository.findAll().forEach(heroes::add);
        }
        return heroes;
    }

    @Transactional(readOnly = true)
    public Hero getHeroById(Long id) {
        final Optional<Hero> game = heroRepository.findById(id);
        return game.orElse(null);
    }

    @Transactional
    public HeroDTO save(HeroDTO heroDTO) {
        return heroTransfer.transferHeroDTO(heroRepository.save(heroTransfer.transferHero(heroDTO)));
    }

    @Transactional
    public HeroDTO update(HeroDTO heroDTO, Long id) {
        Hero existingHero = getHeroById(id);
        existingHero.setName(heroDTO.getName());
        existingHero.setAlias(heroDTO.getAlias());
        Hero updatedHero = heroRepository.save(existingHero);
        return heroTransfer.transferHeroDTO(updatedHero);
    }

    @Transactional
    public void delete(Long id) {
        heroRepository.deleteById(id);
    }
}
