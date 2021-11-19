package Utils;

import com.fasterxml.jackson.databind.deser.Deserializers;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrString implements Serializable {
    public ArrayList<String> Animals ;
    public ArrayList<String> Predators ;
    public ArrayList<String> Herbivores;
    public ArrayList<String> Grasses;
}

