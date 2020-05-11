package exception;

public class UserShortLengthLoginException extends Exception {

    public UserShortLengthLoginException() {
    }

    public UserShortLengthLoginException(String message) {
        super(message);
    }
}
