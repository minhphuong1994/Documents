package com.example.zipcarrentalapp.Models;


public class ZipCar {
    private String Type;
    private String Make;
    private String Model;
    private String Color;
    private String Licence_Plate;
    private String Location;
    private String image;

    public ZipCar(String type, String make, String model, String color, String licence_Plate, String location, String image) {
        Type = type;
        Make = make;
        Model = model;
        Color = color;
        Licence_Plate = licence_Plate;
        Location = location;
        this.image = image;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setMake(String make) {
        Make = make;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setLicence_Plate(String licence_Plate) {
        Licence_Plate = licence_Plate;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return Type;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return Model;
    }

    public String getColor() {
        return Color;
    }

    public String getLicence_Plate() {
        return Licence_Plate;
    }

    public String getLocation() {
        return Location;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "ZipCar{" +
                "Type='" + Type + '\'' +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", Color='" + Color + '\'' +
                ", Licence_Plate='" + Licence_Plate + '\'' +
                ", Location='" + Location + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
