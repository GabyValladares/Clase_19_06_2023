package com.example.table_layaout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    EditText et_contexto;

    //SIEMPRE RECIBO EN EL MÉTODO onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        et_contexto=findViewById(R.id.txtContexto);
        et_contexto.setText("HOLA ");
        Bundle parametros=this.getIntent().getExtras();
        String edad=parametros.getString("edad");
        if(edad!=null){
        et_contexto.setText(edad);}
        else{
            et_contexto.setText("Nulo");
        }
    }
}