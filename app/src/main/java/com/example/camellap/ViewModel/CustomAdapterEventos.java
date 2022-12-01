package com.example.camellap.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.camellap.R;

import java.util.List;

public class CustomAdapterEventos extends BaseAdapter {
    Context context;
    List<ClaseEvento> lst;

    public CustomAdapterEventos(Context context, List<ClaseEvento> lst) {
        this.context = context;
        this.lst = lst;
    }

    public void setLst(List<ClaseEvento> lst) {
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imagen_contacto;
        TextView Nombre;
        TextView Contacto;
        TextView Identificacion;

        ClaseEvento c = lst.get(position);
        if(convertView == null||lst.get(position).getEstadoPago())
            convertView = LayoutInflater.from(context).inflate(R.layout.informacion_mostrada,null);

        Nombre = convertView.findViewById(R.id.Nombre);
        Contacto = convertView.findViewById(R.id.Contacto);
        Identificacion = convertView.findViewById(R.id.Identificacion);

        Nombre.setText(c.getContratante());
        Contacto.setText(String.valueOf(c.getEstadoPago()));
        Identificacion.setText(c.getFecha());

        return convertView;
    }

    public void setData(List<ClaseEvento> contratantes) {
        this.lst = contratantes;
        notifyDataSetChanged();
    }
}