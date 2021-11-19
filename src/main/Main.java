package main;

import Utils.ArrString;
import Utils.UserServices;
import exceptions.WeightException;

import storage.Storage;

import java.io.IOException;

public class Main {

    public static void main(String[] arg) throws IOException, WeightException {

        int initial = 10;
        Storage stor = new Storage();
        stor.readLibraryFileToStorage();
        UserServices userServices = new UserServices(stor);
        userServices.lazyCreate(initial);
        userServices.CreatePredatorRandom();
        userServices.info();
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
