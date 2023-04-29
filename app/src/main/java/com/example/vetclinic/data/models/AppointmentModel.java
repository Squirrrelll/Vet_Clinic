package com.example.vetclinic.data.models;

public class AppointmentModel {
    private final String appointmentName;

    public AppointmentModel(String appointmentName){
        this.appointmentName = appointmentName;
    }

    public String getAppointmentName(){
        return appointmentName;
    }
}
