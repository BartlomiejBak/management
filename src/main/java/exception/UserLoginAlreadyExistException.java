package exception;

public class UserLoginAlreadyExistException extends Exception {

    public UserLoginAlreadyExistException() {
    }

    public UserLoginAlreadyExistException(String message) {
        super(message);
    }
}
