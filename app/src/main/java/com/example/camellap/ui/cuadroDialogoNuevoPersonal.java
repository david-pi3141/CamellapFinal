package com.example.camellap.ui;

import static com.example.camellap.ui.MainActivity.gerente;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.camellap.R;
import com.example.camellap.ViewModel.ClasePersonal;
import com.example.camellap.ViewModel.Gerente;

public class cuadroDialogoNuevoPersonal {
    public cuadroDialogoNuevoPersonal(Context contexto, Gerente gerente) {
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.setContentView(R.layout.nuevo_personal_cuadro);

        Button enviarInfo = (Button) dialogo.findViewById(R.id.enviarinfopersonal);
        TextView titulo = (TextView) dialogo.findViewById(R.id.titulopersonal);
        final EditText nombre = (EditText) dialogo.findViewById(R.id.nombrepersonal);
        final EditText contacto = (EditText) dialogo.findViewById(R.id.contactopersonal);
        final EditText apodo = (EditText) dialogo.findViewById(R.id.apodopersonal);
        final EditText experiancia = (EditText) dialogo.findViewById(R.id.experienciapersonal);
        final EditText identificacion = (EditText) dialogo.findViewById(R.id.identificacionpersonal);
        final EditText cargo = (EditText) dialogo.findViewById(R.id.cargopersonal);


        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fragment_personal.personal.add(new ClasePersonal(nombre.getText().toString(),contacto.getText().toString(),apodo.getText().toString(),experiancia.getText().toString(),identificacion.getText().toString(),cargo.getText().toString()));
                    dialogo.dismiss();
                }catch (RuntimeException e){
                    Toast.makeText(contexto,"No se ingresaron datos completos",Toast.LENGTH_LONG).show();
                    dialogo.dismiss();
                }
            }
        });

        dialogo.show();
    }
}
