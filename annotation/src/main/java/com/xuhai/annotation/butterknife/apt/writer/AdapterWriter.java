package com.xuhai.annotation.butterknife.apt.writer;

import java.util.List;
import java.util.Map;

import javax.lang.model.element.VariableElement;

public interface AdapterWriter {
    /**
     * @param typeMap
     */
    void generate(Map<String, List<VariableElement>> typeMap);
}
