import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskManager {

    public Scanner scanner = new Scanner(System.in);
    public Map<Integer, Task> map = new HashMap<>();

    public void delete(){
        System.out.print("Please enter task ID: ");
        Integer taskID = scanner.nextInt();
        map.remove(taskID);
    }

    public void addNewTask(){
        System.out.println("\nInput uniq id: ");
        Integer id = scanner.nextInt();
        System.out.println("Input task name: ");
        String name = scanner.nextLine();
        System.out.println("Input task description: ");
        String description = scanner.nextLine();
        System.out.println("Input date in the following format yyyy-MM-dd: ");
        String stringDate = scanner.nextLine();
        Date date = parseDate(stringDate);
        map.put( id, new Task(id, name, description, date, false));
    }

    public void updateTask(){
        System.out.println("Please enter task id:");
        Integer id = scanner.nextInt();
        System.out.println("Is the task done?");
        Boolean reply = scanner.nextBoolean();
        map.get(id).setDone(reply);
    }

    public int selectOption(){
        System.out.println("     Welcome to TODO List App  ");
        System.out.println("Available options: ");
        System.out.println("[1] View All tasks");
        System.out.println("[2] Add new task");
        System.out.println("[3] Delete a task");
        System.out.println("[4] Update a task");
        System.out.println("[0] Exit\n\n");
        return scanner.nextInt();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public void printMap(){
        if (!map.isEmpty()){
            String prettyMap = map.entrySet().stream().map(e -> e.getValue() + "\n").collect(Collectors.joining(" "));
            System.out.println(prettyMap);
        } else {
            System.out.println("There are no tasks yet");
        }
    }

}
