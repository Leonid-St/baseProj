package model;

import exceptions.AlreadyDeadException;
import exceptions.WeightException;
import exceptions.WrongFoodException;

import java.util.UUID;

public class Predator extends Animal {


    public Predator(String id, String name, Double weight) throws WeightException {
        super(id, name, weight);
    }



    @Override
    public void ate(Food food) throws WeightException {
        if (!this.isAlive)
            throw new AlreadyDeadException();

        if (!(food instanceof Herbivore))
            throw new WrongFoodException();

        Herbivore h = (Herbivore)food;
        if(h.weight<=0)
            throw new WeightException();
        isAlive=false;
        weight=weight-1;
        //System.out.println(name+":покушал-"+h);
    }
}

