

public class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        text = new StringBuilder();
    }

    public void insertText(String newText) {
        text.append(newText);
    }

    public void deleteText(int length) {
        text.delete(text.length() - length, text.length());
    }

    public String getText() {
        return text.toString();
    }
}
