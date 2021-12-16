package desktop.view;

import Utils.UserServices;
import desktop.listener.ViewZoneListener;

import java.awt.*;

public final class ViewZone extends Zone {
    private List allList;
    private Checkbox allCheckbox;
    private Checkbox predatorCheckbox;
    private Checkbox herbivoreCheckbox;
    private Checkbox plantCheckbox;
    UserServices userServices;
    public ViewZone( UserServices userServices) {
        int checkBoxWidth = (Settings.ZONE_WIDTH - 5) / 4;
        allCheckbox = new Checkbox("Все");
        allCheckbox.setBounds(5, 5, checkBoxWidth, Settings.TEXT_FIELD_HEIGHT);
        add(allCheckbox, 0);

        predatorCheckbox = new Checkbox("Хищники");
        predatorCheckbox.setBounds(checkBoxWidth, 5, checkBoxWidth, Settings.TEXT_FIELD_HEIGHT);
        add(predatorCheckbox, 0);

        herbivoreCheckbox = new Checkbox("Травоядные");
        herbivoreCheckbox.setBounds(checkBoxWidth * 2, 5, checkBoxWidth, Settings.TEXT_FIELD_HEIGHT);
        add(herbivoreCheckbox, 0);

        plantCheckbox = new Checkbox("Растения");
        plantCheckbox.setBounds(checkBoxWidth * 3, 5, checkBoxWidth, Settings.TEXT_FIELD_HEIGHT);
        add(plantCheckbox, 0);

        allList = new List();
        allList.setBounds(5, 5 +Settings.TEXT_FIELD_HEIGHT, Settings.ZONE_WIDTH - 10, Settings.ZONE_HEIGHT - 10);
        add(allList, 0);
    }

    public List getAllList() {
        return allList;
    }

    public Checkbox getAllCheckbox() {
        return allCheckbox;
    }

    public Checkbox getPredatorCheckbox() {
        return predatorCheckbox;
    }

    public Checkbox getHerbivoreCheckbox() {
        return herbivoreCheckbox;
    }

    public Checkbox getPlantCheckbox() {
        return plantCheckbox;
    }
}
