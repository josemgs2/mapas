package com.example.mymaps;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class MenuAdaptador extends RecyclerView.Adapter<MenuAdaptador.ContactoViewHolder>{

    Activity activity;
    ArrayList<Place> places;

    public MenuAdaptador(ArrayList<Place> places, Activity activity) {
        this.places = places;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_menu, parent, false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Place place = places.get(position);

        Picasso.with(activity)
                .load(place.getUrl())
                .placeholder(R.drawable.ic_image)
                .into(contactoViewHolder.imgFoto);

        contactoViewHolder.tvNamePlace.setText(place.getName());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity, MapsActivity.class);
                intent.putExtra("lat", place.getLatitud());
                intent.putExtra("lon", place.getLongitud());
                intent.putExtra("name", place.getName());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNamePlace;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto        = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNamePlace    = (TextView) itemView.findViewById(R.id.tvNamePlace);
        }
    }
}
