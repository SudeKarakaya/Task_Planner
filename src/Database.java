

public interface Database {
    public void addTask(String name, String desc, String category, String deadline);
    public void deleteTask(String name);
    public void editTask(String oldName, String name, String desc, String category, String deadline);
}
