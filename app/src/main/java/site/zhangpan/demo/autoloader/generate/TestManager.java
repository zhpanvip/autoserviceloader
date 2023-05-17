package site.zhangpan.demo.autoloader.generate;

import java.util.ArrayList;

import site.zhangpan.autoloader.IAutoLoadManager;
import site.zhangpan.demo.autoloader.test.TestOne;
import site.zhangpan.demo.autoloader.test.TestTwo;
import site.zhangpan.demo.autoloader.test.TestThree;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/17 14:35
 * @Email: zhpanvip@outlook.com
 */
public class TestManager implements IAutoLoadManager {
    @Override
    public ArrayList<?> load() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(new TestOne());
        objects.add(new TestTwo());
        objects.add(new TestThree());
        return objects;
    }
}
