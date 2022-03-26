package com.example.uceva2022_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uceva2022_1.fragments.BlankFragment;

public class MainActivity2 extends AppCompatActivity {

    TextView datosMostrar;
    Integer contador = 0;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        datosMostrar = findViewById(R.id.textView);
        Bundle delivery = getIntent().getExtras();
        datosMostrar.setText("Name: "+delivery.get("name") + " passwd: "+ delivery.get("passwd"));
        // insert fragment programatical
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        BlankFragment fragmento =  BlankFragment.newInstance(delivery.get("name").toString(),delivery.get("name").toString());
        fragmentTransaction.add(R.id.fragmentContainer,fragmento);
        fragmentTransaction.commit();
        // insert fragment programatical


    }

    public void atras(View v){
        //Toast.makeText(this,"Hola mundo", Toast.LENGTH_LONG).show();
        Intent ir = new Intent(this,MainActivity.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);
    }

    public void contar(View v){
     contador = contador + 1;
        datosMostrar.setText("Contador: "+contador);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"Hola método onpause", Toast.LENGTH_LONG).show();
        /*
        Bundle data = new Bundle();
        data.putInt("contador",contador);
        onSaveInstanceState(data);
         Si cierras la actividad este método no será llamado. Este método es solo para guardar un estado útil mientras existe la actividad
        */
        /*
        1. Base de datos -> Sqlite
         */

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contador",contador);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contador");
    }
}