package storage;


import Utils.ArrString;
import Utils.UserServices;
import Utils.UtilsStorageSerialize;
import com.fasterxml.jackson.core.type.TypeReference;
import exceptions.WeightException;
import model.*;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Storage {

    private final String pathLibrary = "C:/Users/admin/Desktop/HAVA/baseProj/data.json";

    private final String pathJSON = "C:/Users/admin/Desktop/HAVA/baseProj/Serialize.json";
    public String getPathJSON(){
        return pathJSON;
    }

    public ObjectMapper mapper ;

    private ArrString libraryEntity;

    private ArrayList<String> grassesArray;

    private ArrayList<String> herbivoresArray;

    private ArrayList<String> predatorsArray;

    private ArrayList<String> animals;

    private UtilsStorageSerialize storage ;

    public void readLibraryFileToStorage()  {
        try {
            this.libraryEntity = mapper.readValue(new File(pathLibrary), ArrString.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.predatorsArray = libraryEntity.Predators;
        this.herbivoresArray = libraryEntity.Herbivores;
        this.grassesArray = libraryEntity.Grasses;
        this.animals = libraryEntity.Animals;

    }
     public ArrString getLibraryEntity(){
        return libraryEntity;
     }
    public void readJSONToStorage() throws IOException {
        // var str = mapper.readValue(new File(pathJSON), new TypeReference<String>() {});
        // this.storage= JSON.parse(str);
        this.storage = mapper.readValue(new File(pathJSON), UtilsStorageSerialize.class);
        //TypeReference<ArrayList<Entity>>(){});//new TypeReference<List<MyClass>>(){}
    }

    public ArrayList<String> getGrassesArray() {
        return grassesArray;
    }

    public ArrayList<String> getHerbivoresArray() {
        return herbivoresArray;
    }

    public ArrayList<String> getPredatorsArray() {
        return predatorsArray;
    }

    public ArrayList<String> getAnimals() {
        return animals;
    }

    public UtilsStorageSerialize getStorage() {
        return storage;
    }


    public  Storage()  {
        this.storage=new UtilsStorageSerialize();
        this.mapper= new ObjectMapper();
    }


    public void update(Entity entity) {
        if (entity instanceof Predator)
            for (int i = 0; i < storage.Predators.toArray().length; i++)
                if (Objects.equals(storage.Predators.get(i).getId(), entity.getId()))
                    storage.Predators.add(i, (Predator) entity);
        if (entity instanceof Herbivore)
            for (int i = 0; i < storage.Herbivores.toArray().length; i++)
                if (Objects.equals(storage.Herbivores.get(i).getId(), entity.getId()))
                    storage.Herbivores.add(i, (Herbivore) entity);
        if (entity instanceof Grass)
            for (int i = 0; i < storage.Grasses.toArray().length; i++)
                if (Objects.equals(storage.Grasses.get(i).getId(), entity.getId()))
                    storage.Grasses.add(i, (Grass) entity);

    }

    public void Create(Entity entity) throws WeightException {
        if (entity instanceof Predator) {storage.Predators.add((Predator) entity);}
        if (entity instanceof Herbivore) {storage.Herbivores.add((Herbivore) entity);}
        if (entity instanceof Grass) {storage.Grasses.add((Grass) entity);}
    }

    public void save() throws IOException {
        mapper.writeValue(new File(pathJSON), this.storage);
    }


}
