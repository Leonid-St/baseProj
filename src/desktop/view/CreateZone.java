package desktop.view;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Utils.UserServices;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;

public class CreateZone extends Zone {
    private TextField nameField;
    private TextField weightField;
    private Button createButton;
    UserServices userServices;
    public CreateZone( UserServices userServices) {
        Label nameLabel = new Label("Имя:");
        nameLabel.setBounds(5, 5, 30, 30);
        this.add(nameLabel, 0);
        this.nameField = new TextField();
        this.nameField.setBounds(35, 5, 350, 30);
        this.add(this.nameField, 0);
        Label weightLabel = new Label("Вес:");
        weightLabel.setBounds(5, 35, 30, 30);
        this.add(weightLabel, 0);
        this.weightField = new TextField();
        this.weightField.setBounds(35, 30, 350, 30);
        this.add(this.weightField, 0);
        this.createButton = new Button("Создать");
        this.createButton.setBounds(156, 80, 78, 30);
        this.add(this.createButton, 0);
    }
    public TextField getNameField() {
        return nameField;
    }

    public TextField getWeightField() {
        return weightField;
    }

    public Button getCreateButton() {
        return createButton;
    }
}
