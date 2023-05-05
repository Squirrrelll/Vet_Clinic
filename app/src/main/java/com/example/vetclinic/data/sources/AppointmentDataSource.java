package com.example.vetclinic.data.sources;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.vetclinic.data.models.AppointmentModel;
import com.example.vetclinic.data.models.PetModel;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDataSource {

    public static LiveData<List<AppointmentModel>> createAppointmentList(){
        MutableLiveData<List<AppointmentModel>> list = new MutableLiveData<>();
        ArrayList<AppointmentModel> appointments = new ArrayList<>();
        for (int i=1; i<101; i++){
            AppointmentModel temp = new AppointmentModel("Запись" + i);
            appointments.add(temp);
        }
        list.setValue(appointments);
        return list;
    }

}
