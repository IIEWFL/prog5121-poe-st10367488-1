package prog5121.project;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TaskArray {
    
    ArrayList<String> developers = new ArrayList<>();
    ArrayList<String> taskNames = new ArrayList<>();
    ArrayList<String> taskIDs = new ArrayList<>();
    ArrayList<Integer> taskDurations = new ArrayList<>();
    ArrayList<String> taskStatuses = new ArrayList<>();

    //code Attributes:
    // 1. I found the code at Stackoverflow
   // https://stackoverflow.com/questions/33371851/return-or-print-stringbuilder-java
    //Author: whales
    // https://stackoverflow.com/users/5285528/whales
    
    //2. Found code in GreeksforGreeks and is modified
    //https://www.geeksforgeeks.org/arraylist-in-java/
    //Author:GreeksforGreeks
    
    //3. Found the code in Baeldung and modified the code  
    //https://www.baeldung.com/java-string-concatenation#:~:text=Using%20the%20concat()%20Method,original%20String%20isn't%20changed.
    //Author: baeldung 
    
    
    
    public void addTask(Task task) {
        int taskNumber = developers.size() + 1;
        developers.add(task.getDeveloperDetails());
        taskNames.add(task.getTaskName());
        taskIDs.add(task.getTaskID());
        taskDurations.add(task.getTaskDuration());
        taskStatuses.add(task.getTaskStatus());
        System.out.println("Added task " + taskNumber + ": " + task.getDeveloperDetails());
    }

    public int getTaskCount() {
        return taskNames.size();
    }

    public void showReport() {
        StringBuilder report = new StringBuilder("Task Report:\n\n");

        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task ID: ").append(taskIDs.get(i)).append("\n")
                    .append("Task Name: ").append(taskNames.get(i)).append("\n")
                    .append("Developer: ").append(developers.get(i)).append("\n")
                    .append("Duration: ").append(taskDurations.get(i)).append(" hours\n")
                    .append("Status: ").append(taskStatuses.get(i)).append("\n\n");
        }

        int totalHours = 0;
        for (int duration : taskDurations) {
            totalHours += duration;
        }

        report.append("Total Hours for all tasks: ").append(totalHours);
        JOptionPane.showMessageDialog(null, report.toString());
    }

    public void displayDoneTasks() {
        StringBuilder report = new StringBuilder("Tasks with status 'Done':\n\n");

        for (int i = 0; i < taskNames.size(); i++) {
            if ("Done".equalsIgnoreCase(taskStatuses.get(i))) {
                report.append("Developer: ").append(developers.get(i)).append("\n")
                        .append("Task Name: ").append(taskNames.get(i)).append("\n")
                        .append("Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }

    public String getLongestTaskReport() {
        int maxDuration = -1;
        int maxIndex = -1;

        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                maxIndex = i;
            }
        }

        if (maxIndex != -1) {
            StringBuilder report = new StringBuilder("Task with the longest duration:\n\n");
            report.append("Developer: ").append(developers.get(maxIndex)).append("\n")
                    .append("Task Name: ").append(taskNames.get(maxIndex)).append("\n")
                    .append("Duration: ").append(taskDurations.get(maxIndex)).append(" hours\n\n");

            return report.toString();
        }
        return "No tasks available.";
    }

    public void displayLongestTask() {
        String report = getLongestTaskReport();
        JOptionPane.showMessageDialog(null, report);
    }

    public String searchTaskByName(String taskName) {
        StringBuilder report = new StringBuilder("Search results for task  '" + taskName + "':\n\n");

        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                report.append("Task Name: ").append(taskNames.get(i)).append("\n")
                        .append("Developer: ").append(developers.get(i)).append("\n")
                        .append("Status: ").append(taskStatuses.get(i)).append("\n\n");
            }
        }
        String output1 = report.toString();

        // JOptionPane.showMessageDialog(null,report.toString());
         return output1;
    }

    public String getTasksByDeveloper(String developer) {
        StringBuilder report = new StringBuilder("Tasks assigned to '" + developer + "':\n\n");

        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developer)) {
                report.append("Task Name: ").append(taskNames.get(i)).append("\n")
                        .append("Status: ").append(taskStatuses.get(i)).append("\n\n");
            }
        }

        return report.toString();
    }

    public void searchTasksByDeveloper(String developer) {
        String report = getTasksByDeveloper(developer);
        JOptionPane.showMessageDialog(null, report);
    }

    public void deleteTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' has been deleted.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task '" + taskName + "' not found.");
    }
}