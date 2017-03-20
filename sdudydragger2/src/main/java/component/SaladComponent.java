package component;

import javax.inject.Singleton;

import bean.Apple;
import bean.Banana;
import bean.Knife;
import bean.Orange;
import bean.Pear;
import bean.Salad;
import bean.SaladSauce;
import dagger.Component;
import inteface.Type;
import module.SaladModule;

/**
 * @author Holly
 * @time 2017/3/20  12:08
 * @desc ${TODD}
 */
@Singleton //注意是在接口上添加，注意位置
@Component(modules = {SaladModule.class})//指明要在那些Module里寻找依赖
public interface SaladComponent {
    //注意：下面这三个方法，返回值必须是从上面指定的依赖库SaladModule.class中取得的对象
    //注意：而方法名不一致也行，但是方便阅读，建议一致，因为它主要是根据返回值类型来找依赖的
    //★注意：下面这三个方法也可以不写，但是如果要写，就按照这个格式来
    //但是当Component要被别的Component依赖时，
    //这里就必须写这个方法，不写代表不向别的Component暴露此依赖

    Pear providePear();

    Banana provideBanana();

    SaladSauce provideSaladSauce();
    //Salad的依赖Orange，而Orange又依赖了Knife，所以要把两者都引入
    //Orange provideOragne(Knife knife);//★注意：这里千万不能带参数，否则报错

    Orange provideOragne();
    Knife provideKnife();

    /*不同参数构造器的使用*/
    @Type("normal")//关键靠这个限定符来区分调用哪个构造函数
    Apple provideNormalApple();//这个方法名并不重要，只要是provide开头就行，但是建议和module里一致

    @Type("color")
    Apple provideColorApple();


    String provideString();


    //注意：下面的这个方法，表示要将以上的三个依赖注入到某个类中
    //这里我们把上面的三个依赖注入到Salad中
    //因为我们要做沙拉
    void inject(Salad salad);

}