package site.zhangpan.demo.autoloader.stratety

import android.util.Log
import site.zhangpan.autoloader.annotation.AutoLoader

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/4/23 14:54
 * @Email: zhpanvip@outlook.com
 */
@AutoLoader(IStrategy::class)
class StrategyThree : IStrategy {
    override fun canLoad(): Boolean {
        return true
    }

    override fun loadData(list: MutableList<String>) {
        Log.d("MainActivity", "Load Third Strategy Data")
    }
}