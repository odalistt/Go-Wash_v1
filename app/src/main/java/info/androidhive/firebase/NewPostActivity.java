package info.androidhive.firebase;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import info.androidhive.firebase.MODELS.User;
import info.androidhive.firebase.MODELS.Post;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class NewPostActivity extends BaseActivity implements View.OnClickListener  {

    private static final String TAG = "NewPostActivity";
    private static final String REQUIRED = "Required";

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]


    private EditText mensajeMarca;
    private EditText mensajeModelo;
    private EditText mensajeColor;
    private EditText mensajePlacas;
    private EditText editText_mi_ubicacion;
    private EditText mensajeFecha;
    private EditText mensajeHora;
    private EditText editText_precio_servicio;
    private Button button_solicitar_servicio_final;

    String fullAddress;
    String selected_option;
    TextView textView_tipo_servicio, textView_ubicacion;
    Button btn_fecha, btn_hora, btn_next_fecha;
    private int dia, mes, ano, hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_datos);

        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]

        btn_fecha = (Button)findViewById(R.id.btn_fecha);
        btn_hora = (Button)findViewById(R.id.btn_hora);
        btn_fecha.setOnClickListener(this);
        btn_hora.setOnClickListener(this);

        mensajeMarca = (EditText)findViewById(R.id.et_marca);
        mensajeModelo = (EditText)findViewById(R.id.et_modelo);
        mensajeColor = (EditText)findViewById(R.id.et_color);
        mensajePlacas = (EditText)findViewById(R.id.et_placas);
        mensajeFecha = (EditText)findViewById(R.id.eFecha);
        mensajeHora = (EditText)findViewById(R.id.eHora);
        editText_precio_servicio = (EditText) findViewById(R.id.editText_precio_servicio);
        selected_option = getIntent().getStringExtra("SELECTED_ITEM");
        editText_precio_servicio.setText(selected_option);
        textView_tipo_servicio = (TextView) findViewById(R.id.textView_tipo_servicio);
        editText_mi_ubicacion = (EditText) findViewById(R.id.editText_mi_ubicacion);
        fullAddress = getIntent().getStringExtra("KEY1");
        editText_mi_ubicacion.setText(fullAddress);
        textView_ubicacion = (TextView) findViewById(R.id.textView_ubicacion);

        button_solicitar_servicio_final = (Button) findViewById(R.id.button_solicitar_servicio_final);

        button_solicitar_servicio_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPost();
                Intent siguiente = new Intent(NewPostActivity.this, PayPalActivity.class);
                siguiente.putExtra("SERVICIO", selected_option);
                startActivity(siguiente);
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
                    mensajeFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
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
                    mensajeHora.setText(hourOfDay+":"+minute);

                }
            } ,hora, minutos, false);
            timePickerDialog.show();

        }
    }

    private void submitPost() {
        final String marca = mensajeMarca.getText().toString();
        final String modelo = mensajeModelo.getText().toString();
        final String color = mensajeColor.getText().toString();
        final String placas = mensajePlacas.getText().toString();
        final String fecha = mensajeFecha.getText().toString();
        final String hora = mensajeHora.getText().toString();
        final String servicio = editText_precio_servicio.getText().toString();
        final String ubicacion = editText_mi_ubicacion.getText().toString();





        // Marca is required
        if (TextUtils.isEmpty(marca)) {
            mensajeMarca.setError(REQUIRED);
            return;
        }
        // Modelo is required
        if (TextUtils.isEmpty(modelo)) {
            mensajeModelo.setError(REQUIRED);
            return;
        }
        // Color is required
        if (TextUtils.isEmpty(color)) {
            mensajeColor.setError(REQUIRED);
            return;
        }
        // Placas is required
        if (TextUtils.isEmpty(placas)) {
            mensajePlacas.setError(REQUIRED);
            return;
        }
        // Fecha is required
        if (TextUtils.isEmpty(fecha)) {
            mensajeFecha.setError(REQUIRED);
            return;
        }
        // Hora is required
        if (TextUtils.isEmpty(hora)) {
            mensajeHora.setError(REQUIRED);
            return;
        }
        // Servicio is required
        if (TextUtils.isEmpty(servicio)) {
            editText_precio_servicio.setError(REQUIRED);
            return;
        }
        // Ubicacion is required
        if (TextUtils.isEmpty(ubicacion)) {
            editText_mi_ubicacion.setError(REQUIRED);
            return;
        }

        // Disable button so there are no multi-posts
        setEditingEnabled(false);
        Toast.makeText(this, "Posting...", Toast.LENGTH_SHORT).show();

        // [START single_value_read]
        final String userId = getUid();
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        User user = dataSnapshot.getValue(User.class);

                        // [START_EXCLUDE]
                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(NewPostActivity.this,
                                    "Error: could not fetch user.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // Write new post
                            writeNewPost(userId, user.username, marca, modelo, color, placas,
                                    servicio, ubicacion, fecha, hora);
                        }

                        // Finish this Activity, back to the stream
                        setEditingEnabled(true);
                        finish();
                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                        // [START_EXCLUDE]
                        setEditingEnabled(true);
                        // [END_EXCLUDE]
                    }
                });
        // [END single_value_read]
    }

    private void setEditingEnabled(boolean enabled) {
        mensajeMarca.setEnabled(enabled);
        mensajeModelo.setEnabled(enabled);
        mensajeColor.setEnabled(enabled);
        mensajePlacas.setEnabled(enabled);
        mensajeFecha.setEnabled(enabled);
        mensajeHora.setEnabled(enabled);
        editText_mi_ubicacion.setEnabled(enabled);
        editText_precio_servicio.setEnabled(enabled);
        if (enabled) {
            button_solicitar_servicio_final.setVisibility(View.VISIBLE);
        } else {
            button_solicitar_servicio_final.setVisibility(View.GONE);
        }
    }

    // [START write_fan_out]
    private void writeNewPost(String userId, String username, String marca,
                              String modelo, String color, String placas, String servicio, String ubicacion,
                              String fecha, String hora) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = mDatabase.child("posts").push().getKey();
        Post post = new Post(userId, username, marca, modelo, color, placas, servicio,
                ubicacion, fecha, hora);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }


    // [END write_fan_out]



}
