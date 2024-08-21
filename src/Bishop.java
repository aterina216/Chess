public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn) && line != toLine && column != toColumn) {
            if ((chessBoard.board[toLine][toColumn] == null) || (!chessBoard.board[toLine][toColumn].getColor().equals(color))) {
                if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
                    if (line < toLine && column < toColumn) {
                        int i = line + 1;
                        int j = column + 1;
                        while (i < toLine && j < toColumn) {
                            if (chessBoard.board[i][j] != null) {
                                return false;
                            }
                            i++;
                            j++;
                        }
                    }
                    if (column < toColumn && line == toLine) {
                        for (int i = column + 1; i < toColumn; i++) {
                            if (chessBoard.board[line][i] != null) {
                                return false;
                            }
                        }
                    }
                    if (line < toLine && column > toColumn){
                        int j = column;
                        for (int i = line + 1; i < toLine; i++){
                            j--;
                            if (chessBoard.board[i][j] != null){
                                return false;
                            }
                        }
                    }
                    if (line > toLine && column > toColumn){
                        int j = column;
                        for (int i = line - 1; i > toLine; i--){
                            j--;
                            if (chessBoard.board[i][j] != null){
                                return false;
                            }
                        }
                    }
                    if (line < toLine && column < toColumn){
                        int j = column;
                        for (int i = line + 1; i < toLine; i++){
                            j++;
                            if (chessBoard.board[i][j] != null){
                                return false;
                            }
                        }
                    }
                    if (line > toLine && column < toColumn){
                        int j = column;
                        for (int i = line - 1; i > toLine; i--){
                            j++;
                            if (chessBoard.board[i][j] != null){
                                return false;
                            }
                        }
                    }
                    return true;
                } else return false;
            } else return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
