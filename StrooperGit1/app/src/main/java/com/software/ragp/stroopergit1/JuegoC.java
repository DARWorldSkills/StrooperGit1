package com.software.ragp.stroopergit1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JuegoC extends AppCompatActivity implements View.OnClickListener{
    TextView txtaciertos, txtintentos, txtcorrectas, txtincorrectas, txttiempo, txtpalabra;
    Button btnColor1, btnColor2, btnColor3, btnColor4;
    public static int aciertos, intentos, correctas, incorrectas, palabra;
    int [] segundos = {0,30};
    List<String> listaPalabras = new ArrayList<>();
    List<Integer> listaColores = new ArrayList<>();
    List<Integer> listatmp = new ArrayList<>();
    int icR, ipR, valorcito, ab=0;
    boolean badera=true;
    int modo, tiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_c);
        inizialite();
        badera=true;
        ab=0;
        aciertos =0; intentos=0; correctas=0; incorrectas=0; palabra=0;
        modogame();
        if (modo==1){
            segundos = new int[]{0,30};
        }else {
            segundos = new int[]{0,0};
        }

        listar();
        randomizar();
        insertarValores();
        txttiempo.setText("Seg: "+segundos[1]);
        prueba();
        gogame();
    }

    private void modogame() {
        SharedPreferences valores = getSharedPreferences("juegoC", MODE_PRIVATE);
        modo = valores.getInt("modo",1);
        tiempo = valores.getInt("tiempo",3);
    }

    private void gogame() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (badera){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            segundos[0]++;
                            if (modo==1) {
                                segundos[1]--;
                            }else{
                                segundos[1]++;
                            }
                            txttiempo.setText("Seg: "+segundos[1]);
                            if (segundos[0]==tiempo){
                                intentos++;
                                incorrectas++;
                                randomizar();
                                insertarValores();
                                segundos[0]=0;

                            }
                            endGame();
                        }
                    });
                }
            }
        });
        thread.start();
    }

    private void endGame() {
        if ((segundos[1]==0 || incorrectas==3) && ab==0 && modo==1){
            Intent intent = new Intent(JuegoC.this,Resumen.class);
            ab=1;
            badera=false;
            startActivity(intent);
            finish();
        }
        if ((incorrectas==3) && ab==0 && modo==2){
            Intent intent = new Intent(JuegoC.this,Resumen.class);
            ab=1;
            badera=false;
            startActivity(intent);
            finish();
        }
    }

    private void prueba() {
        Log.e("CosaRara",""+listatmp.get(0));
        Log.e("CosaRara",""+listatmp.get(1));
        Log.e("CosaRara",""+listatmp.get(2));
        Log.e("CosaRara",""+listatmp.get(3));

    }

    private void randomizar() {
        Collections.shuffle(listatmp);
        ipR = (int) (Math.random() * 4);
        icR = (int) (Math.random() * 4);

        txtpalabra.setText(listaPalabras.get(ipR));
        txtpalabra.setTextColor(listaColores.get(icR));


        btnColor1.setBackgroundColor(listatmp.get(0));
        btnColor2.setBackgroundColor(listatmp.get(1));
        btnColor3.setBackgroundColor(listatmp.get(2));
        btnColor4.setBackgroundColor(listatmp.get(3));

    }

    private void listar() {
        listaPalabras = new ArrayList<>();
        listaColores = new ArrayList<>();

        listaPalabras.add("AMARILLO");
        listaColores.add(getColor(R.color.colorAmarilloJ));
        listaPalabras.add("AZUL");
        listaColores.add(getColor(R.color.colorAzul));
        listaPalabras.add("ROJO");
        listaColores.add(getColor(R.color.colorRojo));
        listaPalabras.add("VERDE");
        listaColores.add(getColor(R.color.colorVerde));

        listatmp = listaColores;

    }

    private void inizialite() {
        txtaciertos = findViewById(R.id.txtaciertos);
        txtintentos = findViewById(R.id.txtintentos);
        txtcorrectas = findViewById(R.id.txtcorrectas);
        txtincorrectas = findViewById(R.id.txtincorrectas);
        txttiempo = findViewById(R.id.txttiempo);
        txtpalabra = findViewById(R.id.txtpalabra);
        btnColor1 = findViewById(R.id.btnColor1);
        btnColor2 = findViewById(R.id.btnColor2);
        btnColor3 = findViewById(R.id.btnColor3);
        btnColor4 = findViewById(R.id.btnColor4);

        btnColor1.setOnClickListener(this);
        btnColor2.setOnClickListener(this);
        btnColor3.setOnClickListener(this);
        btnColor4.setOnClickListener(this);
    }


    public void validar(){
        if (valorcito==1){
            if (listaColores.get(icR)==listatmp.get(0)){
                correctas+=1;
            }else {
                incorrectas+=1;
            }
        }

        if (valorcito==2){
            if (listaColores.get(icR)==listatmp.get(1)){
                correctas+=1;
            }else {
                incorrectas+=1;
            }
        }

        if (valorcito==3){
            if (listaColores.get(icR)==listatmp.get(2)){
                correctas+=1;
            }else {
                incorrectas+=1;
            }
        }

        if (valorcito==4){
            if (listaColores.get(icR)==listatmp.get(3)){
                correctas+=1;
            }else {
                incorrectas+=1;
            }
        }

    }

    public void insertarValores(){
        if (intentos==0){
            aciertos=100;
        }else {
            if (intentos>1 && correctas>1){
                float tmp1 = correctas/intentos ;
                double tmp2 = tmp1 * 100;
                aciertos = (int) tmp2;
            }else {
                aciertos=0;
            }
        }


        txtcorrectas.setText("Correctas: "+correctas );
        txtincorrectas.setText("Incorrectas: "+incorrectas );
        txtaciertos.setText("Aciertos: "+aciertos+"%" );
        txtintentos.setText("Intentos: "+intentos );
    }

    public void variosMetodos(){
        prueba();
        segundos[0]=0;
        intentos++;
        validar();
        randomizar();
        insertarValores();
        endGame();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnColor1:
                valorcito=1;
                variosMetodos();
                break;
            case R.id.btnColor2:
                valorcito=2;
                variosMetodos();
                break;
            case R.id.btnColor3:
                valorcito=3;
                variosMetodos();
                break;
            case R.id.btnColor4:
                valorcito=4;
                variosMetodos();
                break;
        }
    }
}
