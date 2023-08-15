package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XmlReaderUtil {

    public static final Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("/Users/liuping/workspace/jsyl/dm-fddh-backend-sleep-wb/WEB-INF/web.xml"));
        Element rootElement = read.getRootElement();
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            System.out.println("\n");

            Element next = elementIterator.next();
//            System.out.println(next.getName() + ":" + next.getStringValue());
            if ( next.getName().equals("servlet")) {
                if (next.hasContent()) {
                    List<Node> content = next.content();
                    for (Node node : content) {
                        if ("servlet-name".equals(node.getName())
                        || "servlet-class".equals(node.getName())
                        ) {
                            System.out.println(node.getName()+":"+node.getStringValue());

                        }
                    }
                }
            } else if (next.getName().equals("servlet-mapping")) {
                if (next.hasContent()) {
                    List<Node> content = next.content();
                    for (Node node : content) {
                        if ("servlet-name".equals(node.getName())
                                || "url-pattern".equals(node.getName())
                        ) {
                            System.out.println(node.getName()+":"+node.getStringValue());

                        }
                    }
                }
            }
        }
//        rootElement.elementIterator("")
    }
}
