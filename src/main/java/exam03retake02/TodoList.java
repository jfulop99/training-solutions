package exam03retake02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class TodoList {

    private List<Todo> todos;

    public TodoList() {
        todos = new ArrayList<>();
    }

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public long getNumberOfItemsLeft() {
        return todos
                .stream()
                .filter(todo -> todo.getState() == State.NON_COMPLETED)
                .count();
    }

    public List<String> getMostImportantTodosText() {

        OptionalInt minPriority = todos
                .stream()
                .mapToInt(Todo::getPriority)
                .min();

        return todos
                .stream()
                .filter(p -> p.getPriority() == minPriority.getAsInt())
                .map(Todo::getText)
                .collect(Collectors.toList());
    }

    public void deleteCompleted() {

        Iterator<Todo> it = todos.iterator();
        while (it.hasNext()) {
            if (it.next().getState() == State.COMPLETED) {
                it.remove();
            }
        }

    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

}
