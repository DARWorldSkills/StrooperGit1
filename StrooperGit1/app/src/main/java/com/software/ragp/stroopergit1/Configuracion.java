package com.software.ragp.stroopergit1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity {
    RadioButton rbtnTiempo, rbtnIntentos;
    EditText txttiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        inizialite();
        ingresarPreferencias();

    }

    private void inizialite() {
        rbtnTiempo = findViewById(R.id.rbtnTiempo);
        rbtnIntentos = findViewById(R.id.rbtnIntentos);
        txttiempo = findViewById(R.id.txttiempoC);

    }

    public void ingresarPreferencias(){
        SharedPreferences valores = getSharedPreferences("juegoC",MODE_PRIVATE);
        int modo = valores.getInt("modo",1);
        int tiempo = valores.getInt("tiempo",1);
        if (modo==1){
            rbtnTiempo.setChecked(true);
        }
        if (modo==2){
            rbtnIntentos.setChecked(true);
        }

        txttiempo.setText(Integer.toString(tiempo));

    }

    public void guardarPreferencias(){
        SharedPreferences valores = getSharedPreferences("juegoC",MODE_PRIVATE);
        SharedPreferences.Editor editor = valores.edit();
        if (rbtnTiempo.isChecked()){
            editor.putInt("modo",1);
        }
        if (rbtnIntentos.isChecked()){
            editor.putInt("modo",2);
        }
        int tiempo = Integer.parseInt(txttiempo.getText().toString());
        if (tiempo>0 && tiempo<11){
            editor.putInt("tiempo",tiempo);
            editor.commit();
            Intent intent = new Intent(Configuracion.this, JuegoC.class);
            startActivity(intent);
            finish();

        }else {
            Toast.makeText(this, "Por favor ingrese el tiempo en el rango establecido", Toast.LENGTH_SHORT).show();
        }
    }


    public void guardar(View view) {
        guardarPreferencias();
    }
}
