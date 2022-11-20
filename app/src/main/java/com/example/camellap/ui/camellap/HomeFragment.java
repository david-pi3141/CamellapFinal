package com.example.camellap.ui.camellap;

import static com.example.camellap.ui.MainActivity.gerente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.camellap.databinding.FragmentHomeBinding;
import com.example.camellap.ui.cuadroMostrarEditarEvento;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    HomeFragment contexto = this;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + (month+1) + "/" + year;
                Toast.makeText(contexto.getContext(),fecha,Toast.LENGTH_SHORT).show();
                for (int i = 0; i<gerente.eventos.size();i++){
                    if(gerente.eventos.get(i).getFecha().equals(fecha)){
                        new cuadroMostrarEditarEvento(contexto.getContext(), gerente.eventos.get(i));
                        break;
                    }
                }
            }
        });

        final TextView textView = binding.textHome;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}