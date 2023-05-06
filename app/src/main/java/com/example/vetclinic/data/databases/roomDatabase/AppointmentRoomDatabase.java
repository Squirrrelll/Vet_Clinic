package com.example.vetclinic.data.databases.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.vetclinic.data.databases.dao.AppointmentDao;
import com.example.vetclinic.data.databases.entity.AppointmentEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {AppointmentEntity.class}, version = 1, exportSchema = false)
public abstract class AppointmentRoomDatabase extends RoomDatabase {
    public abstract AppointmentDao appointmentDao();

    private static volatile AppointmentRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppointmentRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppointmentRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppointmentRoomDatabase.class, "appointment_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                AppointmentDao dao = INSTANCE.appointmentDao();
                dao.deleteAll();
                AppointmentEntity appointment = new AppointmentEntity("Запись №1");
                dao.insert(appointment);
                appointment = new AppointmentEntity("Запись №2");
                dao.insert(appointment);
            });
        }
    };
}