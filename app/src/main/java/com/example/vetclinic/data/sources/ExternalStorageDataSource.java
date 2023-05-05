package com.example.vetclinic.data.sources;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExternalStorageDataSource {
    private File external_storage_file;
    private Context context;

    public ExternalStorageDataSource(Context context) {
        this.context = context;
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            external_storage_file = new File(Environment.getExternalStorageDirectory(), "user_names2.txt");
        }
        else {
            ActivityCompat.requestPermissions((Activity)context, new String[]
                    {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    public void addExternalStorage(String user_name){
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            try {
                FileWriter writer = new FileWriter(external_storage_file);
                writer.write(user_name);
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            ActivityCompat.requestPermissions((Activity)context, new String[]
                    {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }
}
