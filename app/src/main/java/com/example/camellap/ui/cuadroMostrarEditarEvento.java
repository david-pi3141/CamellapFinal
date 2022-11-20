package com.example.camellap.ui;

import static com.example.camellap.ui.MainActivity.gerente;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.camellap.R;
import com.example.camellap.ViewModel.ClaseEvento;

public class cuadroMostrarEditarEvento {
    @SuppressLint("ResourceType")
    public cuadroMostrarEditarEvento(Context contexto, ClaseEvento evento) {
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.setContentView(R.layout.informacion_evento);

        Button enviarInfo = (Button) dialogo.findViewById(R.id.guardar);
        ImageButton salir = (ImageButton) dialogo.findViewById(R.id.salir);
        final EditText fechaE = (EditText) dialogo.findViewById(R.id.fechaevento);
        final EditText lugarE = (EditText) dialogo.findViewById(R.id.lugarevento);
        final EditText costoE = (EditText) dialogo.findViewById(R.id.costoevento);
        final EditText tematicaE = (EditText) dialogo.findViewById(R.id.tematicaevento);
        final EditText personalE = (EditText) dialogo.findViewById(R.id.personalevento);
        final EditText inventarioE = (EditText) dialogo.findViewById(R.id.inventarioevento);
        final EditText contratenteE = (EditText) dialogo.findViewById(R.id.contratanteevento);
        final EditText estadoPagoE = (EditText) dialogo.findViewById(R.id.estadopagoevento);

        fechaE.setText(evento.getFecha());
        lugarE.setText(evento.getLugar());
        costoE.setText(String.valueOf(evento.getCosto()));
        tematicaE.setText(evento.getTematica());
        personalE.setText(evento.getPersonal());
        inventarioE.setText(evento.getInventario());
        contratenteE.setText(evento.getContratante());
        estadoPagoE.setText(String.valueOf(evento.getEstadoPago()));

        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evento.setLugar(lugarE.getText().toString());
                evento.setCosto(Integer.parseInt(costoE.getText().toString()));
                evento.setTematica(tematicaE.getText().toString());
                evento.setPersonal(personalE.getText().toString());
                evento.setInventario(inventarioE.getText().toString());
                evento.setContratante(contratenteE.getText().toString());
                evento.setEstadoPago(Integer.parseInt(estadoPagoE.getText().toString()));

                dialogo.dismiss();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.dismiss();
            }
        });

        dialogo.show();
    }
}

