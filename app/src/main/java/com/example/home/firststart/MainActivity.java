package com.example.home.firststart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public abstract class MainActivity extends AppCompatActivity implements OnClickListener {

    private WebView webView; //声明WebView组件的对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=(WebView) findViewById(R.id.webveiw);//获取webview组件
        webView.getSettings().setJavaScriptEnabled(true);//设置javascript可用
        webView.setWebChromeClient(new WebChromeClient());//处理javascript对话框
        webView.setWebViewClient(new WebViewClient());//处理各种通知和请求事件，如果不使用该句代码，将使用内置浏览器访问页面
        webView.loadUrl("http://m.weather.com.cn/m/pn12/weather.htm");//设置默认显示的天气预报信息

        webView.setInitialScale(57*4);//放网页内容放大4倍
        Button bj=(Button) findViewById(R.id.bj);//获取布局管理器中添加的“北京”按钮
        bj.setOnClickListener(this);

        Button sh=(Button) findViewById(R.id.sh);
        sh.setOnClickListener(this);

        Button gz=(Button) findViewById(R.id.sh);
        gz.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bj://单击的是北京的按钮
                openUrl("101010100T");
                break;
            case R.id.sh:
                openUrl("101020100T");
                break;
            case R.id.gz:
                openUrl("101280101T");

        }
    }

    //打开网页的方法
    private void openUrl(String s) {
        webView.loadUrl(";+id+");//获取并显示天气预报信息
    }


}
