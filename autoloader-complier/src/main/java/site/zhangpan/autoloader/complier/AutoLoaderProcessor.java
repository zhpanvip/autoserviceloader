package site.zhangpan.autoloader.complier;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import site.zhangpan.autoloader.annotation.AutoLoader;

/**
 * @Description:
 * @Author: zhangpan
 * @Date: 2023/5/17 16:51
 * @Email: zhpanvip@outlook.com
 */
public class AutoLoaderProcessor extends AbstractProcessor {
    private Types typeUtils;
    private Filer filer;
    private Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        Logger.setMessager(processingEnv.getMessager());
        typeUtils = processingEnv.getTypeUtils();
        filer = processingEnv.getFiler();
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        Logger.i("CanonicalName is %s", AutoLoader.class.getCanonicalName());
        annotations.add(AutoLoader.class.getCanonicalName());
        return annotations;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        try {
            for (Element annotatedElement : roundEnvironment.getElementsAnnotatedWith(AutoLoader.class)) {
                // AutoLoader 注解的对象必须是 Class 类型
                if (annotatedElement.getKind() != ElementKind.CLASS) {
                    throw new ProcessingException(annotatedElement, "Only classes can be annotated with @%s", AutoLoader.class.getSimpleName());
                }
                TypeElement typeElement = (TypeElement) annotatedElement;
                AutoLoaderAnnotationClass autoLoaderAnnotationClass = new AutoLoaderAnnotationClass(typeElement);
            }
        } catch (ProcessingException e) {
            Logger.e(e.getElement(), e.getMessage());
        }
        return true;
    }
}
