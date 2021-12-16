package desktop.view;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Utils.UserServices;

import java.awt.Button;
import java.awt.Label;
import java.awt.List;

public final class KillZone extends Zone {
    private List aliveList;
    private Button killButton;
    private UserServices userServices;
    public KillZone(UserServices userServices) {
        this.userServices=userServices;
        Label label = new Label("Выберите сущность, которую хотите убить");
        label.setBounds(5, 5, 380, 30);
        this.add(label, 0);
        this.aliveList = new List();
       // this.aliveList.add("Осёл 17.43 кг жив");
        for(int i=0;i<userServices.getPredators().toArray().length;i++){
            this.aliveList.add(userServices.getPredators().get(i).info());
            this.aliveList.add("\n");
        }

        for(int i=0;i<userServices.getHerbivores().toArray().length;i++){
            this.aliveList.add(userServices.getHerbivores().get(i).info());
            this.aliveList.add("\n");
        }

        for(int i=0;i<userServices.getGrasses().toArray().length;i++){
            this.aliveList.add(userServices.getGrasses().get(i).info());
            this.aliveList.add("\n");
        }
        this.aliveList.setBounds(5, 35, 500, 800);
        this.add(this.aliveList, 0);
        this.killButton = new Button("Убить");
        this.killButton.setBounds(510, 35, 78, 30);
        this.add(this.killButton, 0);
    }
    public List getAliveList() {
        return aliveList;
    }

    public Button getKillButton() {
        return killButton;
    }

}

