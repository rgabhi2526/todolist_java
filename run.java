package project;
import java.util.*;
public class run {
    public static void main(String[] args) {
        src toDoList=new src();
        toDoList.add_task("buy milk", "08:00");
        toDoList.display();
        toDoList.print();
        toDoList.modify_task(0, "buy bread");
        toDoList.display();
        toDoList.remove_task(0);
        toDoList.display();
    }
    
}
