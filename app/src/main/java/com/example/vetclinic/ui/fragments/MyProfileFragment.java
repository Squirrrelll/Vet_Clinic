package com.example.vetclinic.ui.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;


import com.example.vetclinic.MyService;
import com.example.vetclinic.R;
import com.example.vetclinic.databinding.FragmentMyProfileBinding;
import com.example.vetclinic.ui.activities.MainActivity;
import com.example.vetclinic.ui.viewmodels.AppointmentViewModel;

public class MyProfileFragment extends Fragment {
    FragmentMyProfileBinding binding;

    public MyProfileFragment(){
        super(R.layout.fragment_my_profile);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMyProfileBinding.inflate(inflater, container,false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




       /* FragmentManager fragmentManager = getParentFragmentManager();
        binding.btnAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction;
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view, new MyAppointmentsFragment());
                fragmentTransaction.commit();
            }
        });

        binding.btnMyAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction;
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_view, new AppointmentFragment());
                fragmentTransaction.commit();}
        });*/

        binding.btnMyAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.startFragment.setVisibility(View.INVISIBLE);
                Bundle bundle = new Bundle();
                bundle.putString("navigation", "Navigation text");
                Navigation.findNavController(view).navigate(R.id.action_myProfileFragment_to_myAppointmentsFragment, bundle);
            }
        });

        binding.btnAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.startFragment.setVisibility(View.INVISIBLE);
                Bundle bundle = new Bundle();
                bundle.putString("navigation", "Navigation text");
                Navigation.findNavController(view).navigate(R.id.action_myProfileFragment_to_appointmentFragment, bundle);
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Мой канал";
            String description = "Это канал для уведомлений";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = requireContext().
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Intent notificationIntent = new Intent(getActivity(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(),
                        "CHANNEL")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentText("Не забудьте о завтрашнем приеме")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());

                if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                notificationManager.notify(1, builder.build());
            }
        });

        binding.btnBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MyService.class);
                getActivity().startService(intent);
            }
        });
    }
}

