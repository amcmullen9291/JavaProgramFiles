package anthony;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        char[][] gameBoard = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        printBoard(gameBoard);
        game.userTokenInput();

        while (true) {
            game.playerTurn(gameBoard, scanner);
            if (game.isGameFinished(gameBoard)){
                break;
            }
            printBoard(gameBoard);

            game.computerTurn(gameBoard);
            if (game.isGameFinished(gameBoard)){
                break;
            }
            printBoard(gameBoard);
        }
        scanner.close();
    }


    public boolean isGameFinished(char[][] board) {

        if (gameOver(board, userToken)) {
            printBoard(board);
            System.out.println("You wins!");
            return true;
        }

        if (gameOver(board, computerToken)) {
            printBoard(board);
            System.out.println("Sorry, the Computer wins!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("It's a tie!");
        return true;
    }


    private static boolean gameOver(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
                (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
                (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||

                (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
                (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
                (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||

                (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
                (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
            return true;
        }
        return false;
    }

    char userToken;
    char computerToken;
    private void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
//        char gamePiece = ' ';
        if (userToken == 'O') {
            computerToken = 'X';
        }else{
            computerToken = 'O';
        }
        placeMove(board, Integer.toString(computerMove), computerToken);
    }


    private static boolean isValidMove (char[][] board, String position) {
        switch(position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    private void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("Choose an available space (1-9).");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput, userToken);
    }


    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }




    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }
    public void userTokenInput(){
        Scanner input = new Scanner(System.in);
               System.out.println("Would you like to be Xs or Os?");
               String userTokenInput = input.nextLine();
               userToken = Character.toUpperCase(userTokenInput.charAt(0));
               while(!((userToken == 'X') || (userToken == 'B'))) {
                   System.out.println("Please Select either 'X' or 'O'");
                  userTokenInput = input.nextLine();
                    userToken = Character.toUpperCase(userTokenInput.charAt(0));
                    System.out.println("You Chose: " + userToken);
               }
               if(userToken == 'X'){
                   computerToken ='O';
               }else{                                   
                   computerToken = 'X';
               }
           }
}
