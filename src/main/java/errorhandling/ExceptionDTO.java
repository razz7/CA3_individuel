package errorhandling;

public class ExceptionDTO {

    public ExceptionDTO(int code, String description) {
        this.code = code;
        this.msg = description;
    }
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }

}
