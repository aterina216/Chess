public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(toLine) && checkPosition(column) && checkPosition(toColumn) && checkForStartingPoint(line, column, toLine, toColumn)) {
            if (((Math.abs(line - toLine) <= 1) && Math.abs(column - toColumn) <= 1) && ((chessBoard.board[toLine][toColumn] == null) || (!chessBoard.board[toLine][toColumn].getColor().equals(color)))) {
                if (isUnderAttack(chessBoard, line, column)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean checkForStartingPoint(int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) {
            return false;
        }
        return true;
    }

    public boolean isUnderAttack(ChessBoard chessBoardboard, int line, int column) {
        if (checkPosition(line) && checkPosition(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoardboard.board[i][j] != null) {
                        if (!chessBoardboard.board[i][j].getColor().equals(color) && chessBoardboard.board[i][j].canMoveToPosition(chessBoardboard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }
}
