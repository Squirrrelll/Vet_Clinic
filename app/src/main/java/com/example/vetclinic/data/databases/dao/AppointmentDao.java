package com.example.vetclinic.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.vetclinic.data.databases.entity.AppointmentEntity;

import java.util.List;

@Dao
public interface AppointmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(AppointmentEntity appointment);

    @Query("DELETE FROM appointment_table")
    void deleteAll();

    @Query("SELECT * FROM appointment_table ORDER BY name")
    LiveData<List<AppointmentEntity>> getAllAppointments();
}