
/**
 * viewCalculator adds together all the components to make the application fully functional.
 * It connects the main components of app, model with the controller.
 *
 * @author Mustafë Ismajli
 * @version 22.0.1
 */

public class viewCalculator extends controllerCalculator {

    public viewCalculator() {
        settingFrame();
        drawButtons();
        addComponents();
        functionButtons();
    }
}
