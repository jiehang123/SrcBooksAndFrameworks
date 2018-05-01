package com.jiehang.autumn.config;

import com.jiehang.autumn.ioc.Component;
import org.dom4j.Document;

import java.util.Map;

public interface ElementLoader {
    void addElement(Document document, Map<String, Component> componmentMap);
}
