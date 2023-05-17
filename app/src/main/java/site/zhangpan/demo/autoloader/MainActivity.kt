package site.zhangpan.demo.autoloader

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import site.zhangpan.autoloader.AutoServiceLoader
import site.zhangpan.demo.autoloader.stratety.IStrategy
import site.zhangpan.demo.autoloader.test.ITest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayList = ArrayList<String>()
        AutoServiceLoader.load(IStrategy::class.java).forEach {
            if (it.canLoad()) it.loadData(arrayList)
        }
        AutoServiceLoader.load(ITest::class.java).forEach {
            it.test()
        }

        Log.d("MainActivity","packageName:${AutoServiceLoader::class.java.`package`.name}")
    }
}