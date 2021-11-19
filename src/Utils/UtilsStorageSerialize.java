package Utils;

import model.Grass;
import model.Herbivore;
import model.Predator;

import java.io.Serializable;
import java.util.ArrayList;

public class UtilsStorageSerialize implements Serializable {
    public UtilsStorageSerialize(){}
    public ArrayList<Predator> Predators =new ArrayList<Predator> ();
    public ArrayList<Herbivore> Herbivores = new ArrayList<Herbivore>();
    public ArrayList<Grass> Grasses = new ArrayList<Grass>() ;
}
