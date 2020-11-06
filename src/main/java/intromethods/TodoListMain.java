package intromethods;

import java.util.Arrays;

public class TodoListMain {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        for (int i = 0; i < 10; i++){
            todoList.addTodo((i+1) + ".teendő");
        }
        System.out.println(todoList.todosToFinish());
        todoList.finishTodos("3.teendő");
        System.out.println(todoList.todosToFinish());
        todoList.finishAllTodos(Arrays.asList("1.teendő", "9.teendő", "10.teendő"));
        System.out.println(todoList.todosToFinish());
        System.out.println(todoList.numberOfFinishedTodos());

        Todo todo1 = new Todo("Tennivaló");
        System.out.println(todo1);
        System.out.println(todoList);
    }
}
