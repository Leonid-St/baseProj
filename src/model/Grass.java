package model;

import exceptions.WeightException;

import java.util.UUID;

public class Grass extends Entity implements Food {


    public Grass(String id, String name, Double weight) throws WeightException {
        super(id, name, weight);
    }
}
