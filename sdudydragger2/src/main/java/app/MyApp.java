package app;

import android.app.Application;

import component.DaggerKnifeComponent;
import component.KnifeComponent;
import module.KnifeMofule;

/**
 * @author Holly
 * @time 2017/3/20  15:20
 * @desc ${TODD}
 */
public class MyApp extends Application {
    //这里不一定非得使用static，由于我注入的不是Activity，无法用getApplication来得到MyApp的对象（否则还得传入一个Activity），所以为了方便，使用了静态。
    private static KnifeComponent knifeComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        //        为了实现局部共享一个实例，
        //        我们需要在Application里，首先得到knifeComponent的实例
        //        由于Application的onCreate方法，在应用程序里面，只运行一次
        //        所以只得到了一个knifeComponent
        //       （后面我们通过getKnifeComponent来得到这唯一的一个getKnifeComponent）
        //        ok，我们之后会通过这个唯一的KnifeComponent来得到他所连接的KnifeModule
        //        所提供的Knife的实例，再把这个实例注入到苹果、梨里面去，从而实现了苹果、梨
        //        会共享这个实例。
        //        而香蕉里的Knife，我们要重新建立一个Module和Component来获取Knife的新实例
        //        这样就实现了Knife的实例，在苹果、梨之间局部共享，而香蕉使用的是另外一个实例
        knifeComponent = DaggerKnifeComponent
                .builder()
                .knifeMofule(new KnifeMofule())
                .build();
    }

    public  static  KnifeComponent getKnifeComponent() {
        return knifeComponent;
    }
}