package com.jiehang.autumn.ioc;

import com.jiehang.autumn.config.*;
import org.dom4j.Document;

import java.net.URL;
import java.util.Map;

public class ConfigManager {

    private String filePathStr;
    private DocumentHolder documentHolder = new DocumentHolder();
    private ElementLoader elementLoader = new ElementLoaderImpl();

    public ConfigManager(String filePathStr) {
        this.filePathStr = filePathStr;
    }

    public void getXmlConfig(Map<String, Component> componmentMap) {
        URL classPathUrl = ConfigManager.class.getClassLoader().getResource(filePathStr);
        Document document = documentHolder.getDocument(classPathUrl.getPath());
        elementLoader.addElement(document, componmentMap);
    }
}
