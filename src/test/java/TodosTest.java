import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.getTasks();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] exp = {epic};
        Task[] act = todos.search("Яйца");
        Assertions.assertArrayEquals(exp,act);
    }
    @Test
    public void shouldCheckMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        String exp = "Приложение НетоБанка";
        String act = meeting.getProject();
        Assertions.assertEquals(exp,act);
        String exp1 = "Выкатка 3й версии приложения";
        String act1 = meeting.getTopic();
        Assertions.assertEquals(exp1,act1);
        String exp2 = "Во вторник после обеда";
        String act2 = meeting.getStart();
        Assertions.assertEquals(exp2,act2);

    }
    @Test
    public void shouldCheckSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String exp = "Позвонить родителям";
        String act = simpleTask.getTitle();
        Assertions.assertEquals(exp,act);
        int exp1 = 5;
        int act1 = simpleTask.getId();
        Assertions.assertEquals(exp1,act1);

    }
}
