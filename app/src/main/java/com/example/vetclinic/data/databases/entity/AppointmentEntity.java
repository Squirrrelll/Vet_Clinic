package com.example.vetclinic.data.databases.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.vetclinic.data.models.AppointmentModel;
@Entity(tableName = "appointment_table")
public class AppointmentEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public AppointmentEntity(@NonNull String name) {
        this.name = name;
    }
    @NonNull
    public String getName() {return this.name;}
    public void setName(@NonNull String name) {this.name = name;}
    public int getId() {return this.id;}
    public void setId(@NonNull int id) {this.id = id;}
    public AppointmentModel toAppointment() {
        return new AppointmentModel(this.name);
    }
}

