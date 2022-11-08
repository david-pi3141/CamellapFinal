package com.example.camellap.ui;

import static com.example.camellap.ui.MainActivity.gerente;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.camellap.R;
import com.example.camellap.ViewModel.ClaseContratante;
import com.example.camellap.ViewModel.ClasePersonal;
import com.example.camellap.ViewModel.CustomAdapter;
import com.example.camellap.databinding.FragmentContratantesBinding;
import com.example.camellap.databinding.FragmentHomeBinding;
import com.example.camellap.databinding.FragmentInventarioBinding;
import com.example.camellap.ui.inventario.GalleryViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_contratantes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_contratantes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_contratantes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_contratantes.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_contratantes newInstance(String param1, String param2) {
        fragment_contratantes fragment = new fragment_contratantes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ListView listViewContratantes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    private FragmentContratantesBinding binding;
    fragment_contratantes contexto = this;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentContratantesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        fragment_contratantes context = this;
        listViewContratantes = binding.contratantesList;
        CustomAdapter adapter = new CustomAdapter(this.getContext(),gerente.contratantes);

        listViewContratantes.setAdapter(adapter);

        listViewContratantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClaseContratante c = gerente.contratantes.get(position);
                Toast.makeText(context.getContext(),c.nombre,Toast.LENGTH_LONG).show();
            }
        });

        binding.nuevoContratante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new cuadroDialogoNuevoContratante(contexto.getContext(),gerente);
            }
        });

        return root;
    }
}