import java.time.LocalDate;
import Enums.Priority;
import Enums.Status;

public class Task{
    // Fields
    private String title;
    private String description;
    private LocalDate dueData;
    private Priority priority;
    private Status status;

    // Constructor
    public Task(String title, String description, LocalDate dueData, Priority priority, Status status){
        this.title = title;
        this.description = description;
        this.dueData = dueData;
        this.priority = priority;
        this.status = status;
    }

    // Getters

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public LocalDate getDueData(){
        return dueData;
    }

    public Priority getPriority(){
        return priority;
    }

    public Status getStatus(){
        return status;
    }

    // Setters
    
    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setDueData(LocalDate dueData){
        this.dueData = dueData;
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    // toString method to print the object in a readable format 
    @Override
    public String toString(){
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueData=" + dueData +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }


}