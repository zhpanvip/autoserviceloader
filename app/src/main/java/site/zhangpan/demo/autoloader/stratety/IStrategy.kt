package site.zhangpan.demo.autoloader.stratety

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/4/23 14:50
 * @Email: zhpanvip@outlook.com
 */
interface IStrategy {
    fun canLoad():Boolean

    fun loadData(list: MutableList<String>)
}