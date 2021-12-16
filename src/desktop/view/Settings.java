package desktop.view;
public class Settings {
    private Settings() {}

    public static final int WINDOW_WIDTH = 1000;     // Ширина окна всего приложения
    public static final int WINDOW_HEIGHT = 1000;    // Высота окна всего приложения

    public static final int MENU_X = 30;    // Длина отступа по координате X для меню
    public static final int MENU_Y = 30;    // Длина отступа по координате Y для меню

    public static final int BUTTON_WIDTH = (WINDOW_WIDTH - MENU_X * 2) / 5;    // Ширина любой кнопки на форме
    public static final int BUTTON_HEIGHT = 30;    // Высота любой кнопки на форме

    public static final int TEXT_FIELD_HEIGHT = 30;    // Высота любого текстового поля на форме

    public static final int ZONE_X = 30;    // Длина отступа по координате X для меню
    public static final int ZONE_Y = MENU_Y + BUTTON_HEIGHT;    // Длина отступа по координате Y для меню
    public static final int ZONE_WIDTH = WINDOW_WIDTH - ZONE_X * 2;    // Ширина зоны с активным
    public static final int ZONE_HEIGHT = WINDOW_HEIGHT - ZONE_Y * 2;  // Высота окна всего приложения

    public static final int LOG_X = ZONE_X;    // X координата логов
    public static final int LOG_Y = ZONE_Y + ZONE_HEIGHT;    // Н координата логов
    public static final int LOG_WIDTH = ZONE_WIDTH;    // Ширина блока с логами
    public static final int LOG_HEIGHT = 30;  // Высота блока с логами

}
