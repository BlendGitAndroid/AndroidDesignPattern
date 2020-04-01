package com.xuhai.annotation.butterknife.apt;

import com.xuhai.annotation.butterknife.anno.handler.AnnotationHandler;
import com.xuhai.annotation.butterknife.anno.handler.ViewInjectHandler;
import com.xuhai.annotation.butterknife.apt.writer.AdapterWriter;
import com.xuhai.annotation.butterknife.apt.writer.DefaultJavaFileWriter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

import static javax.tools.Diagnostic.Kind.ERROR;

@SupportedAnnotationTypes("org.simple.injector.anno.*")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class ViewInjectorProcessor extends AbstractProcessor {
    /**
     * 所有注解处理器的列表
     */
    List<AnnotationHandler> mHandlers = new LinkedList<AnnotationHandler>();
    /**
     * 类型与字段的关联表,用于在写入Java文件时按类型来写不同的文件和字段
     */
    final Map<String, List<VariableElement>> map = new HashMap<String, List<VariableElement>>();
    /**
     *生成辅助类的Writer类
     */
    AdapterWriter mWriter;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        //注册注解处理器
        registerHandlers();
        //初始化代码生成器
        mWriter = new DefaultJavaFileWriter(processingEnv);
    }

    /**
     *注册处理器
     */
    private void registerHandlers() {
        mHandlers.add(new ViewInjectHandler());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (AnnotationHandler handler : mHandlers) {
            // 关联ProcessingEnvironment
            handler.attachProcessingEnv(processingEnv);
            // 解析注解相关的信息
            map.putAll(handler.handleAnnotation(roundEnv));
        }
        // 将解析到的数据写入到具体的类型中
        mWriter.generate(map);
        return true;
    }

    /**
     * @param element
     * @param message
     * @param args
     */
    protected void error(Element element, String message, Object... args) {
        if (args.length > 0) {
            message = String.format(message, args);
        }
        processingEnv.getMessager().printMessage(ERROR, message, element);
    }
}
