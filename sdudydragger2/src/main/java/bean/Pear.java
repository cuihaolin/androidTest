package bean;

import android.util.Log;

import javax.inject.Inject;

import app.MyApp;

/**
 * @author Holly
 * @time 2017/3/20  12:01
 * @desc ${TODD}
 */
public class Pear {
    @Inject
    Knife knife;

    public Pear() {
        Log.e("TAG", "我是一个梨");
        MyApp.getKnifeComponent().inject(this);

        Log.e("knife", "梨里的knife内存地址：" + knife.toString());
    }
}
