package com.telerikacademy.beertag.services;

import com.telerikacademy.beertag.models.Beer;
import com.telerikacademy.beertag.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerServiceImpl implements BeerService {

    private BeerRepository beerRepository;

    @Autowired
    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public Beer add(Beer beer) {
        List<Beer> beers = getAll().stream()
                .filter(beer1 -> beer1.getName().equals(beer.getName()))
                .collect(Collectors.toList());

        if (beers.size() > 0) {
            throw new IllegalArgumentException("Beer already exists");
        }
        return this.beerRepository.add(beer);
    }

    @Override
    public Beer get(int id) {
        return this.beerRepository.get(id);
    }

    @Override
    public void remove(int id) {
        this.beerRepository.remove(get(id));
    }

    @Override
    public List<Beer> getAll() {
        return this.beerRepository.getAll();
    }
}