package com.example.camellap.ui.inventario;

import static com.example.camellap.ui.MainActivity.gerente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.camellap.databinding.FragmentInventarioBinding;
import com.example.camellap.ui.cuadroDialogoNuevoMaterial;

public class GalleryFragment extends Fragment {

    private FragmentInventarioBinding binding;

    GalleryFragment contexto = this;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentInventarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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
        super.onDestroyView();
        binding = null;
    }
}