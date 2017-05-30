package info.androidhive.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tania on 21/05/2017.
 */

public class ConfirmacionActivity extends AppCompatActivity {

    Button button_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        button_ok = (Button) findViewById(R.id.button_ok);

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ConfirmacionActivity.this, MainActivity.class);
                startActivityForResult(intent, 0);
            }
    });
}
}