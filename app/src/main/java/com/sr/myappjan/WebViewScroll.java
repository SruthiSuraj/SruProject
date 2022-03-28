package com.sr.myappjan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewScroll extends AppCompatActivity
{

    WebView webView;
    EditText editText;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_scroll);

        webView = (WebView)findViewById(R.id.webView);
        editText = (EditText)findViewById(R.id.SearchText);
        b = (Button)findViewById(R.id.search);

        webView.setWebViewClient(new WebViewClient());

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String url = editText.getText().toString();
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.loadUrl("https://www."+url+".com");
            }
        });
    }
}