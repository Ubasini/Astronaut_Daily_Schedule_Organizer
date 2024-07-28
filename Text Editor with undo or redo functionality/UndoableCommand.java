

public interface UndoableCommand extends Command {
    void undo();
    void redo();
}
