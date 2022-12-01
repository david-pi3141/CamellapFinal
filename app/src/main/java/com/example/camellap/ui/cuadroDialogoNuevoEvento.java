package com.example.camellap.ui;

import static com.example.camellap.ui.MainActivity.gerente;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.camellap.R;
import com.example.camellap.ViewModel.Gerente;
import com.example.camellap.db.DbCamellap;

import java.util.Calendar;

public class cuadroDialogoNuevoEvento {

    public cuadroDialogoNuevoEvento(Context contexto, Gerente gerente) {
        final Dialog dialogo = new Dialog(contexto);
        dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogo.setCancelable(false);
        dialogo.setContentView(R.layout.nuevo_evento_cuadro);

        Button enviarInfo = (Button) dialogo.findViewById(R.id.enviarinfo);
        TextView titulo = (TextView) dialogo.findViewById(R.id.titulo);
        ImageButton salir = (ImageButton) dialogo.findViewById(R.id.salir);
        final EditText fecha = (EditText) dialogo.findViewById(R.id.fecha);
        final EditText lugar = (EditText) dialogo.findViewById(R.id.lugar);
        final EditText costo = (EditText) dialogo.findViewById(R.id.costo);
        final EditText tematica = (EditText) dialogo.findViewById(R.id.tematica);
        Button nuevoContr = (Button) dialogo.findViewById(R.id.CrearContrEvento);


        enviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!fecha.getText().toString().equals("") && !lugar.getText().toString().equals("") && !costo.getText().toString().equals("") && !tematica.getText().toString().equals("")) {

                    DbCamellap dbContactos = new DbCamellap(contexto);
                    long id = dbContactos.insertarEvento(fecha.getText().toString(), lugar.getText().toString(), costo.getText().toString(),tematica.getText().toString());

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

        nuevoContr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new cuadroDialogoNuevoContratante(contexto);
                    dialogo.dismiss();
                }catch (RuntimeException e){
                    dialogo.dismiss();
                }
            }
        });

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int año = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(contexto, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },año,mes,dia);
                dpd.show();
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
