package com.example.camellap.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.camellap.R;
import com.example.camellap.ViewModel.ClaseInventario;
import com.example.camellap.ViewModel.Gerente;
import com.example.camellap.ui.inventario.GalleryFragment;
import com.example.camellap.ui.inventario.GalleryViewModel;

public class cuadroDialogoNuevoMaterial {

        public cuadroDialogoNuevoMaterial(Context contexto, Gerente gerente) {
            final Dialog dialogo = new Dialog(contexto);
            dialogo.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialogo.setCancelable(false);
            dialogo.setContentView(R.layout.nuevo_material_cuadro);

            Button enviarInfo = (Button) dialogo.findViewById(R.id.enviar_material);
            TextView titulo = (TextView) dialogo.findViewById(R.id.textView);
            final EditText nombreMaterial = (EditText) dialogo.findViewById(R.id.nombre_material);
            final EditText cantidad = (EditText) dialogo.findViewById(R.id.cantidad_material);


            enviarInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GalleryFragment.inventario.add(new ClaseInventario(nombreMaterial.getText().toString(), Integer.parseInt(cantidad.getText().toString())));
                    dialogo.dismiss();
                }
            });

            dialogo.show();
        }

}
