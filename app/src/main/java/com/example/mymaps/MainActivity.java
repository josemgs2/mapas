package com.example.mymaps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.MenuItem;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.title_name_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rvPlaces = (RecyclerView) findViewById(R.id.rvPlaces);

        ArrayList<Place> places = new ArrayList<>();

        Place moneda = new Place();
        moneda.setName("Palacio de la moneda");
        moneda.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Palacio_de_La_Moneda_-_miguelreflex.jpg/2880px-Palacio_de_La_Moneda_-_miguelreflex.jpg");
        moneda.setLatitud(-33.4429);
        moneda.setLongitud(-70.6539);

        places.add(moneda);

        Place arauco = new Place();
        arauco.setName("Parque Araucano");
        arauco.setUrl("https://conociendochile.cl/wp-content/uploads/2019/07/1408381023_parque_araucano_2-1000x666-1.jpg");
        arauco.setLatitud(-33.403);
        arauco.setLongitud(-70.5742);

        places.add(arauco);

        Place costanera = new Place();
        costanera.setName("Sky Costanera");
        costanera.setUrl("https://images.squarespace-cdn.com/content/v1/53e3ed8ce4b027b8a4612d44/1408460544759-468YDWT607GNG92JAYLH/ke17ZwdGBToddI8pDm48kA47qaxzGU3oa60Mv3IrElh7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0hGaawTDWlunVGEFKwsEdnE_ZbuhWuTjDl9Hn0Vaidb23CyzgPgNZ_l0zINYXrCLdg/Costanera_Center_+Contexto+jpg.jpg?format=2500w");
        costanera.setLatitud(-33.4168);
        costanera.setLongitud(-70.6058);

        places.add(costanera);

        Place sanCristobal = new Place();
        sanCristobal.setName("Cerro San Cristóbal");
        sanCristobal.setUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Chile_-_Santiago_24_-_Virgin_Mary_statue_on_Cerro_San_Crist%C3%B3bal_%286977789601%29.jpg/1280px-Chile_-_Santiago_24_-_Virgin_Mary_statue_on_Cerro_San_Crist%C3%B3bal_%286977789601%29.jpg");
        sanCristobal.setLatitud(-33.425278);
        sanCristobal.setLongitud(-70.633333);

        places.add(sanCristobal);

        Place bahai = new Place();
        bahai.setName("Templo Bahá’í");
        bahai.setUrl("https://img.eldefinido.cl/portadas/650/2016-11-23-1792NDL3903.jpg");
        bahai.setLatitud(-33.476389);
        bahai.setLongitud(-70.511611);

        places.add(bahai);

        Place valleNevado = new Place();
        valleNevado.setName("Valle nevado");
        valleNevado.setUrl("https://i4.visitchile.com/img/GalleryContent/506/slider/VALLE_NEVADO.jpg");
        valleNevado.setLatitud(-33.3543477);
        valleNevado.setLongitud(-70.2491559);

        places.add(valleNevado);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvPlaces.setLayoutManager(gridLayoutManager);

        MenuAdaptador adaptador = new MenuAdaptador(places, this);
        rvPlaces.setAdapter(adaptador);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
