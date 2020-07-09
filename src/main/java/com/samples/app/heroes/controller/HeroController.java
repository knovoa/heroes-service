package com.samples.app.heroes.controller;

import com.samples.app.heroes.bean.HeroDTO;
import com.samples.app.heroes.model.Hero;
import com.samples.app.heroes.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE })
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/heroes")
    public List<Hero> getHeroes(@RequestParam(name = "term", required = false) String term) {
        return heroService.getHeroes(term);
    }

    @GetMapping("/heroes/{id}")
    public Hero getHeroById(@PathVariable Long id) {
        return heroService.getHeroById(id);
    }

    @PostMapping("/heroes")
    public ResponseEntity<HeroDTO> create(@RequestBody HeroDTO heroDTO) {
        HeroDTO newHero = heroService.save(heroDTO);
        return new ResponseEntity<>(newHero, HttpStatus.CREATED);
    }

    @PutMapping("/heroes/{id}")
    public ResponseEntity<HeroDTO> update(@RequestBody HeroDTO heroDTO, @PathVariable Long id) {
        HeroDTO updatedHero = heroService.update(heroDTO, id);
        return new ResponseEntity<>(updatedHero, HttpStatus.CREATED);
    }

    @DeleteMapping("/heroes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        heroService.delete(id);
    }
}
