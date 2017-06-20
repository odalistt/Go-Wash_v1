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
import android.text.TextUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import info.androidhive.firebase.MODELS.Post;
import info.androidhive.firebase.MODELS.User;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tania on 21/05/2017.
 */

public class VerificacionDatosActivity extends AppCompatActivity  {

    private static final String TAG = "NewPostActivity";
    private static final String REQUIRED = "Required";

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    private EditText mensajeMarca;
    private EditText mensajeModelo;
    private EditText mensajeColor;
    private EditText mensajePlacas;
    private EditText mensajeUbicacion;
    private EditText mensajeFecha;
    private EditText mensajeHora;
    private EditText mensajeServicios;









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


    /**DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("<id_usuario>");
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
    DatabaseReference mensajeRefServicio = ref.child("Servicio"); */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/**
 // [START initialize_database_ref]
 mDatabase = FirebaseDatabase.getInstance().getReference();
 // [END initialize_database_ref]



 mensajeMarca = (EditText)findViewById(R.id.et_marca);

 mensajeModelo = (EditText)findViewById(R.id.et_modelo);

 mensajeColor = (EditText)findViewById(R.id.et_color);

 mensajePlacas = (EditText)findViewById(R.id.et_placas);

 mensajeFecha = (EditText)findViewById(R.id.eFecha);
 mensajeHora = (EditText)findViewById(R.id.eHora);


 mensajeServicios = (EditText) findViewById(R.id.editText_precio_servicio);
 selected_option = getIntent().getStringExtra("SELECTED_ITEM");
 mensajeServicios.setText(selected_option);



 mensajeUbicacion = (EditText) findViewById(R.id.editText_mi_ubicacion);
 fullAddress = getIntent().getStringExtra("KEY1");
 mensajeUbicacion.setText(fullAddress);
 btn_fecha.setOnClickListener(this);
 btn_hora.setOnClickListener(this);


 /**
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
 */



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
    }
}