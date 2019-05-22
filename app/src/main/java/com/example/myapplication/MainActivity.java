package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements T {
    boolean inited = true;             //语句2
    private int s = 10;
    private WebView webView;
    private TextView textView;
    private Handler handler;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        init(savedInstanceState);
        //a-->js
        operate(savedInstanceState);
        //js--->a
        operate2(savedInstanceState);
    }

    private void operate2(Bundle savedInstanceState) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                webView.loadUrl("javascript:if(window.remote){window.remote('" + str + "')}");//传递字符串，如果用""号加转义符,window.remote(\"")
            }
        });
    }

    @SuppressLint("JavascriptInterface")
    private void operate(Bundle savedInstanceState) {
        webView.getSettings().setJavaScriptEnabled(true);//
        webView.addJavascriptInterface(new Dd(this), "haha");
        /*
        用户在登录后获取了token值并保存在本地，应用内WebView加载网页时，前端处理token先读取header的该字段，
        再存到LocalStrorage里，也就是要求客户端在loadUrl的时候，要把token先放到header里，传递给web做登录校验。
         */
        /*Map<String, String> extraHeaders = new HashMap<>();
        extraHeaders.put("", "");
        webView.loadUrl("file:///android_asset/h.html",extraHeaders);*/
        /* byte[] k={1,2};
        webView.postUrl("file:///android_asset/h.html", k);*/
        webView.loadUrl("file:///android_asset/h.html");
    }

    private void init(Bundle savedInstanceState) {

        //js--->android
        webView = findViewById(R.id.webview);
        textView = findViewById(R.id.textview);
        handler = new Handler();

        //android--->js
        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);
    }

    @Override
    public void setTextWebview(final String s) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(s);
            }
        });

    }


 /*try {
            File file = new File(Environment.getExternalStorageDirectory().getPath());
            if (!file.exists())
//            file.createNewFile();
                file.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //new LinkedList<>().getLast();
        //        pattern
        //                FilenameFilter File file
        //        ooo(Math.ceil());
        //        Collection
        //        synchronized ()

        //        isPrime(10);
        //        isPrime2(128);//2 4 16 8 64 32
        //线程1:
        //        Context context = MainActivity.this;   //语句1
        //        j(inited);


    }

    private void ooo(int s) {

    }


   *//* @Override
    protected void onResume() {
        super.onResume();
        if (inited) {
            startActivity(new Intent(this, SecondActivity.class));
            inited = false;
            //            synchronized (){}
            //            Lock
        }
        *//**//*for (int i = 0; i < 500000; i++) {
            doSomethingwithconfig();
        }*//**//*
     *//**//* //线程2:
            while (inited) {
                //            try {
                //                Thread.sleep(1000);
                doSomethingwithconfig();
                //            } catch (InterruptedException e) {
                //                e.printStackTrace();
                //            }
            }*//**//*
    }*//*

    private void doSomethingwithconfig() {
        Log.d("test", "test!");
    }

    public void isPrime(int n) {
        if (n < 3 && n > 1) {
            //一定是
            Log.d("test", "一定是");
        }
        //假如n是合数，必然存在非1的两个约数p1和p2，其中p1<=sqrt(n)，p2>=sqrt(n)。由此我们可以改进上述方法优化循环次数
        int sqrt = (int) Math.sqrt(n);//此处sqrt值是强转为int，会丢失精度 5 2
        for (int i = 2; i <= sqrt;//2
             i++) {
            if (n % i == 0) {
                //一定不是
                Log.d("test", "一定不是");
            }
        }
    }

    public void isPrime2(int sqrt) {
        if (sqrt < 3 && sqrt > 1) {
            //一定是
            Log.d("test", "一定是");
        }
        for (int i = 2; i < sqrt;
             i++) {
            if (sqrt % i == 0) {
                //一定不是
                Log.d("test", "一定不是");
            }
        }
    }

    public void click(View view) {
    }*/
}
