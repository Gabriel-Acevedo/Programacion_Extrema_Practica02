package lasdamastdd.models;

public class Turn {

    private Color color;

    Turn() {
        this.color = Color.WHITE;
    }

    public void change() {
        this.color = Color.values()[(this.color.ordinal() + 1) % 2];
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return this.color.name();
    }
}
