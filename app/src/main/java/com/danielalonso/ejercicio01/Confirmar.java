package com.danielalonso.ejercicio01;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Confirmar extends AppCompatActivity {

    private Bundle extras;
    private MaterialTextView set_nombre;
    private MaterialTextView set_num_cuenta;
    private MaterialTextView set_fecha_nacimiento;
    private MaterialTextView set_carrera;

    private ShapeableImageView img_carrera;

    private String[] carreras;

    private MaterialButton editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        try {
            carreras = getResources().getStringArray(R.array.carreras);

            extras = getIntent().getExtras();

            String fechaNacimiento = extras.getString(getString(R.string.p_fecha_nacimiento));
            String edad = calculaEdad(fechaNacimiento);

            String nombreCompleto = extras.getString(getString(R.string.p_nombre)) + " " + extras.getString(getString(R.string.p_apellidos));
            String numCuenta = extras.getString(getString(R.string.p_num_cuenta));
            String carrera = extras.getString(getString(R.string.p_carrera));

            img_carrera = (ShapeableImageView) findViewById(R.id.imgIngenieria);

            set_nombre = (MaterialTextView) findViewById(R.id.tvNombreCompleto);
            set_num_cuenta = (MaterialTextView) findViewById(R.id.tvNumCuenta);
            set_fecha_nacimiento = (MaterialTextView) findViewById(R.id.tvEdad);
            set_carrera = (MaterialTextView) findViewById(R.id.tvCarrera);


            set_nombre.setText(nombreCompleto);
            set_num_cuenta.setText(numCuenta);
            set_fecha_nacimiento.setText(edad + getResources().getString(R.string.texto_anios));
            set_carrera.setText(carrera);

            if(carrera.equals(carreras[0])){
                img_carrera.setImageResource(R.drawable.aeroespacial);
            }
            else if(carrera.equals(carreras[1])){
                img_carrera.setImageResource(R.drawable.civil);
            }
            else if(carrera.equals(carreras[2])){
                img_carrera.setImageResource(R.drawable.geomatica);
            }
            else if(carrera.equals(carreras[3])){
                img_carrera.setImageResource(R.drawable.ambiental);
            }
            else if(carrera.equals(carreras[4])){
                img_carrera.setImageResource(R.drawable.geofisica);
            }
            else if(carrera.equals(carreras[5])){
                img_carrera.setImageResource(R.drawable.geologica);
            }
            else if(carrera.equals(carreras[6])){
                img_carrera.setImageResource(R.drawable.petrolera);
            }
            else if(carrera.equals(carreras[7])){
                img_carrera.setImageResource(R.drawable.minas);
            }
            else if(carrera.equals(carreras[8])){
                img_carrera.setImageResource(R.drawable.computacion);
            }
            else if(carrera.equals(carreras[9])){
                img_carrera.setImageResource(R.drawable.electrica);
            }
            else if(carrera.equals(carreras[10])){
                img_carrera.setImageResource(R.drawable.telecom);
            }
            else if(carrera.equals(carreras[11])){
                img_carrera.setImageResource(R.drawable.mecanica);
            }
            else if(carrera.equals(carreras[12])){
                img_carrera.setImageResource(R.drawable.industrial);
            }
            else if(carrera.equals(carreras[13])){
                img_carrera.setImageResource(R.drawable.mecatronica);
            }
            else if(carrera.equals(carreras[14])){
                img_carrera.setImageResource(R.drawable.biomedicos);
            }



        } catch (ParseException e) {
            e.printStackTrace();
        }


        editar = (MaterialButton) findViewById(R.id.btnEditar);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public String calculaEdad(String fechaNacimiento) throws ParseException {

        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
        GregorianCalendar hoy = new GregorianCalendar();
        GregorianCalendar diaNacimiento = new GregorianCalendar();
        GregorianCalendar diaNacimientoHoy = new GregorianCalendar();

        diaNacimiento.setTime(date1);
        diaNacimientoHoy.setTime(date1);
        diaNacimientoHoy.set(Calendar.YEAR, hoy.get(Calendar.YEAR));

        int age = hoy.get(Calendar.YEAR) - diaNacimiento.get(Calendar.YEAR);

        if(hoy.getTimeInMillis() < diaNacimientoHoy.getTimeInMillis())
            age--;

        return Integer.toString(age);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
