package model;

import exceptions.AlreadyDeadException;
import exceptions.WeightException;
import exceptions.WrongFoodException;

import java.util.UUID;

public class Herbivore extends Animal implements Food {

    public Herbivore(String id, String name, Double weight) throws WeightException {
        super(id, name, weight);
    }

    @Override
    protected void ate(Food food) throws WeightException {

        if (!this.isAlive)
            throw new AlreadyDeadException();

        if (!(food instanceof Grass))
          throw new WrongFoodException();

        Grass h = (Grass)food;
        if(h.weight<=0)
            throw new WeightException();
        isAlive=false;
        weight=weight-1;
    }

       // System.out.println(name+":покушал-"+h);
    }



