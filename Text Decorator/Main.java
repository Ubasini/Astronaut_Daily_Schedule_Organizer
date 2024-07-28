public class Main {
    public static void main(String[] args) {
        Text text = new PlainText("Hello, World!");

        Text boldText = new BoldTextDecorator(text);
        Text italicText = new ItalicTextDecorator(text);
        Text underlineText = new UnderlineTextDecorator(text);

        Text boldItalicText = new BoldTextDecorator(new ItalicTextDecorator(text));
        Text boldUnderlineText = new BoldTextDecorator(new UnderlineTextDecorator(text));
        Text fullDecoratedText = new BoldTextDecorator(new ItalicTextDecorator(new UnderlineTextDecorator(text)));

        System.out.println("Plain Text: " + text.format());
        System.out.println("Bold Text: " + boldText.format());
        System.out.println("Italic Text: " + italicText.format());
        System.out.println("Underline Text: " + underlineText.format());
        System.out.println("Bold & Italic Text: " + boldItalicText.format());
        System.out.println("Bold & Underline Text: " + boldUnderlineText.format());
        System.out.println("Bold, Italic & Underline Text: " + fullDecoratedText.format());
    }
}
