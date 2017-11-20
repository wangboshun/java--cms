package cms.exception;

public class ExceptionBase extends Exception {

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private int errorcode;
    private String info;

    public ExceptionBase() {
        super();
    }

    public ExceptionBase(String s) {
        super(s);
    }

    public ExceptionBase(int errorcode, String info) {
        this.errorcode = errorcode;
        this.info = info;
    }
}
