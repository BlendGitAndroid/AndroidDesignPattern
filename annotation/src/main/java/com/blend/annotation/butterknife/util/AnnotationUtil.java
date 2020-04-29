package com.blend.annotation.butterknife.util;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;

public class AnnotationUtil {
    /**
     * @param processingEnv
     * @param element
     * @return
     */
    public static String getPackageName(ProcessingEnvironment processingEnv, Element element) {
        return processingEnv.getElementUtils().getPackageOf(element).getQualifiedName().toString();
    }
}
