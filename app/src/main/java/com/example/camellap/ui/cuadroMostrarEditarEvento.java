package com.example.camellap.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.camellap.R;

public class cuadroMostrarEditarEvento {
    public cuadroMostrarEditarEvento(Context contexto) {
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

        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

