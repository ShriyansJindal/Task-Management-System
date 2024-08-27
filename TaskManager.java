import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Enums.Priority;
import Enums.Status;

public class TaskManager {
    private List<Task> tasks;
    
    public TaskManager(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void deleteTask(int index){
        if(index >= 0 && index < tasks.size()){
            tasks.remove(index);
        }
    }

    public void updateTask(int index, Task task){
        if(index >= 0 && index < tasks.size()){
            tasks.set(index, task);
        }
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public List<Task> filterTasksByStatus(Status status){
        return tasks.stream().filter(n-> n.getStatus() == status).collect(Collectors.toList());
    }

    public List<Task> filterTasksByPriority(Priority priority){
        return tasks.stream().filter(n->n.getPriority() == priority).collect(Collectors.toList());
    }
    
    public List<Task> filterTasksByDueDate(LocalDate dueDate){
        return tasks.stream().filter(n->n.getDueData().equals(dueDate)).collect(Collectors.toList());
    }

    public Optional<Task> findTaskByIndex(int index) {
        if (index >= 0 && index < tasks.size()) {
            return Optional.of(tasks.get(index));
        }
        return Optional.empty();
    }

    public List<Task> searchTasks(String keyword){
        return tasks.stream().filter(n-> n.getTitle().contains(keyword) || n.getDescription().contains(keyword)).collect(Collectors.toList());
    }
    
}
