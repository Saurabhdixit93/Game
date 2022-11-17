package TicTacToe;

public class Board {
    private char [][] board;
    private int boardSize=  3;
    private char player1Symbol;
    private char player2Symbol;
//    count for number of cells filled

    private int count;
    private static final char EMPTY =' ';

    public static final int PLAYER1WIN = 1;
    public static final int PLAYER2WIN = 2;
    public static final int DRAW = 3;
    public static final int INCOMPLETE = 4;
    public static final int INVALID = 5;

    public Board(char player1Symbol,char player2Symbol){
        board = new char[boardSize][boardSize];
        for (int i=0;i<boardSize;i++){
            for (int j=0;j<boardSize;j++){
                board[i][j] = EMPTY;
            }
        }
        this.player1Symbol = player1Symbol;
        this.player2Symbol =player2Symbol;
    }
    public void print(){
        System.out.println("---------------");
        for (int i=0;i<boardSize;i++){
            for (int j=0;j<boardSize;j++){
                System.out.print("| "+board[i][j]+" |");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("---------------");
    }

    public int move(char symbol, int x, int y) {
        if (x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=EMPTY){
            return INVALID;
        }
        board[x][y] =symbol;
        count++;
//        Wining condition Check Row;
//        For Row
        if (board[x][0]==board[x][1] && board[x][0]==board[x][2]){
            return symbol ==player1Symbol ? PLAYER1WIN :PLAYER2WIN;
        }
//        For Column
        if (board[0][y]==board[1][y] && board[0][y]==board[2][y]){
            return  symbol==player1Symbol ? PLAYER1WIN : PLAYER2WIN;
        }
//        Diagonal Check
        if (board[0][0]!=EMPTY &&board[0][0]==board[1][1] && board[0][0]==board[2][2]){
            return symbol==player1Symbol ? PLAYER1WIN : PLAYER2WIN;
        }
        if (board[0][0]!=EMPTY && board[0][2]==board[1][1] && board[0][2]==board[2][0]){
            return symbol==player1Symbol ? PLAYER1WIN : PLAYER2WIN;
        }
        if (count==boardSize*boardSize){
            return DRAW;
        }
        return INCOMPLETE;
    }
}
