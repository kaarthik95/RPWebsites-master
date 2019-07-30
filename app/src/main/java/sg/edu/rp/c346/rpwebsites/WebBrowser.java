package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebBrowser extends AppCompatActivity {

    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        wv1 = findViewById(R.id.web1);
        wv1.setWebViewClient(new WebViewClient());

        Intent intent = getIntent();
        String website = intent.getStringExtra("link");
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.getSettings().setBuiltInZoomControls(true);
        wv1.getSettings().setDisplayZoomControls(true);
        wv1.loadUrl(website);

    }
}
