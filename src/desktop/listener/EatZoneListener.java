package desktop.listener;

import Utils.UserServices;
import desktop.view.EatZone;

import  java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EatZoneListener implements ActionListener {
    private final EatZone eatZone;
    private final TextField logField;
    private UserServices userServices;

    public EatZoneListener(EatZone eatZone, TextField logField,UserServices userServices) {
        this.eatZone = eatZone;
        this.logField = logField;
        this.userServices=userServices;
        eatZone.getEatButon().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String animal = eatZone.getAnimalList().getSelectedItem().toString();
        String eat = eatZone.getFoodList().getSelectedItem().toString();

        // Некоторый код по кормлению еды ...

        eatZone.getFoodList().remove(eat);

        logField.setText(animal + " съел " + eat);
    }
}