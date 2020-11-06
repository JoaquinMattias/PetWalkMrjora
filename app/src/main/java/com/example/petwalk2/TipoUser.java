package com.example.petwalk2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipoUser extends AppCompatActivity {
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_user);
        btn1 =(Button) findViewById(R.id.btnPaseador);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(TipoUser.this, RegistroPaseador.class);
                TipoUser.this.startActivity(p);
            }
        });
        btn2 = (Button) findViewById(R.id.btnclinte);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(TipoUser.this, RegistroCliente.class);
                TipoUser.this.startActivity(c);
            }
        });
    }
}