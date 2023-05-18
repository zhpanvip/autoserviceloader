package site.zhangpan.autoloader.complier;

import java.util.Objects;

import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.util.Elements;

import site.zhangpan.autoloader.annotation.AutoLoader;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/17 17:16
 * @Email: zhpanvip@outlook.com
 */
public class AutoLoaderAnnotationClass {

    // AutoLoader 中 value 值的包名
    private  String autoLoaderValuePackageName;
    // AutoLoader 中 value 值的类名
    private  String autoLoaderValueCanonicalName;



    private  String qualifiedName;

    public AutoLoaderAnnotationClass(TypeElement typeElement, Elements elementUtils) {
        AutoLoader autoLoader = typeElement.getAnnotation(AutoLoader.class);
        qualifiedName = typeElement.getQualifiedName().toString();
        try {
            Class<?> value = autoLoader.value();
            autoLoaderValueCanonicalName = value.getCanonicalName();
            autoLoaderValuePackageName = value.getPackage().getName();
        } catch (MirroredTypeException mte) {
            DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
            TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
            autoLoaderValueCanonicalName = classTypeElement.getQualifiedName().toString();
            autoLoaderValuePackageName = elementUtils.getPackageOf(classTypeElement).asType().toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutoLoaderAnnotationClass)) return false;
        AutoLoaderAnnotationClass that = (AutoLoaderAnnotationClass) o;
        return Objects.equals(getAutoLoaderValuePackageName(), that.getAutoLoaderValuePackageName()) && Objects.equals(getAutoLoaderValueCanonicalName(), that.getAutoLoaderValueCanonicalName()) && Objects.equals(qualifiedName, that.qualifiedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAutoLoaderValuePackageName(), getAutoLoaderValueCanonicalName(), qualifiedName);
    }

    public String getAutoLoaderValuePackageName() {
        return autoLoaderValuePackageName;
    }

    public String getAutoLoaderValueCanonicalName() {
        return autoLoaderValueCanonicalName;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }
}
