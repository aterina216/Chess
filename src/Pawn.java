public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn) && column == toColumn && line != toLine) {
            if (checkMotion(line, column, toLine, toColumn)) {
                return true;
            }
        }
        if (Math.abs(column - toColumn) == 1 && Math.abs(line - toLine) == 1) {
            return chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }
        return false;
    }

    public boolean checkMotion(int line, int column, int toLine, int toColumn) {
        if ((Math.abs(toLine - line) == 1) && column == toColumn) {
            return true;
        } else if (color.equals("White") && line == 1) {
            if (toLine - line == 2) {
                return true;
            } else return false;
        } else if (color.equals("Black") && line == 6) {
            if (line - toLine == 2) {
                return true;
            } else return false;
        } else return false;
    }

    public String getSymbol() {
        return "P";
    }
}
