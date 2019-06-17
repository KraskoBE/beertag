package com.telerikacademy.beertag.repositories;

import com.telerikacademy.beertag.models.Beer;
import com.telerikacademy.beertag.models.constants.BeerStyle;
import com.telerikacademy.beertag.models.constants.BeerType;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class BeerRepositoryImpl implements Repository<Beer> {

    private List<Beer> beers;

    public BeerRepositoryImpl() {
        this.beers = new ArrayList<>();
        beers.add(new Beer(0,
                "Pirinsko",
                "CarlsBerg",
                "Bulgaria",
                4.3,
                "birichka opisanie",
                BeerType.Lager,
                BeerStyle.Pale));

        beers.add(new Beer(1,
                "Kamenica",
                "KamenicaAD",
                "Bulgaria",
                4.4,
                "opisanie na kamenica",
                BeerType.Lager,
                BeerStyle.Amber));
    }

    @Override
    public Beer add(Beer beer) {
        beers.add(beer);
        return beer;
    }

    @Override
    public Beer get(int id) {
        return beers.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Beer with id: %d not found.", id)));
    }

    @Override
    public Beer update(Beer oldBeer, Beer newBeer) {
        oldBeer.setName(newBeer.getName());
        oldBeer.setBrewery(newBeer.getBrewery());
        oldBeer.setOriginCountry(newBeer.getOriginCountry());
        oldBeer.setABV(newBeer.getABV());
        oldBeer.setDescription(newBeer.getDescription());
        oldBeer.setType(newBeer.getType());
        oldBeer.setStyle(newBeer.getStyle());
        return oldBeer;
    }

    @Override
    public void remove(Beer beer) {
        beers.remove(beer);
    }

    @Override
    public List<Beer> getAll() {
        return beers;
    }
}
