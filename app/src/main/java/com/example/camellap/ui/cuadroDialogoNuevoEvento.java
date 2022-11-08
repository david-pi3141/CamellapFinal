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
import com.example.camellap.ui.inventario.GalleryFragment;

public class cuadroDialogoNuevoEvento {

    public cuadroDialogoNuevoEvento(Context contexto, Gerente gerente) {
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.setContentView(R.layout.nuevo_evento_cuadro);

        Button enviarInfo = (Button) dialogo.findViewById(R.id.enviarinfo);
        TextView titulo = (TextView) dialogo.findViewById(R.id.titulo);
        final EditText fecha = (EditText) dialogo.findViewById(R.id.fecha);
        final EditText lugar = (EditText) dialogo.findViewById(R.id.lugar);
        final EditText costo = (EditText) dialogo.findViewById(R.id.costo);
        final EditText tematica = (EditText) dialogo.findViewById(R.id.tematica);


        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerente.nuevoEvento(Float.parseFloat(costo.getText().toString()),lugar.getText().toString(),tematica.getText().toString(),fecha.getText().toString());
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }
}
