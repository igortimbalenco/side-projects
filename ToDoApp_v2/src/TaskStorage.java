import java.util.Arrays;
import java.util.List;

public class TaskStorage {
    private Task[] allTasks;

    public Task[] findAll(){
        return this.allTasks;
    }

    public Task findById(int id){
        for (int i = 0; i < allTasks.length; i++){
            if (id == allTasks[i].getId())
                return allTasks[i];
        }
        return null;
    }

    public void createTask(Task task){
        //To Do
    }

    public void removeById(int id){
        List<Task> taskList = Arrays.asList(allTasks);
        taskList.remove(taskList.stream().filter(task -> id == task.getId()).findFirst().orElse(null));
        allTasks = (Task[]) taskList.toArray();
    }

    public void removeFromAllTasksByIndex(int index){
        List<Task> taskList = Arrays.asList(allTasks);
        taskList.remove(index);
        allTasks = (Task[]) taskList.toArray();
    }
}
