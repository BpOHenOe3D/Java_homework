package guru.qa;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.service.ConsoleInterface;

public class Application {
   /* private final GuiInterface userInterface;
    public Application(GuiInterface userInterface) {
        this.userInterface = userInterface;
    }
    void runGuiInterface() {
        Car car = userInterface.chooseCarInGui();
        Track track = userInterface.chooseTrackInGui();
        userInterface.showResult(car, track);
    }*/

    private final ConsoleInterface consoleInterface;

    public Application(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    void runConsoleInterface() {
        Car car = consoleInterface.choiseCarConsole();
        Track track = consoleInterface.choiseTrackConsole();
        consoleInterface.showResult(car, track);
    }
}