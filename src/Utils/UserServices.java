package Utils;

import exceptions.AlreadyDeadException;
import exceptions.WeightException;
import exceptions.WrongFoodException;
import model.*;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class UserServices {
    Storage storage;
    ArrString libraryServices;

    public UserServices(Storage storage) {
        this.storage = storage;
        this.libraryServices = storage.getLibraryEntity();

    }

    public void lazyCreate(int num) throws IOException, WeightException {
        //this.storage.readLibraryFileToStorage();
        for (int i = 0; i < num; i++) {
            this.CreatePredatorRandom();
            this.CreateHerbivoreRandom();
            this.CreateGrassRandom();
        }
        this.storage.mapper.writeValue(new File(this.storage.getPathJSON()), this.storage.getStorage().getClass());

    }

    public void CreatePredatorRandom() throws WeightException {
        this.storage.Create(new Predator(java.util.UUID.randomUUID().toString(),
                libraryServices.Predators.get((int) (Math.random() * (libraryServices.Predators.toArray().length))), 100 * (Math.random())));

    }

    public void CreateHerbivoreRandom() throws WeightException {
        this.storage.Create(new Herbivore(java.util.UUID.randomUUID().toString(),
                libraryServices.Herbivores.get((int) (Math.random() * (libraryServices.Herbivores.toArray().length))), 100 * (Math.random())));

    }

    public void CreateGrassRandom() throws WeightException {
        this.storage.Create(new Grass(java.util.UUID.randomUUID().toString(),
                libraryServices.Grasses.get((int) (Math.random() * (libraryServices.Grasses.toArray().length))), 100 * (Math.random())));

    }

    //
    public void CreatePredator(String id, String name, Double weight) throws WeightException {
        this.storage.Create(new Predator(id, name, weight));

    }

    public void CreateHerbivore(String id, String name, Double weight) throws WeightException {
        this.storage.Create(new Herbivore(id, name, weight));

    }

    public void CreateGrass(String id, String name, Double weight) throws WeightException {
        this.storage.Create(new Grass(id, name, weight));

    }

    public ArrayList<Predator> getPredators() {
        return this.storage.getStorage().Predators;
    }

    public ArrayList<Herbivore> getHerbivores() {
        return this.storage.getStorage().Herbivores;
    }

    public ArrayList<Grass> getGrasses() {
        return this.storage.getStorage().Grasses;
    }

    public void infoPredators() {
        System.out.println("Predators>>>:");
        for (int i = 0; i < storage.getStorage().Predators.toArray().length; i++) {
            System.out.println(storage.getStorage().Predators.get(i).info());
        }
    }

    public void infoHerbivores() {
        System.out.println("Herbivores>>>:");
        for (int i = 0; i < this.storage.getStorage().Herbivores.toArray().length; i++) {
            System.out.println(this.storage.getStorage().Herbivores.get(i).info());
        }
    }

    public void infoGrasses() {
        System.out.println("Predators>>>:");
        for (int i = 0; i < this.storage.getStorage().Predators.toArray().length; i++) {
            System.out.println(this.storage.getStorage().Predators.get(i).info());
        }
    }


    public void info() {
        //var arrPredators=storage.getStorage().Predators;
        this.infoPredators();
        this.infoHerbivores();
        this.infoGrasses();


    }


    public void MURDER(Entity entity)  throws AlreadyDeadException {
        if (entity instanceof Predator)
            for (int i = 0; i <= this.storage.getStorage().Predators.toArray().length; i++)
                if (Objects.equals(this.storage.getStorage().Predators.get(i).getId(), entity.getId()))
                    this.storage.getStorage().Predators.get(i).die();
        if (entity instanceof Herbivore)
            for (int i = 0; i <= this.storage.getStorage().Herbivores.toArray().length; i++)
                if (Objects.equals(this.storage.getStorage().Herbivores.get(i).getId(), entity.getId()))
                    this.storage.getStorage().Herbivores.get(i).die();
        if (entity instanceof Grass)
            for (int i = 0; i <= this.storage.getStorage().Grasses.toArray().length; i++)
                if (Objects.equals(this.storage.getStorage().Grasses.get(i).getId(), entity.getId()))
                    this.storage.getStorage().Grasses.get(i).die();

    }

    public void ate(Entity entity, Food food) throws WeightException, WrongFoodException {
        if (entity instanceof Predator)
            for (int i = 0; i <= this.storage.getStorage().Predators.toArray().length; i++)
                if (Objects.equals(this.storage.getStorage().Predators.get(i).getId(), entity.getId()))
                    this.storage.getStorage().Predators.get(i).ate(food);

        if (entity instanceof Herbivore)
            for (int i = 0; i <= this.storage.getStorage().Herbivores.toArray().length; i++)
                if (Objects.equals(this.storage.getStorage().Herbivores.get(i).getId(), entity.getId()))
                    this.storage.getStorage().Predators.get(i).ate(food);


    }


}
