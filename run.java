package project;
import java.util.*;

// This is the main file that would be used to run the src file code 
public class run_n {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        src toDoList = new src();
        boolean terminate = false;
        System.out.println("Welcome to the TO DO LIST PROGRAM");

        while (!terminate) {
            System.out.println("MENU");
            System.out.print("\n1. Add Task\n2. Modify Task\n3. Delete Task\n4. Print Task List\n5. Show Task List\n6. Exit\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            String taskString, taskTime;
            int index;

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    taskString = scanner.nextLine();  // Reads the entire line for the task
                    System.out.print("\nEnter the Time {format -> HH:mm}: ");
                    taskTime = scanner.nextLine();    // Reads the entire line for time
                    toDoList.add_task(taskString, taskTime);
                    break;

                case 2:
                    System.out.print("Option 1: Change task\nOption 2: Change task & time\nEnter your choice: ");
                    int sub_choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    switch (sub_choice) {
                        case 1:
                            toDoList.display();
                            System.out.print("Enter the new task: ");
                            taskString = scanner.nextLine();
                            System.out.print("\nEnter the index: ");
                            index = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left-over
                            toDoList.modify_task(index, taskString);
                            break;

                        case 2:
                            toDoList.display();
                            System.out.print("Enter the new task: ");
                            taskString = scanner.nextLine();
                            System.out.print("\nEnter the Time {format -> HH:mm}: ");
                            taskTime = scanner.nextLine();
                            System.out.print("\nEnter the index: ");
                            index = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left-over
                            toDoList.modify_task(index, taskString, taskTime);
                            break;

                        default:
                            System.out.println("Invalid choice!!! Please try again.");
                            break;
                    }
                    break;

                case 3:
                    toDoList.display();
                    System.out.print("\nEnter the index: ");
                    index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    toDoList.remove_task(index);
                    break;

                case 4:
                    toDoList.print();
                    break;

                case 5:
                    toDoList.display();
                    break;

                case 6:
                    terminate = true;
                    break;

                default:
                    System.out.println("Invalid choice!!! Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
