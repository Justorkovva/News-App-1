package justor.newsapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;


public class Web extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        Intent myIntent=getIntent();
        String htmlContent=myIntent.getStringExtra("htmlContent");
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadData(htmlContent, "text/html; charset=UTF-8", null);

}}
