package info.androidhive.firebase;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Tania on 21/05/2017.
 */

public class VerificacionDatosActivity extends AppCompatActivity implements View.OnClickListener {






    Button btn_fecha, btn_hora, btn_next_fecha;
    EditText eFecha, eHora, editText_precio_servicio, editText_mi_ubicacion;
    private int dia, mes, ano, hora, minutos;

    Bundle bundle;

    Button button_solicitar_servicio_final;
    TextView textView_tipo_servicio, textView_Carro, textView_ubicacion;
    String fullAddress;
    String selected_option;


    private TextView tvMarca, tvModelo, tvColor, tvPlacas;
    private EditText et_marca, et_modelo, et_color, et_placas;
    private Button btn_enviarDatos;
    private String FIREBASE_URL = "https://washme-cc7cf.firebaseio.com/";
    private String FIREBASE_CHILD = "test";


    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("<id_usuario>");
    //DatabaseReference usuariosRef = ref.child("usuarios");

    //FirebaseAuth.getInstance().getCurrentUser();
    //FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference mensajeRef = ref.child("Datos-Auto");
    DatabaseReference mensajeRefMarca = ref.child("Marca");
    DatabaseReference mensajeRefModelo = ref.child("Modelo");
    DatabaseReference mensajeRefColor = ref.child("Color");
    DatabaseReference mensajeRefPlacas = ref.child("Placas");
    DatabaseReference mensajeRefUbicacion = ref.child("Ubicacion");
    DatabaseReference mensajeRefFecha = ref.child("Fecha");
    DatabaseReference mensajeRefHora = ref.child("Hora");
    DatabaseReference mensajeRefServicio = ref.child("Servicio");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_datos);
        

        tvMarca = (TextView)findViewById(R.id.tvMarca);
        et_marca = (EditText)findViewById(R.id.et_marca);
        tvModelo = (TextView)findViewById(R.id.tvModelo);
        et_modelo = (EditText)findViewById(R.id.et_modelo);
        tvColor = (TextView)findViewById(R.id.tvColor);
        et_color = (EditText)findViewById(R.id.et_color);
        tvPlacas = (TextView)findViewById(R.id.tvPlacas);
        et_placas = (EditText)findViewById(R.id.et_placas);



        btn_fecha = (Button)findViewById(R.id.btn_fecha);
        btn_hora = (Button)findViewById(R.id.btn_hora);
        btn_next_fecha = (Button)findViewById(R.id.btn_next_fecha);
        eFecha = (EditText)findViewById(R.id.eFecha);
        eHora = (EditText)findViewById(R.id.eHora);
        btn_fecha.setOnClickListener(this);
        btn_hora.setOnClickListener(this);



        editText_precio_servicio = (EditText) findViewById(R.id.editText_precio_servicio);
        selected_option = getIntent().getStringExtra("SELECTED_ITEM");
        editText_precio_servicio.setText(selected_option);
        textView_tipo_servicio = (TextView) findViewById(R.id.textView_tipo_servicio);

        editText_mi_ubicacion = (EditText) findViewById(R.id.editText_mi_ubicacion);
        //String fullAddressD = getIntent().getStringExtra("KEY");
        //editText_mi_ubicacion.setText(fullAddressD);
        //fullAddress = getIntent().getStringExtra("KEY1");

        fullAddress = getIntent().getStringExtra("KEY1");
        editText_mi_ubicacion.setText(fullAddress);
        System.out.println(fullAddress);
        //String selected_option = getIntent().getStringExtra("SELECTED_ITEM1");
        //textView_tipo_servicio.setText(selected_option);

        //System.out.println(selected_option);

        /* Bundle bundle = getIntent().getBundleExtra("SELECTED_BUNDLE");
        String value = bundle.getString("SELECTED_ITEM");
        Log.e("TAG", "_log : value : " + value); // should print your option
        textView_tipo_servicio.setText(value); */


        //Bundle=getIntent().getExtras();
        //DatosAutoActivity.Carro data = (DatosAutoActivity.Carro) getIntent().getExtras().getSerializable("SPINNERVAL");





        button_solicitar_servicio_final = (Button) findViewById(R.id.button_solicitar_servicio_final);

        //textView_Carro = (TextView) findViewById(R.id.textView_Carro);

        //Bundle bundle = getIntent().getExtras();
        //String fullAddress = bundle.getString("LocationKey");
        //fullAddress = bundle.getString("LocationKey");
        //textView_ubicacion.setText(fullAddress);
        textView_ubicacion = (TextView) findViewById(R.id.textView_ubicacion);
       // textView_ubicacion.setText(fullAddress);


    }

    @Override
    protected void onStart() {
        super.onStart();

        mensajeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                //et_marca.setText(dataSnapshot.child("Marca").getValue().toString());
                //et_modelo.setText(dataSnapshot.child("Modelo").getValue().toString());
                //et_color.setText(dataSnapshot.child("Color").getValue().toString());
                //et_placas.setText(dataSnapshot.child("Placas").getValue().toString());

                tvMarca.setText(value);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }




    @Override
    protected void onResume() {
        super.onResume();
        //btn_next_fecha = (Button)findViewById(R.id.btn_next_fecha);
        button_solicitar_servicio_final = (Button) findViewById(R.id.button_solicitar_servicio_final);

            button_solicitar_servicio_final.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String mensajeMarca = et_marca.getText().toString();
                    mensajeRefMarca.setValue(mensajeMarca);
                    //usuariosRef.child("marca").setValue(mensajeMarca);
                    String mensajeModelo = et_modelo.getText().toString();
                    mensajeRefModelo.setValue(mensajeModelo);
                    String mensajeColor = et_color.getText().toString();
                    mensajeRefColor.setValue(mensajeColor);
                    String mensajePlacas = et_placas.getText().toString();
                    mensajeRefPlacas.setValue(mensajePlacas);
                    String mensajeUbicacion = editText_mi_ubicacion.getText().toString();
                    mensajeRefUbicacion.setValue(mensajeUbicacion);
                    String mensajeFecha = eFecha.getText().toString();
                    mensajeRefFecha.setValue(mensajeFecha);
                    String mensajeHora = eHora.getText().toString();
                    mensajeRefHora.setValue(mensajeHora);
                    //mensajeRefHora.push().setValue(mensajeHora);
                    String mensajeServicios = editText_precio_servicio.getText().toString();
                    mensajeRefServicio.setValue(mensajeServicios);

                    if ((!mensajeMarca.matches(""))&& (!mensajeModelo.matches("")) && ((!mensajeColor.matches("")) &&
                            ((!mensajePlacas.matches(""))))) {

                        Intent siguiente = new Intent(VerificacionDatosActivity.this, PayPalActivity.class);
                        siguiente.putExtra("SERVICIO", selected_option);
                        startActivity(siguiente);

                        //Intent button_solicitar_servicio_final = new Intent(VerificacionDatosActivity.this, PayPalActivity.class);


                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                    }

                    et_marca.setText("");
                    et_modelo.setText("");
                    et_color.setText("");
                    et_placas.setText("");
                    editText_mi_ubicacion.setText("");
                    eFecha.setText("");
                    eHora.setText("");

                    /*if ((!eFecha.equals(""))  &&
                            ((!eHora.equals("")))) {
                        Intent button_solicitar_servicio_final = new Intent(VerificacionDatosActivity.this, PayPalActivity.class);
                        startActivity(button_solicitar_servicio_final);


                    }
                    else {

                        Toast.makeText(getApplicationContext(), "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                    }*/

                }
            });
        }





            /*button_solicitar_servicio_final.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (v.getContext(), PayPalActivity.class);
                    startActivityForResult(intent, 0); }

            }); */





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


