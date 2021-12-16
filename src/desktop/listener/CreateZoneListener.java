package desktop.listener;

import Utils.UserServices;
import desktop.view.CreateZone;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CreateZoneListener implements ActionListener {
    private final CreateZone createZone;
    private final TextField logField;
    private UserServices userServices;
    public CreateZoneListener(CreateZone createZone, TextField logField,UserServices userServices) {
        this.createZone = createZone;
        this.logField = logField;
        this.userServices=userServices;
        createZone.getCreateButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String name = createZone.getNameField().getText();

        if (Objects.equals(name, "")) {
            logField.setText("Поле: 'Имя' не должно быть пустым");
            return;
        }

        try {
            double weight = Double.parseDouble(createZone.getWeightField().getText());

            // Код создания животного ....

            createZone.getWeightField().setText("");
            createZone.getNameField().setText("");
            logField.setText("Животное: '" + name + "', " + weight + "кг создано успешно!");
        } catch (NumberFormatException e) {
            logField.setText("Поле: 'Вес' должно быть десятичной цифрой");
            createZone.getWeightField().setText("");
        }
    }
}