package site.zhangpan.demo.autoloader.test;

import android.util.Log;

import site.zhangpan.autoloader.annotation.AutoLoader;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/17 14:36
 * @Email: zhpanvip@outlook.com
 */
@AutoLoader(ITest.class)
public class TestThree implements ITest{
    @Override
    public void test() {
        Log.d("MainActivity",getClass().getCanonicalName());
    }
}
