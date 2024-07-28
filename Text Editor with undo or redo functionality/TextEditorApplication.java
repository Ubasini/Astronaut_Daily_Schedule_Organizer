

public class TextEditorApplication {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        UndoManager undoManager = new UndoManager();

        UndoableCommand insertCommand1 = new InsertTextCommand(editor, "Hello ");
        UndoableCommand insertCommand2 = new InsertTextCommand(editor, "World!");

        undoManager.executeCommand(insertCommand1);
        undoManager.executeCommand(insertCommand2);

        System.out.println("Text after inserts: " + editor.getText());

        undoManager.undo();
        System.out.println("Text after undo: " + editor.getText());

        undoManager.redo();
        System.out.println("Text after redo: " + editor.getText());
    }
}
