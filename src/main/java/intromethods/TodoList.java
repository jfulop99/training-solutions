package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption){
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption){
        for (Todo todo:todos) {
            if (caption.equals(todo.getCaption())){
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish){
        for (String caption:todosToFinish) {
            for (Todo todo:todos) {
                if (caption.equals(todo.getCaption())) {
                    todo.finish();
                }
            }
        }
    }

    public List<String> todosToFinish(){
        List<String> todosToFinish = new ArrayList<>();
        for (Todo todo:todos) {
            if (!todo.isFinished()){
                todosToFinish.add(todo.getCaption());
            }
        }
        return todosToFinish;
    }

    public int numberOfFinishedTodos(){
        int i = 0;
        for (Todo todo:todos) {
            if (todo.isFinished()){
                i++;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "todos=" + todos +
                '}';
    }
}
