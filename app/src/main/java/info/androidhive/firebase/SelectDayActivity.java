package info.androidhive.firebase;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import java.util.Calendar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Tania on 29/04/2017.
 */

public class SelectDayActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_fecha, btn_hora, btn_next_fecha;
    EditText eFecha, eHora;
    private int dia, mes, ano, hora, minutos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        btn_fecha = (Button)findViewById(R.id.btn_fecha);
        btn_hora = (Button)findViewById(R.id.btn_hora);
        btn_next_fecha = (Button)findViewById(R.id.btn_next_fecha);
        eFecha = (EditText)findViewById(R.id.eFecha);
        eHora = (EditText)findViewById(R.id.eHora);
        btn_fecha.setOnClickListener(this);
        btn_hora.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_next_fecha = (Button)findViewById(R.id.btn_next_fecha);

        btn_next_fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((!eFecha.equals(""))  &&
                        ((!eHora.equals("")))) {
                    Intent btn_next_fecha = new Intent(SelectDayActivity.this, DatosAutoActivity.class);
                    startActivity(btn_next_fecha);


                }
                else {

                    Toast.makeText(getApplicationContext(), "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v==btn_fecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    eFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            ,dia, mes, ano);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
            datePickerDialog.show();


        }
        if (v==btn_hora){
            final Calendar c = Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    eHora.setText(hourOfDay+":"+minute);

                }
            } ,hora, minutos, false);
            timePickerDialog.show();

        }
    }
}

