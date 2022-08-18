package ch.swiss.km.angulartourofheroesbackend.repositories;

import ch.swiss.km.angulartourofheroesbackend.models.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
