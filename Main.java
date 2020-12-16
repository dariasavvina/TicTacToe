package com.company;

public class Main {

    public static void main(String[] args) {
    	HandlerUserInput handlerUserInput = new HandlerUserInput();
    	handlerUserInput.userInput();
    	CellType firstPlayerGameEnity = handlerUserInput.getGameEnity();
        Game game = new Game(handlerUserInput.getSizeField(),
                firstPlayerGameEnity,
                firstPlayerGameEnity == CellType.Cross ? CellType.Zero: CellType.Cross,
                handlerUserInput.getCountWinItem());
        IPlayer firstPlayer = game.getFirstPlayer();
        IPlayer secondPlayer = game.getSecondPlayer();
        IPlayer currentPlayer = firstPlayer;
        GUI.printMap(game.getGameField().getGameField(), handlerUserInput.getSizeField());
        while(true){
            game.stepGame(currentPlayer);
            if (game.isWin(currentPlayer)){
                System.out.println("You Win");
                break;
            }
            if (game.isDraw())
            {
                System.out.println("Draw");
                break;
            }
            currentPlayer = currentPlayer == firstPlayer ? secondPlayer : firstPlayer;
        }
    }
}
