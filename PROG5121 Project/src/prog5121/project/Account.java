package prog5121.project;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Account {

    static String username = "";
    static String password = "";
    static String firstName = "";
    static String lastName = "";
    static TaskArray taskManager = new TaskArray(); 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.println("Enter Username:");
        username = input.nextLine();
        while (!Login.checkUserNameValid(username)) {
            System.out.println("Username must be at least 5 characters long. Please try again.");
            username = input.nextLine();
        }

        System.out.println("Enter Password:");
        password = input.nextLine();
        while (!Login.checkPasswordComplex(password)) {
            System.out.println("Password must be at least 8 characters long and contain both letters and numbers. Please try again.");
            password = input.nextLine();
        }

        System.out.println(Login.registerUser(username, password));
        System.out.println("Enter First Name:");
        firstName = input.nextLine();

        System.out.println("Enter Last Name:");
        lastName = input.nextLine();
        input.close(); 

        JFrame details = new JFrame();
        JOptionPane.showMessageDialog(null, "Welcome to MyWorld");

        
        while (true) {
            String option = JOptionPane.showInputDialog(details, "Choose one of the following: \n "
                    + "1. Add tasks \n"
                    + "2. Show report \n"
                    + "3. Display done tasks \n"
                    + "4. Display longest task \n"
                    + "5. Search task by name \n"
                    + "6. Search tasks by developer \n"
                    + "7. Delete task by name \n"
                    + "8. Quit \n");

            if (option == null) {
                continue;
            }

            int x;
            try {
                x = Integer.parseInt(option);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(details, "Invalid input. Please enter a number.");
                continue;
            }

            if (x == 1) {
                addTasks(details);
            } else if (x == 2) {
                taskManager.showReport();
            } else if (x == 3) {
                taskManager.displayDoneTasks();
            } else if (x == 4) {
                taskManager.displayLongestTask();
            } else if (x == 5) {
                String taskName = JOptionPane.showInputDialog(details, "Enter the task name to search:");
                if (taskName != null) {
                    JOptionPane.showMessageDialog(null,taskManager.searchTaskByName(taskName));
                }
            } else if (x == 6) {
                String developer = JOptionPane.showInputDialog(details, "Enter the developer name to search:");
                if (developer != null) {
                    taskManager.searchTasksByDeveloper(developer);
                }
            } else if (x == 7) {
                String taskToDelete = JOptionPane.showInputDialog(details, "Enter the task name to delete:");
                if (taskToDelete != null) {
                    taskManager.deleteTaskByName(taskToDelete);
                }
            } else if (x == 8) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(details, "Invalid option. Please try again.");
            }
        }
    }

    static int getIntegerInput(JFrame details, String message) {
        String input;
        int result;

        do {
            input = JOptionPane.showInputDialog(details, message);
            if (input == null) {
                return -1; 
            }
            if (!isNumeric(input)) {
                JOptionPane.showMessageDialog(details, "Invalid input. Please enter a number.");
            } else {
                result = Integer.parseInt(input);
                return result;
            }
        } while (true);
    }

    static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    static void addTasks(JFrame details) {
        int numOfTasks = getIntegerInput(details, "Number of tasks:");
        if (numOfTasks == -1) {
            return;
        }

        for (int i = 0; i < numOfTasks; i++) {
            String desc = JOptionPane.showInputDialog(details, "Task Description:");
            while (!Task.checkTaskDescription(desc)) {
                desc = JOptionPane.showInputDialog(details, "Enter description of less than 50 characters");
            }

            String taskName = JOptionPane.showInputDialog(details, "Enter the task name:");
            String developerDetails = JOptionPane.showInputDialog(details, "Enter the developer details:");
            int taskDuration = getIntegerInput(details, "Enter the task duration in hours");

            String[] options = {"To Do", "Done", "Doing"};
            int taskStatusIndex = JOptionPane.showOptionDialog(
                    details,
                    "Select the task status:",
                    "Task Status",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (taskStatusIndex == JOptionPane.CLOSED_OPTION) {
                return; 
            }
            String taskStatus = options[taskStatusIndex];

            Task task = new Task(taskStatus, developerDetails, taskName, desc, taskDuration);

            taskManager.addTask(task);

            JOptionPane.showMessageDialog(details, task.printTaskDetails());
        }
    }

    static void searchTaskByName(JFrame details) {
        String taskName = JOptionPane.showInputDialog(details, "Enter the task name to search:");
        if (taskName != null) {
            taskManager.searchTaskByName(taskName);
        }
    }

    static void searchTasksByDeveloper(JFrame details) {
        String developer = JOptionPane.showInputDialog(details, "Enter the developer name to search:");
        if (developer != null) {
            taskManager.searchTasksByDeveloper(developer);
        }
    }

    static void deleteTaskByName(JFrame details) {
        String taskToDelete = JOptionPane.showInputDialog(details, "Enter the task name to delete:");
        if (taskToDelete != null) {
            taskManager.deleteTaskByName(taskToDelete);
        }
    }
}
