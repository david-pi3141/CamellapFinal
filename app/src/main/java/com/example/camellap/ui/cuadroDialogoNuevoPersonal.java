package com.example.camellap.ui;

import static com.example.camellap.ui.MainActivity.gerente;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.camellap.R;
import com.example.camellap.ViewModel.ClasePersonal;
import com.example.camellap.ViewModel.Gerente;
import com.example.camellap.db.DbCamellap;

public class cuadroDialogoNuevoPersonal {
    public cuadroDialogoNuevoPersonal(Context contexto, Gerente gerente) {
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.setContentView(R.layout.nuevo_personal_cuadro);

        Button enviarInfo = (Button) dialogo.findViewById(R.id.enviarinfopersonal);
        TextView titulo = (TextView) dialogo.findViewById(R.id.titulopersonal);
        ImageButton salir = (ImageButton) dialogo.findViewById(R.id.salir);
        final EditText nombre = (EditText) dialogo.findViewById(R.id.nombrepersonal);
        final EditText contacto = (EditText) dialogo.findViewById(R.id.contactopersonal);
        final EditText apodo = (EditText) dialogo.findViewById(R.id.apodopersonal);
        final EditText experiancia = (EditText) dialogo.findViewById(R.id.experienciapersonal);
        final EditText identificacion = (EditText) dialogo.findViewById(R.id.identificacionpersonal);
        final EditText cargo = (EditText) dialogo.findViewById(R.id.cargopersonal);


        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nombre.getText().toString().equals("") && !contacto.getText().toString().equals("") && !apodo.getText().toString().equals("") && !experiancia.getText().toString().equals("") && !identificacion.getText().toString().equals("") && !cargo.getText().toString().equals("")) {

                    DbCamellap dbContactos = new DbCamellap(contexto);
                    long id = dbContactos.insertarPersonal(nombre.getText().toString(), contacto.getText().toString(), apodo.getText().toString(),experiancia.getText().toString(), identificacion.getText().toString(), cargo.getText().toString());

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
                try {
                    fragment_personal.personal.add(new ClasePersonal(nombre.getText().toString(),contacto.getText().toString(),apodo.getText().toString(),experiancia.getText().toString(),identificacion.getText().toString(),cargo.getText().toString()));
                    dialogo.dismiss();
                }catch (RuntimeException e){
                    Toast.makeText(contexto,"No se ingresaron datos completos",Toast.LENGTH_LONG).show();
                    dialogo.dismiss();
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
