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

    public ObjectMapper mapper = new ObjectMapper();

    /*public ObjectMapper getObjectMapper(){
        return mapper;
    }*/

    private ArrString libraryEntity;

    private ArrayList<String> grassesArray;

    private ArrayList<String> herbivoresArray;

    private ArrayList<String> predatorsArray;

    private ArrayList<String> animals;

    private UtilsStorageSerialize storage = new UtilsStorageSerialize();

    public void readLibraryFileToStorage() throws IOException {
        this.libraryEntity = mapper.readValue(new File(pathLibrary), ArrString.class);
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


    public  Storage() throws IOException {

    }
    public Entity getByID (String id){

            for (int i = 0; i < storage.Predators.toArray().length; i++)
                if (Objects.equals(storage.Predators.get(i).getId(), id))
                    return storage.Predators.get(i);

            for (int i = 0; i < storage.Herbivores.toArray().length; i++)
                if (Objects.equals(storage.Herbivores.get(i).getId(), id))
                    return storage.Herbivores.get(i);

            for (int i = 0; i < storage.Grasses.toArray().length; i++)
                if (Objects.equals(storage.Grasses.get(i).getId(), id))
                    return storage.Grasses.get(i);
        /*
        var tmpStor= storage.toArray();
        for(int i=0;i<storage.toArray().length;i++){
            if(Objects.equals(storage.get(i).getId(), id))return storage.get(i);
        }*/
        return null;
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






      /* if(entity instanceof Predator)

        for(int i=0;i<storage.toArray().length;i++){
            if(Objects.equals(storage.get(i).getId(), entity.getId()))
                storage.add(i,entity);
        }*/

    }

    public void Create(Entity entity) throws WeightException {
        if (entity instanceof Predator) {storage.Predators.add((Predator) entity);}
        if (entity instanceof Herbivore) {storage.Herbivores.add((Herbivore) entity);}
        if (entity instanceof Grass) {storage.Grasses.add((Grass) entity);}
    }

  /*  public void CreatePredatorRandom() throws WeightException {
        this.storage.Predators.add(new Predator(java.util.UUID.randomUUID().toString(),
                predatorsArray.get((int) (Math.random() * (predatorsArray.toArray().length))), 100 * (Math.random())));
        CountPredators++;
    }

    public void CreateHerbivoreRandom() throws WeightException {
        this.storage.Herbivores.add(new Herbivore(java.util.UUID.randomUUID().toString(),
                herbivoresArray.get((int) (Math.random() * (herbivoresArray.toArray().length))), 100 * (Math.random())));
        CountHerbivores++;
    }

    public void CreateGrassRandom() throws WeightException {
        this.storage.Grasses.add(new Grass(java.util.UUID.randomUUID().toString(),
                grassesArray.get((int) (Math.random() * (grassesArray.toArray().length))), 100 * (Math.random())));
        CountGrass++;
    }

    //
    public void CreatePredator(String id, String name, Double weight) throws WeightException {
        this.storage.Predators.add(new Predator(id, name, weight));
        CountPredators++;
    }

    public void CreateHerbivore(String id, String name, Double weight) throws WeightException {
        this.storage.Herbivores.add(new Herbivore(id, name, weight));
        CountHerbivores++;
    }

    public void CreateGrass(String id, String name, Double weight) throws WeightException {
        this.storage.Grasses.add(new Grass(id, name, weight));
        CountGrass++;
    }
*/
    public void save() throws IOException {
        mapper.writeValue(new File(pathJSON), this.storage);
    }

   /* public void lazyCreate(int num) throws IOException, WeightException {
        this.readLibraryFileToStorage();
        ///  FileWriter file = new FileWriter("C:/Users/admin/Desktop/HAVA/baseProj/Serialize.json");

        for (int i = 0; i < num; i++) {
            //double x = (int)(Math.random()*((max-min)+1))+min;
            // String jsonString = mapper.writeValueAsString(animal);
            // String tmpPredator= mapper.writeValueAsString(new Predator(java.util.UUID.randomUUID().toString(), animal.get((int) (Math.random() * (animal.toArray().length))),10*(Math.random())));

            this.storage.add(new Herbivore(java.util.UUID.randomUUID().toString(),
                    herbivoresArray.get((int)(Math.random()*(herbivoresArray.toArray().length))),100*(Math.random())));
            // String  tmpHerbivore =mapper.writeValueAsString( new Herbivore(java.util.UUID.randomUUID().toString(),animal.get((int)(Math.random()*(animal.toArray().length))),10*(Math.random())));
           *//* this.storage.add(new Grass(java.util.UUID.randomUUID().toString(),
                    grassesArray.get((int)(Math.random()*(grassesArray.toArray().length))),100*(Math.random())));*//*

            //  String tmpGrass = mapper.writeValueAsString(new Grass(java.util.UUID.randomUUID().toString(),grass.get((int)(Math.random()*(grass.toArray().length))),10*(Math.random())));
            // file.write(tmpPredator+" \n "+ tmpHerbivore +" \n "+ tmpGrass );

        }
        mapper.writeValue(new File(pathJSON), this.storage);
    }*/


    /*public Storage(int countPredators, int countHerbivores, int countGrass,ArrayList<Entity> storage) throws IOException {
        CountPredators = countPredators;
        CountHerbivores = countHerbivores;
        CountGrass = countGrass;
    }*/
}
