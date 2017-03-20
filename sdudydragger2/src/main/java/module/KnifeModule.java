package module;

/**
 * @author Holly
 * @time 2017/3/20  15:18
 * @desc ${TODD}
 */

import bean.Knife;
import dagger.Module;
import dagger.Provides;
import inteface.KnifeScope;

/**
 * 在Module里使用 @KnifeScope，
 * 指定目前这个Module的使用范围
 */
@Module
public class KnifeModule {
//在Module中是创建一个对象的地方.
    @KnifeScope
    @Provides
    public Knife provideKnife(){
        Knife knife = new Knife();
        return knife;
    }
}