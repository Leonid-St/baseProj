package desktop.view;
import java.awt.*;


import Utils.UserServices;
import desktop.listener.*;
import storage.Storage;

import java.awt.*;

public final class MainWindow extends Frame {
    private ViewZone viewZone;
    private CreateZone createZone;
    private KillZone killZone;
    private EatZone eatZone;
    private Container networkZone;      // TODO: сделать

    private Button viewButton;
    private Button createButton;
    private Button killButton;
    private Button eatButton;
    private Button networkButton;

    private TextField logField;

    MainWindowListener mainWindowListener;
    ViewZoneListener viewZoneListener;
    CreateZoneListener createZoneListener;
    KillZoneListener killZoneListener;
    EatZoneListener eatZoneListener;
    UserServices userServices;
    public MainWindow(UserServices userServices) {
        this.userServices=userServices;
        viewButton = new Button("Посмотреть");
        viewButton.setBounds(Settings.MENU_X, Settings.MENU_Y, Settings.BUTTON_WIDTH, Settings.BUTTON_HEIGHT);
        add(viewButton);

        createButton = new Button("Создать");
        createButton.setBounds(Settings.MENU_X + Settings.BUTTON_WIDTH, Settings.MENU_Y, Settings.BUTTON_WIDTH, Settings.BUTTON_HEIGHT);
        add(createButton);

        killButton = new Button("Убить");
        killButton.setBounds(Settings.MENU_X + Settings.BUTTON_WIDTH * 2, Settings.MENU_Y,
                Settings.BUTTON_WIDTH, Settings.BUTTON_HEIGHT);
        add(killButton);

        eatButton = new Button("Покормить");
        eatButton.setBounds(Settings.MENU_X + Settings.BUTTON_WIDTH * 3, Settings.MENU_Y,
                Settings.BUTTON_WIDTH, Settings.BUTTON_HEIGHT);
        add(eatButton);

        networkButton = new Button("Сеть");
        networkButton.setBounds(Settings.MENU_X + Settings.BUTTON_WIDTH * 4, Settings.MENU_Y,
                Settings.BUTTON_WIDTH, Settings.BUTTON_HEIGHT);
        networkButton.setEnabled(false);
        add(networkButton);


        logField = new TextField("Приложение успешно запущено");
        logField.setBounds(Settings.LOG_X, Settings.LOG_Y, Settings.LOG_WIDTH, Settings.LOG_HEIGHT);
        logField.setEnabled(false);
        add(logField);

        setSize(Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT);
        setLayout(null);
        setVisible(true);



        viewZone = new ViewZone(userServices);
        viewZone.setLocation(Settings.ZONE_X, Settings.ZONE_Y);

        createZone = new CreateZone(userServices);
        createZone.setLocation(Settings.ZONE_X, Settings.ZONE_Y);

        killZone = new KillZone(userServices);
        killZone.setLocation(Settings.ZONE_X, Settings.ZONE_Y);

        eatZone = new EatZone(userServices);
        eatZone.setLocation(Settings.ZONE_X, Settings.ZONE_Y);

        add(viewZone);



        mainWindowListener = new MainWindowListener(this);
        viewZoneListener = new ViewZoneListener(viewZone, logField,userServices);
        createZoneListener = new CreateZoneListener(createZone, logField,userServices);
        killZoneListener = new KillZoneListener(killZone, logField,userServices);
        eatZoneListener = new EatZoneListener(eatZone, logField,userServices);
    }

    public Container getViewZone() {
        return viewZone;
    }

    public Container getCreateZone() {
        return createZone;
    }

    public Container getKillZone() {
        return killZone;
    }

    public Container getEatZone() {
        return eatZone;
    }

    public Container getNetworkZone() {
        return networkZone;
    }

    public Button getViewButton() {
        return viewButton;
    }

    public Button getCreateButton() {
        return createButton;
    }

    public Button getKillButton() {
        return killButton;
    }

    public Button getEatButton() {
        return eatButton;
    }

    public Button getNetworkButton() {
        return networkButton;
    }

    public TextField getLogField() {
        return logField;
    }


}
