package cms.exception;

public class ExceptionTest {

    public static void Test(String s) throws ExceptionBase {
        if (s.equals("a"))
            throw new ExceptionBase("ExceptionTest-----" + s);
    }

    public static void Test(int errorcode, String info) throws ExceptionBase {
        throw new ExceptionBase(errorcode, "ExceptionTest-----" + info);
    }

}
