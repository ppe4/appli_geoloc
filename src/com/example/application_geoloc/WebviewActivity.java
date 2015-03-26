package com.example.application_geoloc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebviewActivity extends Activity {

	/** onCreate() est appelée au démarrage de l'activité. */
    @SuppressLint("SetJavaScriptEnabled") @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final WebView webview = new WebView(this);
        setContentView(webview);


        webview.getSettings().setJavaScriptEnabled(true);
        final Activity activity = this;
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Les activités et les WebViews mesurent différemment la progression.
                // La barre disparaît lorsque la progression atteint 100%
                Toast.makeText(activity, Integer.toString(progress) + "%", Toast.LENGTH_SHORT).show();
              }
            });
        webview.setWebViewClient(new WebViewClient() {
          public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(activity, "Erreur! " + description, Toast.LENGTH_SHORT).show();
          }
          
          
          
          public void onPageFinished(WebView view, String url)  
             {  
                 Toast.makeText(activity, url, Toast.LENGTH_SHORT).show();
             }
        });
         webview.loadUrl("http://gmaps-samples.googlecode.com/svn/trunk/articles-android-webmap/simple-android-map.html");
          
   }
}
