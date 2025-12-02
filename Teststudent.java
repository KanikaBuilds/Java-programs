import java.util.*;

class Student {
    int rollNo;
    String name;
    String course;

    void insertRecord(int r, String n, String c) {
        rollNo = r;
        name = n;
        course = c;
    }

    void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Course: " + course);
    }
}

public class Teststudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int num = sc.nextInt();
        // sc.nextLine(); // consume newline

        Student[] students = new Student[num];

        // Input student records
        for (int i = 0; i < num; i++) {
            students[i] = new Student();

            System.out.println("\nEnter details for Student " + (i + 1) + ":");

            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            students[i].insertRecord(rollNo, name, course);
        }

        // Ask user to filter by course
        System.out.print("\nEnter course you want to show: ");
        String filterCourse = sc.nextLine();

        System.out.println("\nStudents enrolled in " + filterCourse + ":");
        // boolean found = false;
        // for (Student student : students) {
        //     if (student.course.equalsIgnoreCase(filterCourse)) {
        //         student.display();
        //         found = true;
        //     }
        // }
        boolean found = false;

        for (int i = 0; i < students.length; i++) {
            String course = students[i].course;

            if (course.length() != filterCourse.length()) {
                continue;
            }

            boolean isSame = true;
            for (int j = 0; j < course.length(); j++) {
                char c1 = course.charAt(j);
                char c2 = filterCourse.charAt(j);

                // convert uppercase to lowercase manually
                if (c1 >= 'A' && c1 <= 'Z') c1 += 32;
                if (c2 >= 'A' && c2 <= 'Z') c2 += 32;

                if (c1 != c2) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                students[i].display();
                found = true;
            }
        }


        if (!found) {
            System.out.println("No students found in the course: " + filterCourse);

        }

        sc.close();
    }
}
