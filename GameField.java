package com.company;

public class GameField {

    private CellType[][] gameField;
    private int size;

    public GameField(int size){
        this.size = size;
        gameField = new CellType[size][size];
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                gameField[i][j] = CellType.Empty;
    }

    public GameField(){
        this.size = Settings.DEFAULT_SIZE;
        gameField = new CellType[size][size];
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                gameField[i][j] = CellType.Empty;
    }

    public CellType[][] getGameField() {
        return gameField;
    }

    public CellType getCell(int column, int row){
        return gameField[column][row];
    }

    public void setCell(int column, int row, CellType value){
        gameField[column][row] = value;
    }

    public int getSize() {
        return size;
    }
}
