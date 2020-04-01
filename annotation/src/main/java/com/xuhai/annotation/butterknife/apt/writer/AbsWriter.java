package com.xuhai.annotation.butterknife.apt.writer;

import com.xuhai.annotation.butterknife.util.AnnotationUtil;
import com.xuhai.annotation.butterknife.util.IOUtil;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;

public abstract class AbsWriter implements AdapterWriter {
    public static final String SUFFIX = "$InjectAdapter";

    ProcessingEnvironment mProcessingEnv;
    Filer mFiler;

    public AbsWriter(ProcessingEnvironment processingEnv) {
        mProcessingEnv = processingEnv;
        mFiler = processingEnv.getFiler();
    }

    @Override
    public void generate(Map<String, List<VariableElement>> typeMap) {
        Iterator<Map.Entry<String, List<VariableElement>>> iterator = typeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<VariableElement>> entry = iterator.next();
            List<VariableElement> cacheElements = entry.getValue();
            if (cacheElements == null || cacheElements.size() == 0) {
                continue;
            }

            // 取第一个元素来构造注入信息
            InjectorInfo info = createInjectorInfo(cacheElements.get(0));
            Writer writer = null;
            JavaFileObject javaFileObject;
            try {
                //1.创建源文件，也就是生成辅助类
                javaFileObject = mFiler.createSourceFile(info.getClassFullPath());
                writer = javaFileObject.openWriter();
                // 2.写入package, import, class以及findViews函数等代码段
                generateImport(writer, info);
                // 3.写入该类中的所有字段到findViews方法中
                for (VariableElement variableElement : entry.getValue()) {
                    writeField(writer, variableElement, info);
                }
                // 4.写入findViews函数的大括号以及类的大括号
                writeEnd(writer);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtil.closeQuitly(writer);
            }

        }
    }

    /**
     * @param element
     * @return
     */
    protected InjectorInfo createInjectorInfo(VariableElement element) {
        TypeElement typeElement = (TypeElement) element.getEnclosingElement();
        String packageName = AnnotationUtil.getPackageName(mProcessingEnv, typeElement);
        String className = typeElement.getSimpleName().toString();
        return new InjectorInfo(packageName, className);
    }

    /**
     * @param writer
     * @param info
     * @throws IOException
     */
    protected abstract void generateImport(Writer writer, InjectorInfo info)
            throws IOException;

    /**
     * @param writer
     * @param element
     * @param info
     * @throws IOException
     */
    protected abstract void writeField(Writer writer, VariableElement element, InjectorInfo info)
            throws IOException;

    /**
     * @param writer
     * @throws IOException
     */
    protected abstract void writeEnd(Writer writer) throws IOException;

    /**
     * 注解相关的信息实体类
     *
     * @author mrsimple
     */
    public static class InjectorInfo {
        /**
         * 被注解的类的包名
         */
        public String packageName;
        /**
         * 被注解的类的类名
         */
        public String classlName;
        /**
         * 要创建的InjectAdapter类的完整路径,新类的名字为被注解的类名 + "$InjectAdapter", 与被注解的类在同一个包下
         */
        public String newClassName;

        public InjectorInfo(String packageName, String classlName) {
            this.packageName = packageName;
            newClassName = classlName + SUFFIX;
            this.classlName = classlName;
        }

        public String getClassFullPath() {
            return packageName + File.separator + newClassName;
        }
    }

}
