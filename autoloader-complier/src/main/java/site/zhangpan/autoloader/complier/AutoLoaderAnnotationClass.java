package site.zhangpan.autoloader.complier;

import javax.lang.model.element.TypeElement;

import site.zhangpan.autoloader.annotation.AutoLoader;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/17 17:16
 * @Email: zhpanvip@outlook.com
 */
public class AutoLoaderAnnotationClass {

    // AutoLoader 中 value 值的包名
    private final String autoLoaderValuePackageName;
    // AutoLoader 中 value 值的类名
    private final String autoLoaderValueCanonicalName;

    public AutoLoaderAnnotationClass(TypeElement typeElement) {
        AutoLoader autoLoader = typeElement.getAnnotation(AutoLoader.class);
        Class<?> value = autoLoader.value();
        autoLoaderValueCanonicalName = value.getCanonicalName();
        autoLoaderValuePackageName = value.getPackage().getName();
    }

    public String getAutoLoaderValuePackageName() {
        return autoLoaderValuePackageName;
    }

    public String getAutoLoaderValueCanonicalName() {
        return autoLoaderValueCanonicalName;
    }
}
