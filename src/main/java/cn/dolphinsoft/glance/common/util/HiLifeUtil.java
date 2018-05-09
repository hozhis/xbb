package cn.dolphinsoft.glance.common.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.dolphinsoft.glance.common.util.web.WebUtil;
import sun.misc.BASE64Decoder;

/**
 * Class Name: HLUtil Description: 中策项目工具类
 * 
 * @author hozhis
 *
 */
public class HiLifeUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HiLifeUtil.class);

    /**
     * 描述: 判断字符串是否为空
     * 
     * @param name
     * @return
     */
    public static boolean isEmpty(String name) {
        return ("null".equals(name) || null == name || name.length() == 0);
    }

    /**
     * 描述: 判断字符串是否为空
     * 
     * @param name
     * @return
     */
    public static boolean isNotEmpty(String name) {
        return (null != name && name.length() > 0);
    }

    /**
     * 描述: 模糊查询时,过滤特殊字符
     * 
     * @param string
     * @return
     */
    public static String filterString(String string) {
        return "%" + string.replaceAll("_", "\\\\_").replaceAll("%", "\\\\%").replaceAll("＿", "\\\\＿").trim() + "%";
    }

    /**
     * 描述: 模糊查询时,过滤特殊字符
     * 
     * @param string
     * @return
     */
    public static String filterStringRight(String string) {
        return string.replaceAll("_", "\\\\_").replaceAll("%", "\\\\%").replaceAll("＿", "\\\\＿").trim() + "%";
    }

    /**
     * 描述: 模糊查询时,过滤特殊字符
     * 
     * @param string
     * @return
     */
    public static String filterStringLeft(String string) {
        return "%" + string.replaceAll("_", "\\\\_").replaceAll("%", "\\\\%").replaceAll("＿", "\\\\＿").trim();
    }

    /**
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean objCompator(Object obj1, Object obj2) {
        if (obj1 == null && obj2 != null) {
            return false;
        } else if (obj1 != null) {
            return obj1.equals(obj2);
        }
        return true;
    }

    /**
     * 描述: 将对象转化成json字符串
     * 
     * @param object
     * @return
     */
    public static String parseObjTOString(Object object) {
        try {
            return WebUtil.getObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.error("Json转换错误", e);
        }
        return null;
    }

    /**
     * Description: 将json字符串转化为Object对象
     *
     * @param content
     * @param valueType
     * @return
     */
    public static <T> T parseStringToObj(String content, Class<T> valueType) {
        try {
            return WebUtil.getObjectMapper().readValue(content, valueType);
        } catch (IOException e) {
            LOGGER.error("Json转换错误", e);
        }
        return null;
    }

    public static InputStream base64ToInputStream(String base64Str) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return new ByteArrayInputStream(decoder.decodeBuffer(base64Str));
    }

}
