public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                if (checkMotion(line, column, toLine, toColumn)) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    public boolean checkMotion(int line, int column, int toLine, int toColumn) {
        if (line == toLine || column == toColumn) {
            return false;
        }
        if ((Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) || (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2)) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
