package model;

import com.fasterxml.jackson.databind.deser.Deserializers;
import exceptions.AlreadyDeadException;
import exceptions.WeightException;

import java.io.Serializable;


public  class Entity implements Serializable {
    protected String id ;

    protected String name;

    protected Boolean isAlive;

    protected Double weight;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public void setWeight(Double weight) {

        this.weight = weight;
    }

    public Entity(){}
    public Entity(String id, String name, Double weight) throws WeightException {
        if (weight <= 0) {

            throw new WeightException();

        }

        this.id = id;
        this.name = name;
        this.weight = weight;
        this.isAlive = true;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getWeight() {
        return this.weight;
    }

    public Boolean isAlive() {
       return this.isAlive?true:false;
    }

    public  void die(){
        if(!this.isAlive){
            throw new AlreadyDeadException();
        }else {
            this.isAlive = false;
        }
    };

    public String info() {
        if (isAlive)
            return this.id + ":\t"  + this.name  +  ",\t" + this.weight + " ,\t"  + "alive" ;
        else
            return this.id + ":\t" + this.name   +  ",\t" + this.weight + " ,\t"  + "dead" ;
    }

}
