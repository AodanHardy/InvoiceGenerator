package org.example.models;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private double hoursWorked;
    private ArrayList<Material> materials;

    private Date dateTime;

    public Invoice() {
        dateTime = new Date(System.currentTimeMillis());
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public DateTimeAtCreation getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTimeAtCreation dateTime) {
        this.dateTime = dateTime;
    }
}
