package com.blend.annotation.butterknife.anno.handler;

import java.util.List;
import java.util.Map;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.VariableElement;

public interface AnnotationHandler {

    /**关联ProcessingEnvironment
     * @param processingEnv
     */
    void attachProcessingEnv(ProcessingEnvironment processingEnv);

    /**
     * 处理注解，将结果存储到Map中
     * @param roundEnv
     * @return
     */
    Map<String, List<VariableElement>> handleAnnotation(RoundEnvironment roundEnv);
}
