package main;

import Utils.UserServices;
import desktop.view.MainWindow;
import exceptions.WeightException;

import model.Entity;
import model.Food;
import storage.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.UUID;

public class Main {

    public static void main(String[] arg) throws IOException, WeightException {

        int initial = 10;
       // Storage store = new Storage();
      //  store.readLibraryFileToStorage();
        UserServices userServices = new UserServices();
      //  userServices.lazyCreate(initial);
      //  userServices.CreatePredatorRandom();
      //  userServices.info();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            System.out.println("1-оконный интерфейс");
            System.out.println("2-lazyCreate");
            System.out.println("3-info");
            System.out.println("4-Создать сущность ");
            System.out.println("5-Убить сущность ");
            System.out.println("6-покормить одно другим");
            System.out.println("7-Выход");
            String menu =  reader.readLine();
            if(Objects.equals(menu, "1")){
                    userServices.createMainWindow();
            }
            if(Objects.equals(menu, "2")){
                System.out.println("Количество сущностей каждого вида:");
                String num =  reader.readLine();
                userServices.lazyCreate(Integer.parseInt(num));
            }
            if(Objects.equals(menu, "3")){
                userServices.info();
            }
            if(Objects.equals(menu, "4")){
                System.out.println("Сущность какого  вида нужно создать?:");
                System.out.println("1-Predator:");
                System.out.println("2-Herbivore:");
                System.out.println("3-Grasses:");
                String entity =  reader.readLine();
                System.out.println("Случайно или с конкретными параметрами?:");
                System.out.println("1-Случайно:");
                System.out.println("2-С параметрами:");
                String rand =  reader.readLine();
                switch (entity){
                    case("1"):
                    if(Objects.equals(rand, "1")){
                        userServices.CreatePredatorRandom();
                    }
                    if(Objects.equals(rand, "2")){
                        System.out.println("Введите имя?:");
                        String name=reader.readLine();
                        System.out.println("Введите вес?:");
                        String weight=reader.readLine();
                        userServices.CreatePredator(name,Double.parseDouble(weight));
                    }
                   break;
                    case ("2"):
                        if(Objects.equals(rand, "1")){
                            userServices.CreateHerbivoreRandom();
                        }
                        if(Objects.equals(rand, "2")){
                            System.out.println("Введите имя?:");
                            String name=reader.readLine();
                            System.out.println("Введите вес?:");
                            String weight=reader.readLine();
                            userServices.CreateHerbivore(name,Double.parseDouble(weight));
                        }
                        break;
                    case ("3"):
                        if(Objects.equals(rand, "1")){
                            userServices.CreateGrassRandom();
                        }
                        if(Objects.equals(rand, "2")){
                            System.out.println("Введите имя?:");
                            String name=reader.readLine();
                            System.out.println("Введите вес?:");
                            String weight=reader.readLine();
                            userServices.CreateGrass(name,Double.parseDouble(weight));
                        }
                        break;
                }

        }
            if(Objects.equals(menu, "5")){
                System.out.println("Id жертвы:");
                String prey=reader.readLine();
                userServices.MURDER(userServices.getByID(prey));
            }
            if(Objects.equals(menu, "6")){
                System.out.println("Id жертвы:");
                String prey=reader.readLine();
                System.out.println("Id Счастливчика:");
                String lucky=reader.readLine();
                Entity preyEntity  =userServices.getByID(prey);
                Entity luckyEntity =userServices.getByID(prey);
                userServices.ate(luckyEntity,(Food) preyEntity);
            }
            if(Objects.equals(menu, "7")){
                break;
            }
        }

//        Window.addWindowListener(new WindowAdapter() {
//                                public void windowClosing(WindowEvent we) {
//                                    dispose();
//                                }
//                            }
//        );
        //ObjectMapper mapper = new ObjectMapper();



      /*  for(int i=0;i<initial;i++){
            ArrString arr = mapper.readValue(new File("C:/Users/admin/Desktop/HAVA/baseProj/data.json"),ArrString.class);
        }*/
        // Storage stor = new Storage(2,2,2,);


        // stor.readJSONToStorage();
        //var a = stor.getByID("8bc4bec9-97e3-4109-8deb-b066929ea101");
        //  System.out.println(arr);


//
//
//        System.out.println("a="+a);
//        for(int i=0;i<10;i++){
//            for(int k=0;k<10;k++){
//                System.out.print(i+" ");
//            }
//            System.out.print('\n');
//        }

      /*  Predaor pr1=new Predaor(100,"волк",15);

        System.out.println(pr1.getInfo());

        Herbivore hr1 =new Herbivore(200,"заяц",2);

        System.out.println(hr1.getInfo());

        Grass gr1=new Grass(300,"одуванчик",1);

        System.out.println(gr1.getInfo());

        pr1.ate(hr1);

        hr1.ate(gr1);

        Herbivore hr2 =new Herbivore(200,"суслик",2);

        System.out.println(hr2.getInfo());

        hr2.ate(gr1);

        System.out.println(gr1.getInfo());*/

    }
}
