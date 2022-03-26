package com.example.uceva2022_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed1, ed2;
    Button btLogin, btnDelegado, btnInterfaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Hola método onCreate", Toast.LENGTH_LONG).show();
        // enlazamiento
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        btLogin = findViewById(R.id.btnLogin);
        btnDelegado = findViewById(R.id.btnDelegado);
        btnInterfaz = findViewById(R.id.btnInterfaz);

        // manipular
        // opcion "delegada"
        btnDelegado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hola método delegado", Toast.LENGTH_LONG).show();
            }
        });
        // Por interfaz
        btnInterfaz.setOnClickListener(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"Hola método onpause", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"Hola método on destroy", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInterfaz:
                Toast.makeText(getApplicationContext(),"Hola método interfaz", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
    public void saluda(View v){
        //Toast.makeText(this,"Hola mundo", Toast.LENGTH_LONG).show();
        Intent ir = new Intent(this,MainActivity2.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle data = new Bundle();
        data.putString("name", ed1.getText().toString());
        data.putString("passwd", ed2.getText().toString());
        ir.putExtras(data);
        startActivity(ir);
    }
}