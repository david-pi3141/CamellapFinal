package com.example.camellap.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.camellap.R;
import com.example.camellap.ViewModel.Gerente;

public class cuadroDialogoNuevoContratante {
    public cuadroDialogoNuevoContratante(Context contexto, Gerente gerente) {
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.setContentView(R.layout.nuevo_contratante_cuadro);

        Button enviarInfo = (Button) dialogo.findViewById(R.id.enviar);
        TextView titulo = (TextView) dialogo.findViewById(R.id.tutulocontratantes);
        final EditText nombre = (EditText) dialogo.findViewById(R.id.nombrecontratante);
        final EditText contacto = (EditText) dialogo.findViewById(R.id.contatocontratante);
        final EditText identificacion = (EditText) dialogo.findViewById(R.id.identificacioncontratante);
        final EditText estadopago = (EditText) dialogo.findViewById(R.id.estadopagocontratante);

        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerente.nuevoContratante(nombre.getText().toString(),contacto.getText().toString(),identificacion.getText().toString(), false);
                Toast.makeText(contexto,"Creado",Toast.LENGTH_LONG).show();
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }
}
