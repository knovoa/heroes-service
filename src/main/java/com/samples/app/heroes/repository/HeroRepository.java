package com.samples.app.heroes.repository;

import com.samples.app.heroes.model.Hero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    @Query("SELECT H FROM TB_HERO H " +
            "WHERE LOWER(H.name) LIKE LOWER(concat('%', concat(?1, '%'))) " +
            "OR LOWER(H.alias) LIKE LOWER(concat('%', concat(?1, '%')))")
    Iterable<Hero> findByTerm(String term);
}
