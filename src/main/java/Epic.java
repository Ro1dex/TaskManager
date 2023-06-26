

public class Epic extends Task {
    private final String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }
    @Override
    public boolean matches(String query) {
        for (String task : subtasks) {
            if (task.matches(query)) {
                return true;
            }
        }
        return false;
    }
}