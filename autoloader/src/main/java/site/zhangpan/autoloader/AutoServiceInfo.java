package site.zhangpan.autoloader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/17 14:42
 * @Email: zhpanvip@outlook.com
 */
public class AutoServiceInfo {

    public static Map<String, String> map = new HashMap<>();

    static {
        map.put("site.zhangpan.demo.autoloader.test.ITest", "site.zhangpan.demo.autoloader.generate.TestManager");
        map.put("site.zhangpan.demo.autoloader.strategy.IStrategy", "site.zhangpan.demo.autoloader.generate.StrategyManager");
    }
}
