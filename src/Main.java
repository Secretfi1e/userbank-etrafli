import java.util.Scanner;

public class Main {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showAllUsers();
                    break;
                case 2:
                    showUserById();
                    break;
                case 3:
                    createUser();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    removeUser(bank,scanner);
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Zəhmət olmasa aşağıdakı əməliyyatları seçin:");
        System.out.println("1-Bankdaki işçiləri gör");
        System.out.println("2-Bankdaki spesifik işçini gör");
        System.out.println("3-Banka işçi əlavə et");
        System.out.println("4-İşçini yenilə");
        System.out.println("5-İşçini sil");

    }

    private static void showAllUsers() {

        System.out.println("Bankdakı bütün işçilər:");
        User[] allUsers = bank.getAllUser();
        for (User user : allUsers) {
            if (user != null) {
                System.out.println(user.getId() + "ad:" + user.name + "  soyad:" + user.surname + "   email:" + user.email + "  password:" + user.password
                + "  id:" + user.getId());

            }
        }
    }

    private static void showUserById() {
        System.out.println("Görüntüləmək istədiyiniz işçinin ID-sini daxil edin:");
        int id = scanner.nextInt();
        scanner.nextLine();
        User user = bank.getUserById(id);
        if (user != null) {
            System.out.println("Seçdiyiniz işçi: " + user.getId() + "ad:" + user.name + "  soyad:" + user.surname + "   email:" + user.email + "  password:" + user.password
                    + "  id:" + user.getId());
        } else {
            System.out.println("Belə bir işçi tapılmadı.");
        }
    }

    private static void createUser() {
        System.out.println("Yeni bir işçi yaradın:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ad: ");
        String name = scanner.nextLine();
        System.out.print("Soyad: ");
        String surname = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Şifrə: ");
        String password = scanner.nextLine();

        User newUser = new User(name, surname, email, password, id);
        bank.addUser(newUser);
        System.out.println(name + " " + surname + " işçi olaraq əlavə edildi.");
    }

    private static void updateUser() {
        System.out.println("Yeniləmək istədiyiniz işçinin ID-sini daxil edin:");
        int id = scanner.nextInt();
        scanner.nextLine();
        User existingUser = bank.getUserById(id);
        if (existingUser != null) {
            System.out.println("Yeni məlumatları daxil edin:");
            System.out.print("Ad: ");
            String name = scanner.nextLine();
            System.out.print("Soyad: ");
            String surname = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Şifrə: ");
            String password = scanner.nextLine();

            User newUser = new User(name, surname, email, password, id);
            bank.updateUserById(id, newUser);
            System.out.println("İşçi məlumatları yeniləndi.");
        }
    }

    private static void removeUser(Bank bank, Scanner scanner) {
        System.out.print("Silmek istediyiniz iscinin ID-sini daxil edin: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bank.removeUserById(id);
        System.out.println("Isci uğurla silindi.");
    }
}