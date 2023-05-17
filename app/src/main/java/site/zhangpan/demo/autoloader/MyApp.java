package site.zhangpan.demo.autoloader;

import android.app.Application;

import site.zhangpan.autoloader.AutoServiceLoader;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/17 13:59
 * @Email: zhpanvip@outlook.com
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AutoServiceLoader.getInstance().init();
    }
}
