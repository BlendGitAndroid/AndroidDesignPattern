package com.xuhai.annotation.butterknife.apt.writer;

import com.xuhai.annotation.butterknife.anno.ViewInjector;

import java.io.IOException;
import java.io.Writer;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.VariableElement;

public class DefaultJavaFileWriter extends AbsWriter {
    public DefaultJavaFileWriter(ProcessingEnvironment processingEnv) {
        super(processingEnv);
    }

    /*
     * 写入import以及类前面的类型声明
     * @see
     * org.simple.injector.apt.writer.AbsWriter#generateImport(java.io.Writer,
     * org.simple.injector.apt.ViewInjectorProcessor.InjectorInfo)
     */
    @Override
    protected void generateImport(Writer writer, InjectorInfo info) throws IOException {
        writer.write("package " + info.packageName + " ;");
        writer.write("\n\n");
        writer.write("import com.xuhai.annotation.butterknife.adapter.InjectAdapter;");
        writer.write("\n");
        writer.write("import org.simple.injector.util.ViewFinder;");

        writer.write("\n\n\n");
        writer.write("/* This class is generated by Simple ViewInjector, please don't modify! */ ");
        writer.write("\n");
        writer.write("public class " + info.newClassName
                + " implements InjectAdapter<" + info.classlName + "> { ");
        writer.write("\n");
        writer.write("\n");
        // 查找方法
        writer.write("  public void injects(" + info.classlName
                + " target)  { ");
        writer.write("\n");
    }

    /*
     * (non-Javadoc)
     * @see org.simple.injector.apt.writer.AbsWriter#writeEnd(java.io.Writer)
     */
    @Override
    protected void writeEnd(Writer writer) throws IOException {
        writer.write("  }");
        writer.write("\n\n");
        writer.write(" } ");
    }

    /*
     * (non-Javadoc)
     * @see org.simple.injector.apt.writer.AbsWriter#writeField(java.io.Writer,
     * javax.lang.model.element.VariableElement,
     * org.simple.injector.apt.ViewInjectorProcessor.InjectorInfo)
     */
    @Override
    protected void writeField(Writer writer, VariableElement element, InjectorInfo info)
            throws IOException {
        ViewInjector injector = element.getAnnotation(ViewInjector.class);
        String fieldName = element.getSimpleName().toString();
        writer.write("target." + fieldName + " = ViewFinder.findViewById(target, "
                + injector.value() + ");");
        writer.write("\n");
    }
}
