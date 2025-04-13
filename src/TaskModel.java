import java.util.Date;

public class TaskModel {

    String taskName;
    String desc;
    String category;
    Date deadline;

    public TaskModel(String taskName, String desc, String category, Date deadline){
        this.taskName = taskName;
        this.desc = desc;
        this.category = category;
        this.deadline = deadline;
    }


    public String getTaskName() {
        return taskName;
    }

    public String getDesc() {
        return desc;
    }

    public String getCategory() {
        return category;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
