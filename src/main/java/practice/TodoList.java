package practice;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<String> todos;

    public void ToDoList() {
        this.todos = new ArrayList<>();
    }

    public TodoList() {
        this.todos = todos;
    }

    public List<String> getTodos(){
        return todos;
    }

    public void add(String todo){
        todos.add(todo);
    }

        public void edit(int index,String newTodo){
        if (index >= 0 && index <todos.size()) {
            todos.set(index,newTodo);
        }
    }
    public void add(int index,String todo){
        if (index <0 || index>todos.size()) {
            todos.add(todo);
        }else{
            todos.add(index,todo);
        }
    }

    public void delete(int index){
        if (index >=0&&index <todos.size()) {
            todos.remove(index);
        }
    }

    public void list(){
        if (todos.isEmpty()) {
            System.out.println("Список дел пустой");
        }else {
            for (int i = 0; i < todos.size(); i++) {
                System.out.println((i+1)+"."+todos.get(i));
            }
        }
    }

}