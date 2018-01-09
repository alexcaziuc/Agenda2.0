import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBOperations dbOperations = new DBOperations();

        int optiune;

        do {
            showMenu();
            System.out.print("Optiune -> ");
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();

            if (optiune >= 0 && optiune <= 5) {
                switch (optiune) {
                    case 1: {
                        System.out.println("Lista de contacte: ");
                        dbOperations.displayAgenda();
                        System.out.println("");
                        break;
                    }

                    case 2: {
                        System.out.println("Numele si telefonul de adaugat -> ");

                        System.out.println("Numele: ");
                        String numeCitit = readName();

                        System.out.println("Telefonul: ");
                        String phoneCitit = readPhone();

                        Person p = new Person(numeCitit, phoneCitit);
                        dbOperations.addContact(p);
                        break;
                    }

                    case 3: {
                        System.out.println("Sterge contactul cu numele: ");
                        String numeCitit = readName();

                        Person p = new Person(numeCitit);
                        dbOperations.deleteContact(p);
                        break;
                    }

                    case 4: {
                        System.out.println("Editeaza contactul cu numele: ");
                        String oldName = readName();

                        Person p = new Person(oldName);
                        dbOperations.searchContact(p);

                        System.out.println("Numele nou este: ");
                        String numeNouCitit = readName();
                        p.setName(numeNouCitit);

                        System.out.println("Telefonul nou este: ");
                        String phoneNouCitit = readPhone();
                        p.setPhone(phoneNouCitit);

                        dbOperations.editContact(p, oldName);

                        break;
                    }

                    case 5: {
                        System.out.println("Contactul cautat:");
                        String numeCitit = readName();

                        Person p = new Person(numeCitit);

                        dbOperations.searchContact(p);

                        break;
                    }
                }
            } else {
                System.out.println("\nOptiune invalida !\n");
            }
        } while (optiune != 0);
    }

    private static void showMenu() {
        System.out.println("1> Display Agenda");
        System.out.println("2> Add");
        System.out.println("3> Delete");
        System.out.println("4> Edit");
        System.out.println("5> Search");
        System.out.println("0> Exit");
    }

    private static String readName() {
        Scanner scan = new Scanner(System.in);
        String numeCitit = scan.nextLine();

        return numeCitit;
    }

    private static String readPhone() {

        Scanner scan = new Scanner(System.in);
        String telefonulCitit = scan.nextLine();

        return telefonulCitit;
    }
}
