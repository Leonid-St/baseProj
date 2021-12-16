package desktop.listener;


import Utils.UserServices;
import desktop.view.ViewZone;
import storage.Storage;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ViewZoneListener implements ItemListener {
    private final ViewZone viewZone;
    private final TextField logField;
    private UserServices userServices;
    public ViewZoneListener(ViewZone viewZone, TextField logField, UserServices userServices) {
        this.viewZone = viewZone;
        this.logField = logField;
        this.userServices=userServices;
        viewZone.getAllCheckbox().addItemListener(this);
        viewZone.getPredatorCheckbox().addItemListener(this);
        viewZone.getHerbivoreCheckbox().addItemListener(this);
        viewZone.getPlantCheckbox().addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        Checkbox checkbox = (Checkbox) itemEvent.getSource();
        List allList = viewZone.getAllList();
        allList.removeAll();

        if (checkbox.getState()) {
            switch (checkbox.getLabel()) {
                case "Все" -> {
                    viewZone.getPredatorCheckbox().setState(false);
                    viewZone.getHerbivoreCheckbox().setState(false);
                    viewZone.getPlantCheckbox().setState(false);
                    logField.setText("Выбранные категории: Все");


                    for(int i=0;i<userServices.getPredators().toArray().length;i++){
                        allList.add(userServices.getPredators().get(i).info());
                        allList.add("\n");
                    }

                    for(int i=0;i<userServices.getHerbivores().toArray().length;i++){
                        allList.add(userServices.getHerbivores().get(i).info());
                        allList.add("\n");
                    }

                    for(int i=0;i<userServices.getGrasses().toArray().length;i++){
                        allList.add(userServices.getGrasses().get(i).info());
                        allList.add("\n");
                    }


                }
                case "Хищники" -> {
                    viewZone.getAllCheckbox().setState(false);
                    logField.setText("Выбранные категории: Хищники");

                    for(int i=0;i<userServices.getPredators().toArray().length;i++){
                        allList.add(userServices.getPredators().get(i).info());
                        allList.add("\n");
                    }
                }
                case "Травоядные" -> {
                    viewZone.getAllCheckbox().setState(false);
                    viewZone.getHerbivoreCheckbox().setState(true);
                    logField.setText("Выбранные категории: Травоядные");
                    for(int i=0;i<userServices.getHerbivores().toArray().length;i++){
                        allList.add(userServices.getHerbivores().get(i).info());
                        allList.add("\n");
                    }
                }
                case "Растения" -> {
                    viewZone.getAllCheckbox().setState(false);
                    viewZone.getPlantCheckbox().setState(true);
                    logField.setText("Выбранные категории: Растения");
                    for(int i=0;i<userServices.getGrasses().toArray().length;i++){
                        allList.add(userServices.getGrasses().get(i).info());
                        allList.add("\n");
                    }
                }
            }
        }
    }
}
