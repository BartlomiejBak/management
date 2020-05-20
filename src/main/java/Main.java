import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;
import entity.enums.Color;
import entity.enums.Material;
import entity.enums.SkinType;
import entity.parser.ColorParser;
import entity.parser.MaterialParser;
import entity.parser.SkinParser;
import facade.ProductFacadeImpl;
import facade.UserRegisterLoginFacadeImpl;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    static UserRegisterLoginFacadeImpl userRegisterLoginFacade = UserRegisterLoginFacadeImpl.getInstance();
    static ProductFacadeImpl productFacade = ProductFacadeImpl.getInstance();

    public static void main(String[] args) throws IOException {
	    int control = -1;

	    while (control != 0) {
            System.out.println("MANAGEMENT MENU");
            System.out.println("1 - Log in");
            System.out.println("2 - Register");
            System.out.println("3 - show users");
            System.out.println("0 - Exit");
            control = Integer.parseInt(scanner.nextLine());

            switch (control) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    userRegisterLoginFacade.showAllUsers();
                    break;
                default:
                    break;
            }
        }
    }

    public static void login() throws IOException {
        System.out.println("Please write your login: ");
        String login = scanner.nextLine();
        System.out.println("Please enter password: ");
        String password = scanner.nextLine();

        if (userRegisterLoginFacade.loginUser(login, password)) {
            System.out.println("hello " + login);

            int control = -1;
            while (control != 0) {
                System.out.println("MANAGEMENT MENU");
                System.out.println("1 - Add new product");
                System.out.println("0 - Logout");
                control = Integer.parseInt(scanner.nextLine());
                if (control == 1) productTypeMenu();
            }
        } else {
            System.out.println("wrong login or password");
        }
    }

    public static void productTypeMenu() {

        System.out.println("1 - Add boots");
        System.out.println("2 - Add cloth");
        System.out.println("3 - Other");
        int control = Integer.parseInt(scanner.nextLine());
        switch (control) {
            case 1:
                addShoe();
                break;
            case 2:
                addCloth();
                break;
            case 3:
                addProduct();
                break;
            default:
                break;
        }
    }


    private static void addProduct() {
        System.out.println("Write id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Write product name: ");
        String name = scanner.nextLine();
        System.out.println("Write product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Write product weight: ");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.println("Write product color (RED, BLUE, GREEN, WHITE, BLACK, YELLOW): ");
        Color color = ColorParser.parseColor(scanner.nextLine());
        System.out.println("Write product count: ");
        int count = Integer.parseInt(scanner.nextLine());

        productFacade.addProduct(new Product(id, name, price, weight, color, count), "P");
    }

    private static void addCloth() {
        System.out.println("Write id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Write product name: ");
        String name = scanner.nextLine();
        System.out.println("Write product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Write product weight: ");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.println("Write product color (RED, BLUE, GREEN, WHITE, BLACK, YELLOW): ");
        Color color = ColorParser.parseColor(scanner.nextLine());
        System.out.println("Write product count: ");
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("Write product size: ");
        String size = scanner.nextLine();
        System.out.println("What kind of material is it (LEATHER, FUR, COTTON, WOOL, POLYESTERS: ");
        Material material = MaterialParser.parseMaterial(scanner.nextLine());

        productFacade.addProduct(new Cloth(id, name, price, weight, color, count, size, material), "C");
    }

    public static void addShoe() {
        System.out.println("Write id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Write product name: ");
        String name = scanner.nextLine();
        System.out.println("Write product price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Write product weight: ");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.println("Write product color (RED, BLUE, GREEN, WHITE, BLACK, YELLOW): ");
        Color color = ColorParser.parseColor(scanner.nextLine());
        System.out.println("Write product count: ");
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("Write product size: ");
        double size = Double.parseDouble(scanner.nextLine());
        System.out.println("What kind of skin is it (NATURAL/ARTIFICIAL): ");
        SkinType skinType = SkinParser.parseSkinType(scanner.nextLine());

        productFacade.addProduct(new Boots(id, name, price, weight, color, count, size, skinType), "B");
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
