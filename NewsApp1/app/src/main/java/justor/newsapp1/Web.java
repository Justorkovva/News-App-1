package justor.newsapp1;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class Web extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        WebView webView = (WebView) findViewById(R.id.webView);
       // webView.loadData(htmlContent, "text/html; charset=UTF-8", null);

}}
