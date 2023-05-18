package site.zhangpan.demo.autoloader.strategy

import android.util.Log
import site.zhangpan.autoloader.annotation.AutoLoader

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/4/23 14:51
 * @Email: zhpanvip@outlook.com
 */
@AutoLoader(IStrategy::class)
class StrategyTwo : IStrategy {
    override fun canLoad(): Boolean {
        return true
    }

    override fun loadData(list: MutableList<String>) {
        Log.d("MainActivity","Load Second Strategy Data")
    }
}