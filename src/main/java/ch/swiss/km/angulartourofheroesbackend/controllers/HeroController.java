package ch.swiss.km.angulartourofheroesbackend.controllers;

import ch.swiss.km.angulartourofheroesbackend.exceptions.ResourceNotFoundException;
import ch.swiss.km.angulartourofheroesbackend.models.Hero;
import ch.swiss.km.angulartourofheroesbackend.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:4200")
@RestController()
@RequestMapping("/api/v1/")
public class HeroController {

    @Autowired
    HeroRepository heroRepository;

    @GetMapping("/heroes")
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @GetMapping("/hero/{id}")
    public Hero getHeroById(@PathVariable("id") long id) {
        return heroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hero with id " + id + "not found"));
    }

    @PostMapping("/heroes")
    public Hero createHero(Hero hero) {
        return this.heroRepository.save(hero);
    }

    @PutMapping("/hero/{id}")
    public Hero updateHero(@PathVariable("id") long id, Hero hero) {
        Hero updatedHero = heroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hero with id " + id + "not found"));
        updatedHero.setId(hero.getId());
        updatedHero.setName(hero.getName());
        return updatedHero;
    }

    @DeleteMapping("/hero/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteHeroById(@PathVariable("id") long id) {
        Hero hero = this.heroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hero with id " + id + "not found"));
        this.heroRepository.delete(hero);
        Map<String, Boolean> response = new HashMap<>();
        response.put("hero removed", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
