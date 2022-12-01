package com.example.camellap.ui.finanzas;

import static com.example.camellap.ui.MainActivity.gerente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.camellap.ViewModel.ClaseEvento;
import com.example.camellap.ViewModel.ClaseInventario;
import com.example.camellap.ViewModel.CustomAdapterEventos;
import com.example.camellap.ViewModel.CustomAdapterInventario;
import com.example.camellap.databinding.FragmentFinanzasBinding;
import com.example.camellap.ui.inventario.GalleryFragment;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {
    static ArrayList<ClaseEvento> lst2 = new ArrayList<>();

    private FragmentFinanzasBinding binding;
    ListView ListViewPendientesPago;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentFinanzasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        SlideshowFragment context = this;
        ListViewPendientesPago = binding.ListViewPendientesPago;
        CustomAdapterEventos adapter = new CustomAdapterEventos(this.getContext(), lst2);
        ListViewPendientesPago.setAdapter(adapter);

        ListViewPendientesPago.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClaseInventario c = gerente.inventario.get(position);
                Toast.makeText(context.getContext(),c.getNombreElemnto(),Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        SlideshowFragment context = this;
        lst2.clear();
        for(int i= 0; i < gerente.eventos.size(); i++){
            if(gerente.eventos.get(i).getEstadoPago()){
                lst2.add(gerente.eventos.get(i));
            }
        }
        super.onDestroyView();
        binding = null;
    }
}