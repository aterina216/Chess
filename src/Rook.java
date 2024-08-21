public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(toLine) && checkPosition(column) && checkPosition(toColumn)) {
            if (((line == toLine && column != toColumn) || (line != toLine && column == toColumn)) &&
                    ((chessBoard.board[toLine][toColumn] == null) || (!chessBoard.board[toLine][toColumn].getColor().equals(color)))) {
                if (line > toLine && column == toColumn) {
                    for (int i = line - 1; i > toLine; i--) {
                        if (chessBoard.board[i][column] != null) {
                            return false;
                        }
                    }
                }
                if (line < toLine && column == toColumn) {
                    for (int i = line + 1; i < toLine; i++) {
                        if (chessBoard.board[i][column] != null) {
                            return false;
                        }
                    }
                }
                if (column > toColumn && line == toLine) {
                    for (int i = column - 1; i > toColumn; i--) {
                        if (chessBoard.board[line][i] != null) {
                            return false;
                        }
                    }
                }
                if (column < toColumn && line == toLine) {
                    for (int i = column + 1; i < toColumn; i++) {
                        if (chessBoard.board[line][i] != null) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}