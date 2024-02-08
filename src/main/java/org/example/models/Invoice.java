package org.example.models;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private double hoursWorked;

    private double pricePerHour;
    private ArrayList<Material> materials;

    private Date dateTime;

    public Invoice() {
        dateTime = new Date(System.currentTimeMillis());
        materials = new ArrayList<>();
    }

    public Invoice(double hoursWorked, double pricePerHour, ArrayList<Material> materials) {
        this.hoursWorked = hoursWorked;
        this.pricePerHour = pricePerHour;
        this.materials = materials;
        dateTime = new Date(System.currentTimeMillis());
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }
    public void addToMaterials(Material material){
        this.materials.add(material);
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
