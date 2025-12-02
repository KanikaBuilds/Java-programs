class Studentrecord {
    int id;
    String name;

    Studentrecord() {
        id = 0;
        name = "Not Assigned";
    }

    Studentrecord(int i, String n) {
        id = i;
        name = n;
    }

    Studentrecord(int i) {
        id = i;
        name = "Unknown";
    }

    Studentrecord(String n) {
        id = 0;
        name = n;
    }

    void insertRecord(int i, String n) {
        id = i;
        name = n;
    }

    void insertRecord(int i) {
        id = i;
        name = "Unknown";
    }

    void insertRecord(String n) {
        id = 0;
        name = n;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    void display(String greeting) {
        System.out.println(greeting + " ID: " + id + ", Name: " + name);
    }
}

public class Student {
    public static void main(String[] args) {
        Studentrecord s1 = new Studentrecord(101, "Kanika");
        Studentrecord s2 = new Studentrecord(102);
        Studentrecord s3 = new Studentrecord("Varuni");
        Studentrecord s4 = new Studentrecord();

        s1.display();
        s2.display("Hello, ");
        s3.display("Welcome, ");
        s4.display("Default -> ");
    }
}

