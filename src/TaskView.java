import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class TaskView extends JFrame {

    private JLabel dateLabel, dayLabel, messageLabel, notifiLabel, taskLabel;
    private JButton addButton, deleteButton, editButton;
    private JTextField dateField, dayField, messageField, notifiField,  nullField;

    private JPanel datePanel, buttonPanel, panel;

    private JList<String> taskList;

    private Date date;

    public ArrayList<String> list;
    public Message message;
    public BirthdayMessage birthdayMessage;



    public TaskView(Message message, BirthdayMessage birthdayMessage){

        this.message = message;
        this.birthdayMessage = birthdayMessage;

        setSize(600, 800);
        setLayout(new GridLayout(12, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        date = new Date();

        dateLabel = new JLabel("Date");
        dayLabel = new JLabel("Day");
        messageLabel = new JLabel("Birthday Celebration Message");
        notifiLabel = new JLabel("Notifications");
        taskLabel = new JLabel("Task List");


        dayField = new JTextField(message.getDay());
        dateField = new JTextField(String.valueOf(message.getDate()));
        if(message.date.equals(birthdayMessage.birthday)) {
            messageField = new JTextField(birthdayMessage.getBirthdayMessage());
        }
        else{
            messageField = new JTextField();
        }

        notifiField = new JTextField();
        nullField = new JTextField();

        list = new ArrayList<>();
        taskList = new JList((ListModel) list);

        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");
        editButton = new JButton("Edit Task");

        datePanel = new JPanel(new GridLayout(2,2));
        buttonPanel = new JPanel(new GridLayout(1,3));
        panel = new JPanel(new GridLayout(3,2));

        datePanel.add(dayLabel);
        datePanel.add(dateLabel);
        datePanel.add(dayField);
        datePanel.add(dateField);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        panel.add(notifiLabel);
        panel.add(taskLabel);
        panel.add(notifiField);
        panel.add(buttonPanel);
        panel.add(nullField);
        panel.add(taskList);


        add(datePanel);
        add(messageLabel);
        add(messageField);
        add(panel);

    }


    public JButton getAddButton() {
        return addButton;
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }
    public JButton getEditButton() {
        return editButton;
    }


  public ArrayList<String> getList(){
        return  list;
  }

}
