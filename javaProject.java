import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class javaProject extends Frame implements ActionListener {
    TextField taskInput;
    Button addButton, removeButton;
    List taskList;

    ArrayList<String> tasks;

    public javaProject() {
        tasks = new ArrayList<>();

        Label heading = new Label("To-Do List");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setAlignment(Label.CENTER);

        taskInput = new TextField(30);
        addButton = new Button("Add Task");
        removeButton = new Button("Remove Task");
        taskList = new List(10, false); 

        setLayout(new FlowLayout());

        add(heading);
        add(taskInput);
        add(addButton);
        add(removeButton);
        add(taskList);

        addButton.addActionListener(this);
        removeButton.addActionListener(this);

        setTitle("To-Do List");
        setSize(400, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskList.add(task);
                taskInput.setText("");
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex >= 0) {
                tasks.remove(selectedIndex);
                taskList.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new javaProject();
    }
}
