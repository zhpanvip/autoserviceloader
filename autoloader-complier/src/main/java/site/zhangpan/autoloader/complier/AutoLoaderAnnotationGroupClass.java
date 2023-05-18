package site.zhangpan.autoloader.complier;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/18 09:54
 * @Email: pan.zhang@xjsd.com
 */
public class AutoLoaderAnnotationGroupClass {
    private Set<AutoLoaderAnnotationClass> itemsList = new HashSet<>();
    private String className;

    public AutoLoaderAnnotationGroupClass(String className) {
        this.className = className;
    }

    public void addAnnotationClass(AutoLoaderAnnotationClass autoLoaderAnnotationClass) {
        itemsList.add(autoLoaderAnnotationClass);
    }
}
