package practice;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в список дел.Введите команду");

        while (true){
            String input = scanner.nextLine();
            String[] parts = input.split(" ",3);

            String command = parts[0].toUpperCase();

            switch (command){
                case "LIST":
                   todoList.list();
                    break;
                case "ADD":
                    if (parts.length>1) {
                        try {
                            int index = Integer.parseInt(parts[1])-1;
                            String todo = parts.length > 2 ? parts[2]:"";
                            todoList.add(index, todo);
                        }catch (NumberFormatException e){
                            String todo = parts.length>1? input.substring(4):"";
                            todoList.add(todo);
                        }
                    }
                    break;

                case "EDIT":
                    if (parts.length==3) {
                        try {
                            int index = Integer.parseInt(parts[1])-1;
                            String newTodo = parts[2];
                            todoList.edit(index,newTodo);
                        }catch (NumberFormatException e){
                            System.out.println("Некорректный номер для команды EDIT");
                        }
                    }else {
                        System.out.println("Используйте команду EDIT <номер> <новое дело>");
                    }
                    break;
                case "DELETE":
                    if (parts.length==2){
                        try {
                            int index = Integer.parseInt(parts[1])-1;
                            todoList.delete(index);
                        }catch (NumberFormatException e){
                            System.out.println("Некорректный номер для команды DELETE");
                        }
                    }else {
                        System.out.println("Используйте команду DELETE <номер>");
                    }
                    break;

                default:
                    System.out.println("Неизвестная команда.Доступные команды:LIST,ADD,EDIT,DELETE");
            }
        }
    }
}
