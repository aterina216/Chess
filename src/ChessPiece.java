public abstract class ChessPiece {
    final String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean checkPosition(int position) {
        if (position >= 0 && position <= 7) {
            return true;
        } else return false;
    }
}
