package justor.newsapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        Intent myIntent=getIntent();
        String htmlContent=myIntent.getStringExtra("htmlContent");
        String title=myIntent.getStringExtra("title");
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadData(htmlContent, "text/html; charset=UTF-8", null);
        setTitle(title);
}}