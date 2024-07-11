import java.util.*;

interface Credit {
    void creditBalance();
}

interface Debit {
    void debitBalance();
}

class Show {
    void showBalance(int a) {
        System.out.println("Your balance is " + a);
    }
}

class Bank extends Show implements Credit, Debit {
    private int balance = 0;

    public void creditBalance() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter amount to credit: ");
        int a = s.nextInt();
        balance += a;
        System.out.println("Amount credited: " + a);
    }

    public void debitBalance() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter amount to debit: ");
        int b = s.nextInt();
        if (b <= balance) {
            balance -= b;
            System.out.println("Amount debited: " + b);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public int adminLogin() {
        String str;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter username: ");
        str = s.next();
        if (str == "admin") {
            System.out.print("Enter password: ");
            String str2 = s.next();
            if (str2 == "123456") {
                System.out.println("Successful login");
                return 1;
            } else {
                System.out.println("Incorrect password");
                return 0;
            }
        } else {
            System.out.println("Incorrect username");
            return 0;
        }
    }

    public static void main(String args[]) {
        Bank obj = new Bank();
        int c = obj.adminLogin();
        if (c == 1) {
            obj.creditBalance();
            obj.debitBalance();
            obj.showBalance(obj.balance);
        }
    }
}
