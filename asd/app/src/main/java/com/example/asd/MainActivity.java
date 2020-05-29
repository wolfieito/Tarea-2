package com.example.asd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btnEditar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Editar.class);
                final EditText txtEd = (EditText) findViewById(R.id.txtNombre);
                final EditText txtEd2 = (EditText) findViewById(R.id.txtTelefono);
                final EditText txtEd3 = (EditText) findViewById(R.id.txtCorreo);
                final EditText txtEd4 = (EditText) findViewById(R.id.txaDesc);
                final DatePicker dp = (DatePicker) findViewById(R.id.dpEd);
                int dia = dp.getDayOfMonth();
                int mes = dp.getMonth();
                int año = dp.getYear();
                i.putExtra(getResources().getString(R.string.pnombre), txtEd.getText().toString());
                i.putExtra(getResources().getString(R.string.ptelefono), txtEd2.getText().toString());
                i.putExtra(getResources().getString(R.string.pemail), txtEd3.getText().toString());
                i.putExtra(getResources().getString(R.string.pdesc), txtEd4.getText().toString());
                i.putExtra("Dia", dia);
                i.putExtra("Mes", mes);
                i.putExtra("Año", año);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle Parametros = getIntent().getExtras();
        String Nombre = Parametros.getString(getResources().getString(R.string.pnombre));
        String Telefono = Parametros.getString(getResources().getString(R.string.ptelefono));
        String Email = Parametros.getString(getResources().getString(R.string.pemail));
        String Descripcion = Parametros.getString(getResources().getString(R.string.pdesc));
        int iDia = Parametros.getInt("Dia");
        int iMes = Parametros.getInt("Mes");
        int iAño = Parametros.getInt("Año");
        EditText txtNom = (EditText) findViewById(R.id.txtNombre);
        EditText txtTel = (EditText) findViewById(R.id.txtTelefono);
        EditText txtDesc = (EditText) findViewById(R.id.txaDesc);
        EditText txtEmail = (EditText) findViewById(R.id.txtCorreo);
        DatePicker dp = (DatePicker)findViewById(R.id.dpEd);
        txtNom.setText(Nombre);
        txtEmail.setText(Email);
        txtTel.setText(Telefono);
        txtDesc.setText(Descripcion);
        dp.updateDate(iAño,iMes,iDia);
    }
}
