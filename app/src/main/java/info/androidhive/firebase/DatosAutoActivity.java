package info.androidhive.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.HashMap;


/**
 * Created by Tania on 30/04/2017.
 */

public class DatosAutoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {




    String selected_option1;
    String selected_option;
    String fullAddress;
    private Spinner sp_marca, sp_modelo, sp_colores;





    private TextView tvMarca, tvModelo, tvColor, tvPlacas;
    private EditText et_marca, et_modelo, et_color, et_placas;
    private Button btn_enviarDatos;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensajeRef = ref.child("Datos-Auto");
    DatabaseReference mensajeRefMarca = ref.child("Marca");
    DatabaseReference mensajeRefModelo = ref.child("Modelo");
    DatabaseReference mensajeRefColor = ref.child("Color");
    DatabaseReference mensajeRefPlacas = ref.child("Placas");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_auto);


        sp_marca = (Spinner)findViewById(R.id.sp_marca);
        sp_modelo = (Spinner)findViewById(R.id.sp_modelo);
        sp_colores = (Spinner)findViewById(R.id.sp_colores);

        //HashMap<String, String> datos = new HashMap<>();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.array_marcas,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_marca.setAdapter(adapter);
        sp_marca.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(
                this,
                R.array.array_colores,
                android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_colores.setAdapter(adapterColor);
        sp_colores.setOnItemSelectedListener(this);

        String selected_option = getIntent().getStringExtra("SELECTED_ITEM");
        //String fullAddress = getIntent().getStringExtra("LOCATION_KEY);
}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        int[] marcas = {R.array.array_chevrolet, R.array.array_ford, R.array.array_honda,
                R.array.array_nissan,R.array.array_renault, R.array.array_toyota,
                R.array.array_volkswagen};

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                marcas[position],
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_modelo.setAdapter(adapter);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    @Override
    protected void onStart() {
        super.onStart();

        mensajeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
        }

    @Override
    protected void onResume() {
        super.onResume();
        btn_enviarDatos = (Button)findViewById(R.id.btn_enviarDatos);
        //String selected_option = getIntent().getStringExtra("SELECTED_ITEM");

        btn_enviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent siguiente = new Intent(DatosAutoActivity.this, VerificacionDatosActivity.class);
                siguiente.putExtra("SELECTED_ITEM1", selected_option);
                //siguiente.putExtra("LOCATION_KEY1", fullAddress);
                startActivityForResult(siguiente, 0);

                //Bundle placaCarro = new Bundle();
                //placaCarro.putString("nombrePlaca", mensajeRefPlacas);
                //siguiente.putExtras(placaCarro);



            }
        });
    }


}


