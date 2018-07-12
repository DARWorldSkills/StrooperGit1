package com.software.ragp.stroopergit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity implements View.OnClickListener{
    ImageButton btnJugar, btnPuntaje, btnConfiguracion;
    int guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        guardar=0;
        inizialite();
    }

    private void inizialite() {
       btnJugar = findViewById(R.id.btnJugar);
        btnPuntaje = findViewById(R.id.btnPuntaje);
        btnConfiguracion = findViewById(R.id.btnConfiguracion);


        btnJugar.setOnClickListener(this);
        btnPuntaje.setOnClickListener(this);
        btnConfiguracion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnJugar:
                intent = new Intent(Menu.this, Juego.class);
                guardar=1;
                startActivity(intent);
                break;

            case R.id.btnPuntaje:
                Intent intent1 = new Intent(Menu.this, Puntaje.class);
                guardar=0;
                startActivity(intent1);
                break;

            case R.id.btnConfiguracion:
                Intent intent2 = new Intent(Menu.this, Configuracion.class);
                guardar=0;
                startActivity(intent2);
                break;
        }
    }
}
