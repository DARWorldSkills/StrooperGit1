package com.software.ragp.stroopergit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Resumen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
    }

    public void compartir(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        intent.setPackage("com.twitter.android");
        try {
            Toast.makeText(this, "No cuentas con está app, por favor instala está app", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            startActivity(intent);
        }



    }
}
