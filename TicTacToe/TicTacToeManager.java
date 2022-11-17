package TicTacToe;

import java.util.*;

public class TicTacToeManager {
    private Player player1,player2;
    private Board board;
    private int numPlayers;

    public static void main(String[] args) {
        TicTacToeManager game = new TicTacToeManager();
        game.startGame();
    }
    public void startGame(){
        Scanner sc = new Scanner(System.in);
        //        take player input

        player1 = takeInput(++numPlayers);
        player2= takeInput(++numPlayers);
        while (player1.getSymbol()==player2.getSymbol()){
            System.out.println("Symbol Math !! Please Re-Enter The Symbol ");
            player2.setSymbol(sc.next().charAt(0));
        }
//        create the board

        board = new Board(player1.getSymbol(),player2.getSymbol());

//        play the game;
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while (status==Board.INCOMPLETE || status==Board.INVALID)
        {
            if (player1Turn)
            {
                System.out.println("Player 1 -- "+player1.getName()+" 's Turn ");
                System.out.println("Enter x: ");
                int x = sc.nextInt();
                System.out.println("Enter y: ");
                int y = sc.nextInt();

                status  = board.move(player1.getSymbol(),x,y);
                if (status== Board.INVALID){
                    System.out.println("Please Enter Valid Move !!");
                    continue;
                }
            }
            else
            {
                System.out.println("Player 2 -- "+player2.getName()+" 's Turn ");
                System.out.println("Enter x: ");
                int x = sc.nextInt();
                System.out.println("Enter y: ");
                int y = sc.nextInt();

                status  = board.move(player2.getSymbol(),x,y);
                if (status==Board.INVALID){
                    System.out.println("Please Enter Valid Move !!");
                    continue;
                }
            }
            player1Turn =!player1Turn;
            board.print();
        }
        if (status==Board.PLAYER1WIN){
            System.out.println("Player 1 --"+player1.getName()+" Wins !!");
        }else if (status==Board.PLAYER2WIN){
            System.out.println("Player 2 --"+player2.getName()+" Wins !! ");
        }else {
            System.out.println("Game Draw !! ");
        }
    }
    private Player takeInput(int num){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter Player "+num+" name : ");
        String name = sc.nextLine();
        System.out.println("Enter Player "+num+" symbol : ");
        char symbol = sc.next().charAt(0);
        Player input=  new Player(name,symbol);
        return input;
    }
}
