package prog5121.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskArrayTest {
    
    private TaskArray instance;

    @Before
    public void setUp() {
        instance = new TaskArray();
       
    }

    @After
    public void tearDown() {
        //instance = null;
    }

    @Test
    public void testAddTask() {
        System.out.println("Developer entry for Test data for task 1-4:");
        
        Task task1 = new Task("To Do", "Mike Smith", "create Login", "Create the login page for the app", 5);
        Task task2 = new Task("Doing", "Edward Harrison", "Create Add Features", "Implement add feature functionality", 8);
        Task task3 = new Task("Done", "Samantha Paulson", "Create Reports", "Generate reports based on data", 2);
        Task task4 = new Task("To Do", "Glenda Oberholzer", "Add Arrays", "Implement array functionalities", 11);
        
        instance.addTask(task1);
        instance.addTask(task2);
        instance.addTask(task3);
        instance.addTask(task4);
        
        assertEquals(4, instance.developers.size());
        
        // Task 1 
        assertEquals("Mike Smith", instance.developers.get(0));
        assertEquals("create Login", instance.taskNames.get(0));
        assertEquals(task1.getTaskID(), instance.taskIDs.get(0));
        assertEquals(5, (int) instance.taskDurations.get(0));
        assertEquals("To Do", instance.taskStatuses.get(0));

        // Task 2 
        assertEquals("Edward Harrison", instance.developers.get(1));
        assertEquals("Create Add Features", instance.taskNames.get(1));
        assertEquals(task2.getTaskID(), instance.taskIDs.get(1));
        assertEquals(8, (int) instance.taskDurations.get(1));
        assertEquals("Doing", instance.taskStatuses.get(1));

        // Task 3 
        assertEquals("Samantha Paulson", instance.developers.get(2));
        assertEquals("Create Reports", instance.taskNames.get(2));
        assertEquals(task3.getTaskID(), instance.taskIDs.get(2));
        assertEquals(2, (int) instance.taskDurations.get(2));
        assertEquals("Done", instance.taskStatuses.get(2));

        // Task 4 
        assertEquals("Glenda Oberholzer", instance.developers.get(3));
        assertEquals("Add Arrays", instance.taskNames.get(3));
        assertEquals(task4.getTaskID(), instance.taskIDs.get(3));
        assertEquals(11, (int) instance.taskDurations.get(3));
        assertEquals("To Do", instance.taskStatuses.get(3));
    }
    
    
@Test
public void testDisplayLongestTask() {
    System.out.println("displayLongestTask");
    
    TaskArray instance = new TaskArray();
    instance.addTask(new Task("To Do", "Glenda Oberholzer", "Add Arrays", 11));
    
   
    String longestTaskReport = instance.getLongestTaskReport();
    
   
    String expectedReport = "Task with the longest duration:\n\n" +
                            "Developer: Glenda Oberholzer\n" +
                            "Task Name: Add Arrays\n" +
                            "Duration: 11 hours\n\n";

    assertEquals(expectedReport, longestTaskReport);
}
    
 @Test
public void testSearchTaskByName() {
    System.out.println("Mike Smith, Create Login");
    Task task1 = new Task("To Do", "Mike Smith", "create Login", "Create the login page for the app", 5);
    instance.addTask(task1);

    String taskNameToSearch = "create Login";
    String searchResult = instance.searchTaskByName(taskNameToSearch);

    String expectedResult = "Search results for task  '" + taskNameToSearch + "':\n\n" +
                            "Task Name: " + task1.getTaskName() + "\n" +
                            "Developer: " + task1.getDeveloperDetails() + "\n"+
                            "Status: " + task1.getTaskStatus() + "\n\n";

    assertEquals(expectedResult, searchResult);
}
    
   @Test
public void testSearchTasksByDeveloper() {
    System.out.println("Create Reports");
    String developer = "Samantha Paulson";
    TaskArray instance = new TaskArray();
    
   
    instance.addTask(new Task("Done", "Samantha Paulson", "Create Reports", "Generate reports based on data", 2));
    String tasksByDeveloper = instance.getTasksByDeveloper(developer);

    String expectedReport = "Tasks assigned to 'Samantha Paulson':\n\n" +
                            "Task Name: Create Reports\n" +
                            "Status: Done\n\n";
    assertEquals(expectedReport, tasksByDeveloper);
}
    
    @Test
    public void testDeleteTaskByName() {
        System.out.println("Entry Create reports successfully deleted");
        String taskName = "Create Reports";
        TaskArray instance = new TaskArray();
        instance.addTask(new Task("Done", "Samantha Paulson", "Create Reports", "Generate reports based on data", 2));
        instance.deleteTaskByName(taskName);
        assertFalse(instance.taskNames.contains(taskName));
        assertEquals(0, instance.taskNames.size());
    }
    
    
       @Test
    public void testShowReport() {
        System.out.println("showReport");
        TaskArray instance = new TaskArray();
        instance.addTask(new Task("To Do", "Mike Smith", "create Login", "Create the login page for the app", 5));
        instance.addTask(new Task("Doing", "Edward Harrison", "Create Add Features", "Implement add feature functionality", 8));
        instance.addTask(new Task("Done", "Samantha Paulson", "Create Reports", "Generate reports based on data", 2));
        instance.addTask(new Task("To Do", "Glenda Oberholzer", "Add Arrays", "Implement array functionalities", 11)); 
        instance.showReport();
    }
}
