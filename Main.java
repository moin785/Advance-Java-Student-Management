import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name);
    }
}

public class Main {
    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        list.add(new Student(id, name));
        System.out.println("Student Added Successfully ✅");
    }

    static void displayStudents() {
        if (list.isEmpty()) {
            System.out.println("No Students Found ❌");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : list) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.id == id) {
                System.out.println("Student Found ✅");
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found ❌");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = list.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                System.out.println("Student Deleted ✅");
                return;
            }
        }

        System.out.println("Student Not Found ❌");
    }
}