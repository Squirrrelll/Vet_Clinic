package com.example.vetclinic.data.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.vetclinic.data.databases.dao.AppointmentDao;
import com.example.vetclinic.data.databases.entity.AppointmentEntity;
import com.example.vetclinic.data.databases.roomDatabase.AppointmentRoomDatabase;
import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.models.PetModel;
import com.example.vetclinic.data.sources.AppointmentDataSource;
import com.example.vetclinic.data.sources.PetDataSource;

import java.util.List;
import java.util.stream.Collectors;

public class AppointmentRepository {
    private final AppointmentDao mAppointmentDao;
    private final LiveData<List<AppointmentModel>> mAllAppointments;
    private final Context context;
    private AppointmentRoomDatabase roomDatabase;
    public AppointmentRepository(Application applicationContext) {
        context = applicationContext;
        roomDatabase = AppointmentRoomDatabase.getDatabase(context);
        mAppointmentDao = AppointmentRoomDatabase.getDatabase(context).appointmentDao();
        mAllAppointments = Transformations.map(mAppointmentDao.getAllAppointments(), entities -> entities.stream()
                .map(AppointmentEntity::toAppointment).collect(Collectors.toList()));
    }
    public LiveData<List<AppointmentModel>> getAllAppointments() {
        return mAllAppointments;
    }
    public void insert(AppointmentEntity appointment) {
        AppointmentRoomDatabase.databaseWriteExecutor.execute(() -> {
            mAppointmentDao.insert(appointment);
        });
    }
}
