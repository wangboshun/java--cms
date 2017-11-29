package cms.utils.xml;

import java.lang.reflect.Field;

public class WeChatXml {

    public static String ToXml(Object entity) {

        String FromUserName = GetValue(entity, "FromUserName").toString();
        String ToUserName = GetValue(entity, "ToUserName").toString();
        String MsgType = GetValue(entity, "MsgType").toString();

        SetVal(entity, "FromUserName", ToUserName);
        SetVal(entity, "ToUserName", FromUserName);

        String str = "<xml>";

        Class c = entity.getClass();

        Field[] f = c.getFields();

        for (Field field : f) {
            String name = field.getName();
            if (name.equals("PicUrl") || name.equals("MsgId") || name.equals("MediaId") || name.equals("Recognition") || name.equals("Format") || name.equals("ThumbMediaId"))
                continue;
            Object val = null;
            try {
                val = field.get(entity);
                if (name.equals("MsgType")) {
                    switch (MsgType) {
                        case "image":
                            str += "<Image><MediaId>" + GetValue(entity, "MediaId").toString() + "</MediaId></Image>";
                            break;
                        case "voice":
                            str += "<Voice><MediaId>" + GetValue(entity, "MediaId").toString() + "</MediaId></Voice>";
                            break;
                        case "video":
                            str += "<Video>" +
                                    "<MediaId>" + GetValue(entity, "MediaId").toString() + "</MediaId>" +
                                    "<Title>标题</Title>" +
                                    "<Description>描述</Description>" +
                                    "</Video>";
                            break;
                    }

                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            str += "<" + name + ">" + val + "</" + name + ">";

        }
        return str + "</xml>";
    }

    //根据key赋值
    public static void SetVal(Object entity, String key, Object obj) {
        try {
            entity.getClass().getField(key).set(entity, obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    //根据key获取实体值
    public static Object GetValue(Object entity, String key) {
        try {
            return entity.getClass().getField(key).get(entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
