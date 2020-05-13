import entity.User;
import facade.UserRegisterLoginFacadeImpl;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    static UserRegisterLoginFacadeImpl userRegisterLoginFacade;

    static {
        try {
            userRegisterLoginFacade = UserRegisterLoginFacadeImpl.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
	    int control = -1;

	    while (control != 0) {
            System.out.println("MANAGEMENT MENU");
            System.out.println("1 - Zaloguj się");
            System.out.println("2 - Zarejestruj się");
            System.out.println("0 - Wyjdź");
            control = Integer.parseInt(scanner.nextLine());

            switch (control) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                default:
                    break;
            }
        }
    }

    public static void login() throws IOException {
        int control = -1;
        while (control != 0) {
            System.out.println("MANAGEMENT MENU");
            System.out.println("1 - Dodaj nowy product");
            System.out.println("0 - Wyloguj się");
            control = Integer.parseInt(scanner.nextLine());
            if (control == 1) productTypeMenu();
        }
    }

    public static void productTypeMenu() throws IOException {
        ProductServiceImpl productService = ProductServiceImpl.getInstance();

        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
        int control = Integer.parseInt(scanner.nextLine());
        switch (control) {
            case 1:

        }
    }

    public static void register() {
        System.out.println("Write user id number: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Write user login: ");
        String login = scanner.nextLine();
        System.out.println("Write user password: ");
        String password = scanner.nextLine();
        try {
            userRegisterLoginFacade.registerUser(new User(number, login, password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
