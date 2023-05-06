package com.example.vetclinic.data.databases.roomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.vetclinic.data.databases.dao.PetDao;
import com.example.vetclinic.data.databases.entity.PetEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PetEntity.class}, version = 1, exportSchema = false)
public abstract class PetRoomDatabase extends RoomDatabase {
    public abstract PetDao petDao();
    private static volatile PetRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static PetRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PetRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PetRoomDatabase.class, "pet_database")
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
                PetDao dao = INSTANCE.petDao();
                dao.deleteAll();
                PetEntity pet = new PetEntity("Питомец №1");
                dao.insert(pet);
                pet = new PetEntity("Питомец №2");
                dao.insert(pet);
            });
        }
    };
}