package com.example.camellap.ui.inventario;

import static com.example.camellap.ui.MainActivity.gerente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.camellap.ViewModel.ClaseInventario;
import com.example.camellap.ViewModel.ClasePersonal;
import com.example.camellap.ViewModel.CustomAdapterInventario;
import com.example.camellap.ViewModel.CustomAdapterPersonal;
import com.example.camellap.databinding.FragmentInventarioBinding;
import com.example.camellap.ui.cuadroDialogoNuevoMaterial;
import com.example.camellap.ui.fragment_personal;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentInventarioBinding binding;

    GalleryFragment contexto = this;
    public static ArrayList<ClaseInventario> inventario = new ArrayList<>();
    ListView listViewInventario;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentInventarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        GalleryFragment context = this;
        listViewInventario = binding.materialList;
        CustomAdapterInventario adapter = new CustomAdapterInventario(this.getContext(),gerente.inventario);
        listViewInventario.setAdapter(adapter);

        listViewInventario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClaseInventario c = gerente.inventario.get(position);
                Toast.makeText(context.getContext(),c.getNombreElemnto(),Toast.LENGTH_LONG).show();
            }
        });

        binding.nuevoMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new cuadroDialogoNuevoMaterial(contexto.getContext(),gerente);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        for(int i = 0; i<inventario.size();i++){
            gerente.crearInventario(inventario.get(i).getNombreElemnto(),inventario.get(i).getCantidad());
        }
        inventario.clear();
        super.onDestroyView();
        binding = null;
    }
}