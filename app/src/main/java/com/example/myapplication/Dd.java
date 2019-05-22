package com.example.myapplication;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * @author administrator
 * @version $Rev$
 * @time 2019/5/2117:27
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateTime $Date$
 * @updateDes $TODO$
 */
public class Dd {


    private T t;

    public Dd(T t) {
        this.t = t;
    }

    //这个方法不在主线程
    @JavascriptInterface
    public void setValue(String  s) {
        Log.d("test",s);
        t.setTextWebview(s);
//    return 45;
    }
}
