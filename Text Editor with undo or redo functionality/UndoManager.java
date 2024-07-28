
import java.util.Stack;

public class UndoManager {
    private Stack<UndoableCommand> undoStack;
    private Stack<UndoableCommand> redoStack;

    public UndoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void executeCommand(UndoableCommand command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            UndoableCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            UndoableCommand command = redoStack.pop();
            command.redo();
            undoStack.push(command);
        }
    }
}
