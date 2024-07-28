public class UnderlineTextDecorator extends TextDecorator {
    public UnderlineTextDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String format() {
        return "<u>" + decoratedText.format() + "</u>";
    }
}
