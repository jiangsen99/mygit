package com.itheima.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 包名:com.itheima.factory
 * 作者:Leevi
 * 日期2020-02-13  10:25
 * 这个类是专门给别人创建对象的
 * 目标1:让getBean方法，可以创建任意类的对象
 *      实现方法:使用反射,根据你要创建对象的类的全限定名来进行反射
 */
public class BeanFactory {
    private static Map<String,Object> beanMap = new HashMap<>();//这个map就是存放id和对象的键值对
    /**
     * 根据使用者传入的类的全限定名创建对象
     * @param
     * @return
     */
    /*public static Object getBean(String className){
        //使用反射，创建类的对象
        try {
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();

            throw new RuntimeException("反射创建对象失败");
        }
    }*/

    static {
        //解析beans.xml文件,获取所有的id和class的值，并且根据class的值创建对象，然后将id作为key，对象作为value存储到beanMap中
        //1. 解析beans.xml文件，根据id获取要创建对象的类的全限定名
        SAXReader reader = new SAXReader();
        //将beans.xml文件转换成字节输入流
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");

        //2. 读取配置文件，得到document对象
        try {
            Document document = reader.read(is);
            //3. 查找所有的bean标签
            List<Element> list = document.selectNodes("//bean");
            if (list != null && list.size() > 0) {
                //遍历出每一个bean标签
                for (Element element : list) {
                    //获取每一个bean标签的id属性和class属性
                    String attrId = element.attributeValue("id");
                    String attrClass = element.attributeValue("class");

                    //根据类的全限定名，创建对象
                    Object obj = Class.forName(attrClass).newInstance();

                    //以id作为key，对象作为value，存储到beanMap中
                    beanMap.put(attrId,obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object getBean(String id){
        //你传id给我，我直接将这个id对应的对象给你
        return beanMap.get(id);
    }
}
