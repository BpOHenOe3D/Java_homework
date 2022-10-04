package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import java.util.Scanner;

public class ConsoleInterface {
    private final CarStore carStore;
    private final TrackStore trackStore;
    private final Scanner sc = new Scanner(System.in);

    public ConsoleInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    public Car choiseCarConsole() {
        System.out.println("Выберите автомобиль:");
        carStore.carList();
        String desiredCar = sc.next();
        return carStore.lookup(desiredCar);
    }

    public Track choiseTrackConsole() {
        System.out.println("Выберите трассу:");
        trackStore.trackList();
        String desiredTack = sc.next();
        return trackStore.lookup(desiredTack);
    }

    public void showResult(Car car, Track track) {
        if (car.isPitstopNeeded(track)) {
            System.out.println("Pit-stop needed in " + car.maxLapsForTrack());
        } else {
            System.out.println("Pit-stop not needed");
        }
    }
}
