//2. Browser History Navigation
//Scenario: Simulate the back and forward navigation in a browser using two stacks.

package org.techhub;
import java.util.*;

class BackwordForward {
    int a[];
    int top;
    String lastOperation = "";
    int lastValue;
    boolean isBack = false;

    public BackwordForward() {
        a = new int[5];
        top = -1;
    }

    void push(int value) {
        if (top == a.length - 1) {
            System.out.println("Stack Overflow");
        } else {
            top = top + 1;
            a[top] = value;
            lastOperation = "push";
            lastValue = value;
            System.out.println("Value inserted successfully: " + value);
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            int value = a[top];
            top--;
            lastOperation = "pop";
            lastValue = value;
            System.out.println("Deleted element: " + value);
        }
    }

    void goBack() {
        if (lastOperation.equalsIgnoreCase("push")) {
            if (top > 0) {
                isBack = true;
                top--; // move one step back
                lastValue = a[top];
                System.out.println("Went back to: " + lastValue);
            } else {
                isBack = false;
                System.out.println("No more history to go back.");
            }
        } else if (lastOperation.equalsIgnoreCase("pop")) {
            if (top >= 0) {
                isBack = true;
                System.out.println("Went back after pop, current value: " + a[top]);
            } else {
                isBack = false;
                System.out.println("Stack is empty, cannot go back.");
            }
        } else {
            System.out.println("No operation performed yet.");
        }
    }

    void goForward() {
        if (isBack) {
            if (top < a.length - 1 && lastOperation.equalsIgnoreCase("push")) {
                top++;
                lastValue = a[top];
                System.out.println("Went forward to: " + lastValue);
            } else {
                System.out.println("No forward history available.");
            }
        } else {
            System.out.println("You must go back first before going forward.");
        }
    }
}

public class Browser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BackwordForward bf = new BackwordForward();

        while (true) {
            System.out.println("\nMenu driven program ");
            System.out.println("1. Push (Visit Page)");
            System.out.println("2. Pop (Delete Page)");
            System.out.println("3. Go Back");
            System.out.println("4. Go Forward");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value: ");
                    int value = sc.nextInt();
                    bf.push(value);
                    break;

                case 2:
                    bf.pop();
                    break;

                case 3:
                    bf.goBack();
                    break;

                case 4:
                    bf.goForward();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Choice mismatch");
                    break;
            }
        }
    }
}
