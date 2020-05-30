package com.example.asd;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class Editar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Bundle Parametros = getIntent().getExtras();
        final String Nombre = Parametros.getString(getResources().getString(R.string.pnombre));
        final String Telefono = Parametros.getString(getResources().getString(R.string.ptelefono));
        final String Email = Parametros.getString(getResources().getString(R.string.pemail));
        final String Descripcion = Parametros.getString(getResources().getString(R.string.pdesc));
        int iDia = Parametros.getInt("Dia");
        int iMes = Parametros.getInt("Mes");
        int iAño = Parametros.getInt("Año");
        TextView tvNom = (TextView)findViewById(R.id.tvNombreEd);
        TextView tvTel = (TextView)findViewById(R.id.tvTelEd);
        TextView tvDesc = (TextView)findViewById(R.id.tvDescEd);
        TextView tvEmail = (TextView)findViewById(R.id.tvCorreoEd);
        TextView tvFecha = (TextView)findViewById(R.id.tvFechaEd);
        tvNom.setText("Nombre "+Nombre);
        tvEmail.setText("Email "+Email);
        tvTel.setText("Telefono "+Telefono);
        tvDesc.setText("Descripcion del contacto "+Descripcion);
        tvFecha.setText("Fecha de nacimiento "+iDia+"/"+(iMes+1)+"/"+iAño);
        Button edit = (Button) findViewById(R.id.btnEditar);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Editar.this, MainActivity.class);
                Bundle Parametros = getIntent().getExtras();
                final int dd = Parametros.getInt("Dia");
                final int mm = Parametros.getInt("Mes");
                final int aa = Parametros.getInt("Año");
                i.putExtra(getResources().getString(R.string.pnombre), Nombre);
                i.putExtra(getResources().getString(R.string.ptelefono), Telefono);
                i.putExtra(getResources().getString(R.string.pemail), Email);
                i.putExtra(getResources().getString(R.string.pdesc), Descripcion);
                i.putExtra("Dia", dd);
                i.putExtra("Mes", mm);
                i.putExtra("Año", aa);
                startActivity(i);
            }
        });
    }
}
