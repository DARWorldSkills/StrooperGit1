package com.software.ragp.stroopergit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener{
    Button btnJugar, btnPuntaje, btnConfiguracion;
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
                guardar=0;
                break;

            case R.id.btnConfiguracion:
                guardar=0;
                break;
        }
    }
}
