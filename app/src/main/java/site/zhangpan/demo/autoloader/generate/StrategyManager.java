package site.zhangpan.demo.autoloader.generate;

import java.util.ArrayList;

import site.zhangpan.autoloader.IAutoLoadManager;
import site.zhangpan.demo.autoloader.stratety.StrategyOne;
import site.zhangpan.demo.autoloader.stratety.StrategyTwo;
import site.zhangpan.demo.autoloader.stratety.StrategyThree;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/17 14:10
 * @Email: zhpanvip@outlook.com
 */
public class StrategyManager implements IAutoLoadManager {
    public ArrayList<?> load() {
        ArrayList<Object> iStrategies = new ArrayList<>();
        iStrategies.add(new StrategyOne());
        iStrategies.add(new StrategyTwo());
        iStrategies.add(new StrategyThree());
        return iStrategies;
    }
}
