package cms.utils.string;

import java.text.MessageFormat;

public class format {
    public static String StringFormat(String str, Object[] obj) {
        return MessageFormat.format(str, obj);
    }

    public static String StringFormat(String str, String... parm) {
        Object[] obj = new Object[parm.length];
        for (int i = 0; i < parm.length; i++)
            obj[i] = parm[i];
        return MessageFormat.format(str, obj);
    }
}
