package com.story.common.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: lihongyu
 * Date: 13-3-25
 * Time: 下午9:47
 */
public class XmlUtil {
    private final static Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    /**
     * 对象转XML字符串
     *
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> String objecToXml(T bean) {
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(bean.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);// 是否省略xm头声明信息
            marshaller.marshal(bean, writer);
            Pattern p = Pattern.compile("\\s{2,}|\t|\r|\n");//去掉回车换行符号
            Matcher m = p.matcher(writer.toString());
            return m.replaceAll("");
        } catch (Exception e) {
            logger.error("objectToXml error!", e);
        }
        return "";
    }

    /**
     * XML字符串转对象
     *
     * @param xml
     * @param valueType
     * @return
     */
    public static <T> T xmlToObject(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            logger.error("xmlToObject error!", e);
            throw new RuntimeException(e.getMessage());
        }
    }


}
