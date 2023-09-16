package com.example.costumes;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class costumesRepository implements PanacheMongoRepository<Costume> {

    public Costume findByName(String name){
        return find("name", name).firstResult();
    }

    public List<Costume> FindOrderedName() {
        return listAll(Sort.by("name"));
    }
}
