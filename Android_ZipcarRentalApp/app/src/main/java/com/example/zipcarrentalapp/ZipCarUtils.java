package com.example.zipcarrentalapp;

import com.example.zipcarrentalapp.Models.ZipCar;

import java.util.ArrayList;

public final class ZipCarUtils {
    private ZipCarUtils(){}

    public static ArrayList<ZipCar> loadSUVZipCars(){
        ArrayList<ZipCar> cars = new ArrayList<>();
        cars.add(new ZipCar("SUV","Honda","CRV","Red","CERN522","20 Dupont Avenue, Toronto, ON","suvred"));
        cars.add(new ZipCar("SUV","Honda","CRV","Blue","ATXM099","98 Kendall Avenue, Toronto, ON","suvblue"));
        cars.add(new ZipCar("SUV","Honda","CRV","White","BLIK152","603 Davenport Avenue, Toronto, ON","suvred"));

        return cars;
    }

    public static  ArrayList<ZipCar> loadSEDANZipCars(){
        ArrayList<ZipCar> cars = new ArrayList<>();
        cars.add(new ZipCar("Sedan","Ford","Focus","White","AMRV614","30 Bridgeman Avenue, Toronto, ON","fordfocus"));
        cars.add(new ZipCar("Sedan","Hyundai","Elantra","Orange","CXVT703","17 Howland Avenue, Toronto, ON","sedanorange"));
        return  cars;
    }

    public static ArrayList<Integer> loadHireTime(){
        ArrayList<Integer> hireTimes = new ArrayList<>();
        hireTimes.add(1);
        hireTimes.add(2);
        hireTimes.add(3);
        hireTimes.add(4);
        hireTimes.add(24);
        return hireTimes;
    }
}
