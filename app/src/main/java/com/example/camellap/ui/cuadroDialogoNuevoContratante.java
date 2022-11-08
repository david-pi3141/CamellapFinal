package com.example.camellap.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        final EditText infoevento = (EditText) dialogo.findViewById(R.id.infoeventocontratante);

        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }
}
