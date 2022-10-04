package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import javax.swing.*;

public class GuiInterface {

    private final CarStore carStore;
    private final TrackStore trackStore;

    public GuiInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    public Car chooseCarInGui() {
        Object[] carChoice = carStore.carInStore();
        String desiredCar = (String) JOptionPane.showInputDialog(
                null,
                "Выберите автомобиль:",
                "Выбор авто",
                JOptionPane.PLAIN_MESSAGE,
                null,
                carChoice,
                "");
        return carStore.lookup(desiredCar);
    }

    public Track chooseTrackInGui() {
        Object[] trackChoice = trackStore.trackInStore();
        String desiredTrack = (String) JOptionPane.showInputDialog(
                null,
                "Выберите трассу:",
                "Выбор трассы",
                JOptionPane.PLAIN_MESSAGE,
                null,
                trackChoice,
                "");
        return trackStore.lookup(desiredTrack);
    }

    public void showResult(Car car, Track track) {
        if (car.isPitstopNeeded(track)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop needed in " + car.maxLapsForTrack(),
                    "Результат:",
                    1
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop not needed ",
                    "Результат:",
                    1
            );
        }
    }
}