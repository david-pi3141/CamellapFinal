package com.example.camellap.ui;

import static com.example.camellap.ui.MainActivity.gerente;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.camellap.R;
import com.example.camellap.ViewModel.ClaseContratante;
import com.example.camellap.ViewModel.ClasePersonal;
import com.example.camellap.ViewModel.CustomAdapter;
import com.example.camellap.ViewModel.Gerente;
import com.example.camellap.db.DbCamellap;
import com.example.camellap.ui.camellap.HomeFragment;

public class cuadroDialogoNuevoContratante {

    public cuadroDialogoNuevoContratante(Context contexto) {
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.setContentView(R.layout.nuevo_contratante_cuadro);

        Button enviarInfo = (Button) dialogo.findViewById(R.id.enviar);
        TextView titulo = (TextView) dialogo.findViewById(R.id.tutulocontratantes);
        ImageButton salir = (ImageButton) dialogo.findViewById(R.id.salir);
        final EditText nombre = (EditText) dialogo.findViewById(R.id.nombrecontratante);
        final EditText contacto = (EditText) dialogo.findViewById(R.id.contatocontratante);
        final EditText identificacion = (EditText) dialogo.findViewById(R.id.identificacioncontratante);
        final EditText estadopago = (EditText) dialogo.findViewById(R.id.estadopagocontratante);

        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nombre.getText().toString().equals("") && !contacto.getText().toString().equals("") && !identificacion.getText().toString().equals("") && !estadopago.getText().toString().equals("")) {

                    DbCamellap dbContactos = new DbCamellap(contexto);
                    long id = dbContactos.insertarContratante(nombre.getText().toString(), contacto.getText().toString(), identificacion.getText().toString(),estadopago.getText().toString());

                    if (id > 0) {
                        Toast.makeText(contexto, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        dialogo.dismiss();
                    } else {
                        Toast.makeText(contexto, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                        dialogo.dismiss();
                    }
                } else {
                    Toast.makeText(contexto, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
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
