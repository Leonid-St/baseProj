package desktop.listener;

import Utils.UserServices;
import desktop.view.KillZone;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KillZoneListener implements ActionListener {
    private final KillZone killZone;
    private final TextField logField;
    private UserServices userServices;

    public KillZoneListener(KillZone killZone, TextField logField, UserServices userServices) {
        this.killZone = killZone;
        this.logField = logField;
        this.userServices=userServices;
        killZone.getKillButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Некоторый код по уничтожению существа ...

        String alive = killZone.getAliveList().getSelectedItem().toString();
        killZone.getAliveList().remove(alive);
        logField.setText("Сущность: " + alive + " - уничтожена!");
    }
}