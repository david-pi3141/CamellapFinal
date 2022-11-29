package com.example.camellap.db;

import static com.example.camellap.ui.MainActivity.gerente;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.camellap.R;
import com.example.camellap.ViewModel.ClasePersonal;
import com.example.camellap.ViewModel.CustomAdapterPersonal;
import com.example.camellap.databinding.FragmentBasedatosBinding;
import com.example.camellap.databinding.FragmentPersonalBinding;
import com.example.camellap.ui.cuadroDialogoNuevoPersonal;
import com.example.camellap.ui.fragment_personal;

public class fragment_basedatos extends Fragment {

    Button btnCrear;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    
    public static fragment_basedatos newInstance(String param1, String param2) {
        fragment_basedatos fragment = new fragment_basedatos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }
    private FragmentBasedatosBinding binding;
    fragment_basedatos contexto = this;
    ListView listViewPersonal;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBasedatosBinding.inflate(inflater, container, false);

        View root = binding.getRoot();




        binding.btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(contexto.getContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                try {
                    Toast.makeText(contexto.getContext(), "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                } catch (RuntimeException e){
                    Toast.makeText(contexto.getContext(), "EEROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }
}
