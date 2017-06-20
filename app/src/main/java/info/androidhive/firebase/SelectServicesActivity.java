package info.androidhive.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Tania on 29/04/2017.
 */

public class SelectServicesActivity extends AppCompatActivity {
    Button btn_seleccion;
    RadioGroup radioGroup;
    TextView tvServicio1, tvServicio2, tvServicio3;
    RadioButton rb1, rb2, rb3;
    String fullAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        radioGroup = (RadioGroup) findViewById(R.id.rg_servicios);
        btn_seleccion = (Button) findViewById(R.id.btn_seleccion);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);



        fullAddress = getIntent().getStringExtra("KEY");



        btn_seleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int selectedId = radioGroup .getCheckedRadioButtonId();

                if (selectedId == -1)
                {
                    // no radio buttons are checked
                    Toast.makeText(getApplicationContext(), "Por favor, selecciona una opción", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    // one of the radio buttons is checked

                    Intent intent = new Intent (v.getContext(), SelectDayActivity.class);
                    intent.putExtra("SELECTED_ITEM", selectedId);
                    startActivityForResult(intent, 0);


                } */

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) radioGroup.findViewById(selectedId);

                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Por favor, selecciona una opción", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(SelectServicesActivity.this, "servicio " + rb.getText().toString(), Toast.LENGTH_LONG).show();

                //RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String selected_option = rb.getText().toString().trim();
                Intent intent = new Intent (SelectServicesActivity.this, NewPostActivity.class);
                intent.putExtra("SELECTED_ITEM", selected_option);
                //String fullAddressD = getIntent().getStringExtra("KEY1");
                //intent.putExtra("KEY", fullAddressD);
                
                intent.putExtra("KEY1", fullAddress);
                startActivityForResult(intent, 0);

                //intent.putExtra("LOCATION_KEY", fullAddress);

                /*int selectedId = radioGroup .getCheckedRadioButtonId();
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(), "Por favor, selecciona una opción", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String selected_option = radioButton.getText().toString().trim();
                Intent intent = new Intent (SelectServicesActivity.this , SelectDayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("SELECTED_ITEM", selected_option);
                intent.putExtra("SELECTED_BUNDLE", bundle);
                startActivityForResult(intent, 0); */



                 }

            
        });


         }



}



