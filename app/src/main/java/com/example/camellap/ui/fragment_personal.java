package com.example.camellap.ui;

import static com.example.camellap.ui.MainActivity.gerente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.camellap.ViewModel.ClaseContratante;
import com.example.camellap.ViewModel.ClasePersonal;
import com.example.camellap.ViewModel.CustomAdapter;
import com.example.camellap.ViewModel.CustomAdapterPersonal;
import com.example.camellap.databinding.FragmentContratantesBinding;
import com.example.camellap.databinding.FragmentPersonalBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_personal#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class fragment_personal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    static ArrayList<ClasePersonal> personal = new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Personal.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_personal newInstance(String param1, String param2) {
        fragment_personal fragment = new fragment_personal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public fragment_personal() {
        // Required empty public constructor
    }

    @Override
    public void onDestroyView() {
        for(int i = 0; i<personal.size();i++){
            gerente.nuevoPersonal(personal.get(i).getNombre(), personal.get(i).getContacto(),personal.get(i).getApodo(),personal.get(i).getExperiencia(),personal.get(i).getIdentificacion(),personal.get(i).getCargo());
        }
        personal.clear();
        super.onDestroyView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FragmentPersonalBinding binding;
    fragment_personal contexto = this;
    ListView listViewPersonal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPersonalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        fragment_personal context = this;
        listViewPersonal = binding.personalList;
        CustomAdapterPersonal adapter = new CustomAdapterPersonal(this.getContext(),gerente.personal);
        listViewPersonal.setAdapter(adapter);

        listViewPersonal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClasePersonal c = gerente.personal.get(position);
                Toast.makeText(context.getContext(),c.getNombre(),Toast.LENGTH_LONG).show();
            }
        });



        binding.nuevoPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new cuadroDialogoNuevoPersonal(contexto.getContext(),gerente);
            }
        });

        return root;
    }
}