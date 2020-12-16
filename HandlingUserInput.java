package com.company;

import java.util.Scanner;

class HandlerUserInput {

    private int sizeField;
    private boolean isComputer;
    private int countWinItem;
    private CellType gameEnity;
    private Scanner scanner;
    private static final String messageWrong = "Wrong entered data. Enter again";

    public HandlerUserInput(){
        scanner = new Scanner(System.in);
        sizeField = Settings.DEFAULT_SIZE;
        countWinItem = Settings.COUNT_WIN_ITEM;
        isComputer = false;
    }

    public void userInput(){
        System.out.println("Enter size of the playing field");
        sizeField = userInputOfSizeField();
        System.out.println("Enter the line length to win");
        countWinItem = userInputOfCountWinItems();
        //System.out.println("Do you want to play with the computer?" +
                //" If yes, then enter - Y, if with another player, then - N.");
        //isComputer = userInputOfIsComputer();
        System.out.println("Select game type: enter - Cross or Zero");
        gameEnity = userInputOfGameEnity();
    }

    public int getSizeField() {
        return sizeField;
    }

    public int getCountWinItem() {
        return countWinItem;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public CellType getGameEnity() {
        return gameEnity;
    }

    private int userInputHandlerInt(int startBorder, int endBorder){
        boolean isNotCorrect = true;
        int result = 0;
        while (isNotCorrect){
            try {
                result = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println(messageWrong);
                continue;
            }
            if (result >=startBorder && result <= endBorder)
                isNotCorrect = false;
            else
                System.out.println(messageWrong);
        }
        return result;
    }

    private int userInputOfSizeField(){
        return userInputHandlerInt(3, Settings.FIELD_SIZE_BOUNDARIES);
    }

    private int userInputOfCountWinItems(){
        return userInputHandlerInt(3, sizeField);
    }

    private boolean userInputOfIsComputer(){
        boolean isNotCorrect = true;
        String result = "";
        while (isNotCorrect){
            result = scanner.nextLine();
            if(!result.equals("Y") && !result.equals("N")){
                System.out.println(messageWrong);
                continue;
            }
            isNotCorrect = false;
        }
        return result.equals("Y");
    }

    private CellType userInputOfGameEnity(){
        boolean isNotCorrect = true;
        String result = "";
        while (isNotCorrect){
            result = scanner.nextLine();
            if(!result.equals("Cross") && !result.equals("Zero")){
                System.out.println(messageWrong);
                continue;
            }
            isNotCorrect = false;
        }
        return result.equals("Cross") ? CellType.Cross : CellType.Zero;
    }
}
