package Utils;

import model.Grass;
import model.Herbivore;
import model.Predator;

import java.io.Serializable;
import java.util.ArrayList;

public class UtilsStorageSerialize implements Serializable {
    public UtilsStorageSerialize(){
        Predators =new ArrayList<Predator> ();
        Herbivores = new ArrayList<Herbivore>();
        Grasses = new ArrayList<Grass>() ;
    }
    public ArrayList<Predator> Predators ;
    public ArrayList<Herbivore> Herbivores ;
    public ArrayList<Grass> Grasses ;
}
