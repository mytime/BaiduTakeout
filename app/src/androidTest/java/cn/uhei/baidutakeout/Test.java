package cn.uhei.baidutakeout;

import android.content.ContentValues;
import android.content.Context;
import android.test.AndroidTestCase;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Administrator on 2016/1/23.
 */
public class Test extends AndroidTestCase {
    public void test(){

        try {

            //文档生成器工厂对象
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            //实例化一个新的文档生成器
            DocumentBuilder builder = null;

            builder = builderFactory.newDocumentBuilder();

            //利用文档生成器解析xml
            Document document = builder.parse(getContext().getAssets().open("languages.xml"));

            //获取根元素（Languages）
            Element element = document.getDocumentElement();
            //获取节点列表，获取子tag
            NodeList list = element.getElementsByTagName("shops");

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.getLength(); i++) {
                Element shops = (Element) list.item(i);
                sb.append(shops.getElementsByTagName("title").item(0).getTextContent());
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + sb.toString());


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
