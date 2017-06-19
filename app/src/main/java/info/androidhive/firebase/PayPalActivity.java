package info.androidhive.firebase;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Tania on 14/05/2017.
 */

public class PayPalActivity extends AppCompatActivity {

    private WebView webView;
    Button btn_omitir;
    TextView pagoTextView;
    String selected_option;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);



        TextView pagoTextView = (TextView) findViewById(R.id.pagoTextView);
        selected_option = getIntent().getStringExtra("SERVICIO");
        selected_option = getIntent().getStringExtra("SERVICIO");
        pagoTextView.setText("Servicio solicitado: " + selected_option);


        String  url = "https://www.paypal.me/GoWashApp";

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);


    }

   /* public void onClick(View arg0) {
        Intent intent = new Intent(this, PayPalActivity.class);
        startActivity(intent);
    } */


    @Override
    protected void onResume() {
        super.onResume();
        btn_omitir = (Button)findViewById(R.id.btn_omitir);

        btn_omitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn_omitir = new Intent(PayPalActivity.this, ConfirmacionActivity.class);
                startActivity(btn_omitir);
            }
        });
    }


}

