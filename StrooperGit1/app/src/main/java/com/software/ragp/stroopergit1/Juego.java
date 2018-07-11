package com.software.ragp.stroopergit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Juego extends AppCompatActivity {
    TextView txtaciertos, txtintentos, txtcorrectas, txtincorrectas, txttiempo, txtpalabra;
    Button btnColor1, btnColor2, btnColor3, btnColor4;
    public static int aciertos, intentos, correctas, incorrectas, tiempo, palabra;
    int [] segundos = {0,30};
    List<String> listaPalabras = new ArrayList<>();
    List<Integer> listaColores = new ArrayList<>();
    List<Integer> listatmp = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        inizialite();
    }

    private void inizialite() {
        txtaciertos = findViewById(R.id.txtaciertos);
        txtintentos = findViewById(R.id.txtintentos);
        txtcorrectas = findViewById(R.id.txtcorrectas);
        txtincorrectas = findViewById(R.id.txtincorrectas);
        txttiempo = findViewById(R.id.txttiempo);
        txtpalabra = findViewById(R.id.txtpalabra);
    }
}
