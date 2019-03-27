package com.juliodev.volley;

import android.content.Context;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<Contact> arrayList;
    private static LayoutInflater inflater;
    private ImageLoader loader;

    // cargador de imagenes si no tira una excepcion de no poder
    // usar peticiones en el hilo principal, networkmainthread excepction

    public ContactAdapter(Context context, ArrayList<Contact> arrayList){

        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() { return this.arrayList.size(); }

    @Override
    public Object getItem(int position) { return position; }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null) view = inflater.inflate(R.layout.list_view,null);

        TextView txtName = view.findViewById(R.id.txtNombre);
        TextView txtEmail = view.findViewById(R.id.txtEmail);
        TextView txtGenero = view.findViewById(R.id.txtGenero);
        // la magia de picasso
        ImageView image = view.findViewById(R.id.imgImagen);

        Contact c = this.arrayList.get(position);

        Picasso.get().load(c.getImage()).into(image);
        txtGenero.setText(c.getGender());
        txtEmail.setText(c.getEmail());
        txtName.setText(c.getName());

        return view;
    }
}
