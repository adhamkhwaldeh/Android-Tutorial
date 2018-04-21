package com.son.jawad.ui_widgets.Activities.UIActivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.son.jawad.ui_widgets.R;

/**
 * Created by Adhamkh on 2017-08-18.
 */
public class WebviewActivity extends AppCompatActivity {
    WebView webView;
    EditText urledittext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        webView = (WebView) findViewById(R.id.webview);
        urledittext = (EditText) findViewById(R.id.urledittext);
    }

    public void onclickbtn(View view) {
        webView.setWebViewClient(new WebViewClient());
        if (urledittext.getText().toString().trim().isEmpty())
            webView.loadUrl("http://www.javatpoint.com/");
        else {
            webView.loadUrl(" https://www.google.com/search?q=" + urledittext.getText().toString());
        }


        /*String data = "<html><body><h1>Hello, Javatpoint!</h1></body></html>";
        mywebview.loadData(data, "text/html", "UTF-8"); */

        //  webView.loadUrl("file:///android_asset/myresource.html");
    }

}
