
public class DeleteTextCommand implements UndoableCommand {
    private TextEditor textEditor;
    private String deletedText;

    public DeleteTextCommand(TextEditor textEditor, int length) {
        this.textEditor = textEditor;
        this.deletedText = textEditor.getText().substring(textEditor.getText().length() - length);
    }

    @Override
    public void execute() {
        textEditor.deleteText(deletedText.length());
    }

    @Override
    public void undo() {
        textEditor.insertText(deletedText);
    }

    @Override
    public void redo() {
        execute();
    }
}
