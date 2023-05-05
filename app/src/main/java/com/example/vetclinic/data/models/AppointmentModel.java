package com.example.vetclinic.data.models;

public class AppointmentModel {
    private final String appointment;

    public AppointmentModel(String appointment){
                this.appointment = appointment;
    }

    public String getAppointment(){
        return appointment;
    }
}
