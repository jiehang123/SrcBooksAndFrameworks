package com.jiehang.autumn.config;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.File;

public class DocumentHolder {
    public Document getDocument(String filePath) {
        Document doc =null;
        try {
            SAXReader reader = new SAXReader();
            doc = reader.read(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

}
