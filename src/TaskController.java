import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskController extends JFrame{

    private DatabaseConnection data;

    private TaskModel model;
    private TaskView view;
    private String taskName;


    public TaskController(DatabaseConnection databaseConnection, TaskModel model, TaskView view){
        this.model = model;
        this.view = view;

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        view.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                find();
            }
        });


    }

    public void add(){
        JFrame newFrame = new JFrame("Add New Task");
        newFrame.setSize(400, 600);
        JPanel panel = new JPanel(new GridLayout(5,2));


        JLabel nameLabel = new JLabel("Task Name: ");
        JLabel descLabel = new JLabel("Description: ");
        JLabel categoryLabel = new JLabel("Category: ");
        JLabel deadlineLabel = new JLabel("Deadline: ");

        JTextField nameField = new JTextField();
        JTextField descField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField deadlineField = new JTextField();

        JButton addButton = new JButton("Add Task");


        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(descLabel);
        panel.add(descField);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(deadlineLabel);
        panel.add(deadlineField);
        panel.add(addButton);
        newFrame.add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.addTask(nameField.getText(), descField.getText(),
                        categoryField.getText(), deadlineField.getText());
                String task = nameField.getText() + ", ";

                view.getList().add(nameField.getText());
            }
        });

        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setVisible(true);
    }

    public void delete(){
        JFrame newFrame = new JFrame("Delete Task");
        newFrame.setSize(200, 300);
        JPanel panel = new JPanel(new GridLayout(2,2));

        JLabel nameLabel = new JLabel("Task Name: ");

        JTextField nameField = new JTextField();

        JButton deleteButton = new JButton("Delete Task");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(deleteButton);

        newFrame.add(panel);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.deleteTask(nameField.getText());

                view.getList().remove(nameField.getText());
            }
        });

        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setVisible(true);
    }

    public void find(){
        JFrame newFrame = new JFrame("Find The Task");
        newFrame.setSize(200, 300);
        JPanel panel = new JPanel(new GridLayout(2,2));

        JLabel nameLabel = new JLabel("Task Name: ");

        JTextField nameField = new JTextField();

        JButton findButton = new JButton("Find Task");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(findButton);

        newFrame.add(panel);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               taskName = nameField.getText();
               view.getList().remove(nameField.getText());
               edit();
            }
        });

        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setVisible(true);
    }


    public void edit (){
        JFrame newFrame = new JFrame("Edit The Task");
        newFrame.setSize(400, 600);
        JPanel panel = new JPanel(new GridLayout(5,2));

        JLabel nameLabel = new JLabel("Task Name: ");
        JLabel descLabel = new JLabel("Description: ");
        JLabel categoryLabel = new JLabel("Category: ");
        JLabel deadlineLabel = new JLabel("Deadline: ");

        JTextField nameField = new JTextField();
        JTextField descField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField deadlineField = new JTextField();

        JButton editButton = new JButton("Edit Task");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(descLabel);
        panel.add(descField);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(deadlineLabel);
        panel.add(deadlineField);
        panel.add(editButton);
        newFrame.add(panel);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.editTask(taskName, nameField.getText(), descField.getText(),
                        categoryField.getText(), deadlineField.getText());

                view.getList().add(nameField.getText());
            }
        });


        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setVisible(true);

    }

}
