package usantatecla.tictactoe.types;

public enum Color {

    X,
    O,
    NULL;

    public static Color get(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public static Color get(char character) {
        switch (character) {
            case 'X':
                return Color.X;
            case 'O':
                return Color.O;
            default:
                return Color.NULL;
        }
    }

    public boolean isNull() {
        return this == Color.NULL;
    }

}
