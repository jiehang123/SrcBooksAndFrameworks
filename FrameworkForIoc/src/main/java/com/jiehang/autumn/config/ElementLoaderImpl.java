package com.jiehang.autumn.config;

import com.jiehang.autumn.ioc.Component;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.*;

public class ElementLoaderImpl implements ElementLoader {

    @Override
    public void addElement(Document document, Map<String, Component> componmentMap) {
        List<Element> list = document.getRootElement().elements();

        if (list != null) {
            for (Element element : list) {
                String name = element.attributeValue("name");
                String classStr = element.attributeValue("class");
                List<String> refList = new ArrayList<>();
                List<Element>  refElements = element.elements();
                for (Element refElement : refElements) {
                    getElementNames(refElement, refList);
                }
                componmentMap.put(name, new Component(classStr, refList));
            }

            /*for (String key : componmentMap.keySet()) {
                System.out.println(key + ": " + componmentMap.get(key).toString());
            }*/
        }
    }

    private void getElementNames(Element refElement, List<String> refList) {
        refList.add(refElement.attributeValue("name"));
    }
}
