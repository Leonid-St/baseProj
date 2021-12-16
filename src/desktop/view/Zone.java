package desktop.view;

import java.awt.*;

public class Zone extends Container {
    public Zone() {
        setSize(Settings.ZONE_WIDTH, Settings.ZONE_HEIGHT);

        Canvas canvas = new Canvas();
        canvas.setBounds(0, 0, Settings.ZONE_WIDTH, Settings.ZONE_HEIGHT);
        canvas.setBackground(Color.WHITE);
        add(canvas);
    }
}
