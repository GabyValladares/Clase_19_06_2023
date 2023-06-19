package com.example.table_layaout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText et_nombres,et_cedula,et_edad;
    Spinner sp_sexo;
    String nombre,cedula,edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        et_nombres=findViewById(R.id.txtNombres);
        et_cedula=findViewById(R.id.txtCedula);
        et_edad=findViewById(R.id.txtEdad);
        sp_sexo=findViewById(R.id.spSexo);

        nombre=et_nombres.getText().toString();
        cedula=et_cedula.getText().toString();



        ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(this, R.array.ListSexo, android.R.layout.simple_spinner_item);
        list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_sexo.setAdapter(list);
        sp_sexo.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "Seleccionaste: " + selectedItem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void irResultados(View view){
        //DECLARADO BUNDLE QUE ME PERMITE EL ENVÍO DE INFORMACIÓN DE UNA ACTIVIDAD A OTRA
        edad=et_edad.getText().toString();
        Bundle parametros=new Bundle();
        parametros.putString("edad",edad);
        Intent intent=new Intent(this,Resultado.class);
        intent.putExtras(parametros);
        view.getContext().startActivity(intent);

    }
}