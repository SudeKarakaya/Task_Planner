import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        String day = String.valueOf(dayOfWeek);
        String date = String.valueOf(today);

        Message message = new Message(day, date);
        BirthdayMessage birthdayMessage = new BirthdayMessage("2025-01-19");

        DatabaseConnection data = new DatabaseConnection();
        data.initializeDatabase();
        TaskView view = new TaskView(message, birthdayMessage);
        TaskModel model = new TaskModel(null, null, null, null);
        TaskController controller = new TaskController(data, model, view);
        view.setVisible(true);

    }
}