

public class InsertTextCommand implements UndoableCommand {
    private TextEditor textEditor;
    private String text;

    public InsertTextCommand(TextEditor textEditor, String text) {
        this.textEditor = textEditor;
        this.text = text;
    }

    @Override
    public void execute() {
        textEditor.insertText(text);
    }

    @Override
    public void undo() {
        textEditor.deleteText(text.length());
    }

    @Override
    public void redo() {
        execute();
    }
}
