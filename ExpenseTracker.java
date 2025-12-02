import java.io.*;
import java.util.*;

class Expense {
    private String category;
    private double amount;
    private String date;
    private String note;

    public Expense(String category, double amount, String date, String note) {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return "Category: " + category + " | Amount: ₹" + amount +
               " | Date: " + date + " | Note: " + note;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static final String FILE_NAME = "expenses.txt";

    public static void main(String[] args) {
        loadExpenses();
        int choice;

        do {
            System.out.println("\n=== EXPENSE TRACKER MENU ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Total Expenditure");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense();
                    break;
                case 4:
                    viewTotal();
                    break;
                case 5:
                    saveExpenses();
                    System.out.println("Thank you for using Expense Tracker!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addExpense() {
        System.out.print("Enter category (Food, Travel, Bills, etc.): ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter date (DD-MM-YYYY): ");
        String date = sc.nextLine();
        System.out.print("Enter note (optional): ");
        String note = sc.nextLine();

        expenses.add(new Expense(category, amount, date, note));
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }

        System.out.println("\n=== ALL EXPENSES ===");
        int index = 1;
        for (Expense e : expenses) {
            System.out.println(index++ + ". " + e);
        }
    }

    private static void deleteExpense() {
        viewExpenses();
        if (expenses.isEmpty()) return;

        System.out.print("Enter the expense number to delete: ");
        int num = sc.nextInt();
        if (num > 0 && num <= expenses.size()) {
            expenses.remove(num - 1);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Invalid number!");
        }
    }

    private static void viewTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.println("\nTotal Expenditure: ₹" + total);
    }

    private static void saveExpenses() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                bw.write(e.getCategory() + "," + e.getAmount() + "," + e.getDate() + "," + e.getNote());
                bw.newLine();
            }
        } catch (IOException ex) {
            System.out.println("Error saving expenses: " + ex.getMessage());
        }
    }

    private static void loadExpenses() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 4);
                if (parts.length == 4) {
                    expenses.add(new Expense(parts[0], Double.parseDouble(parts[1]), parts[2], parts[3]));
                }
            }
        } catch (IOException ex) {
            System.out.println("Error loading expenses: " + ex.getMessage());
        }
    }
}
