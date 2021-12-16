package desktop.listener;

import desktop.view.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindowListener implements ActionListener, java.awt.event.WindowListener {
    private final MainWindow mainWindow;

    public MainWindowListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        mainWindow.getViewButton().addActionListener(this);
        mainWindow.getCreateButton().addActionListener(this);
        mainWindow.getKillButton().addActionListener(this);
        mainWindow.getEatButton().addActionListener(this);
        mainWindow.getNetworkButton().addActionListener(this);
        mainWindow.getLogField().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Посмотреть" -> {
                mainWindow.remove(mainWindow.getComponentCount() - 1);
                mainWindow.add(mainWindow.getViewZone());
            }
            case "Создать" -> {
                mainWindow.remove(mainWindow.getComponentCount() - 1);
                mainWindow.add(mainWindow.getCreateZone());
            }
            case "Убить" -> {
                mainWindow.remove(mainWindow.getComponentCount() - 1);
                mainWindow.add(mainWindow.getKillZone());
            }
            case "Покормить" -> {
                mainWindow.remove(mainWindow.getComponentCount() - 1);
                mainWindow.add(mainWindow.getEatZone());
            }
            case "Сеть" -> {
                mainWindow.remove(mainWindow.getComponentCount() - 1);
                mainWindow.add(mainWindow.getNetworkZone());
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        mainWindow.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
