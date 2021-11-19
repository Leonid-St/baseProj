package model;

import exceptions.AlreadyDeadException;
import exceptions.WeightException;

import java.util.UUID;

public abstract class Animal extends Entity {

    public Animal(String id, String name, Double weight) throws WeightException {
        super(id, name, weight);
    }

    protected abstract void  ate(Food food) throws WeightException;

}
