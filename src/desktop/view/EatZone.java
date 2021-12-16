package desktop.view;

import Utils.UserServices;

import java.awt.Button;
import java.awt.Label;
import java.awt.List;

public class EatZone extends Zone {
    private List animalList;
    private List foodList;
    private Button eatButon;
    private UserServices userServices;
    public EatZone(UserServices userServices) {
        this.userServices=userServices;
        int elementWidth = 500;
        Label label1 = new Label("Животные:");
        label1.setBounds(5, 5, elementWidth, 30);
        this.add(label1, 0);
        Label label2 = new Label("Еда:");
        label2.setBounds(5 + elementWidth, 5, elementWidth, 30);
        this.add(label2, 0);
        this.animalList = new List();
        for(int i=0;i<userServices.getPredators().toArray().length;i++){
            this.animalList.add(userServices.getPredators().get(i).info());
            this.animalList.add("\n");
        }

        for(int i=0;i<userServices.getHerbivores().toArray().length;i++){
            this.animalList.add(userServices.getHerbivores().get(i).info());
            this.animalList.add("\n");
        }
        this.animalList.setBounds(5, 35, elementWidth, 800);
        this.add(this.animalList, 0);
        this.foodList = new List();

        for(int i=0;i<userServices.getHerbivores().toArray().length;i++){
            this.foodList.add(userServices.getHerbivores().get(i).info());
            this.foodList.add("\n");
        }

        for(int i=0;i<userServices.getGrasses().toArray().length;i++){
            this.foodList.add(userServices.getGrasses().get(i).info());
            this.foodList.add("\n");
        }
        this.foodList.setBounds(5 + elementWidth, 35, elementWidth, 800);
        this.add(this.foodList, 0);
        this.eatButon = new Button("Накормить");
        this.eatButon.setBounds(85, 5, 78, 30);
        this.add(this.eatButon, 0);
    }
    public List getAnimalList() {
        return animalList;
    }

    public List getFoodList() {
        return foodList;
    }

    public Button getEatButon() {
        return eatButon;
    }
}
