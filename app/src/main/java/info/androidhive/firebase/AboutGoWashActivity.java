package info.androidhive.firebase;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by Tania on 27/05/2017.
 */

public class AboutGoWashActivity extends AppCompatActivity {
    private WebView webView;
    Button btn_salir;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_go_wash);

        String  url = "https://odalistt.github.io/Proyecto/";

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);


    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_salir = (Button)findViewById(R.id.btn_salir);

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent btn_salir = new Intent(AboutGoWashActivity.this, MainActivity.class);
                startActivity(btn_salir);
            }
        });
    }


}

