package com.company;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements IPlayer {
    private CellType gameEntity;
    private List<Pair<Integer, Integer>> markedCells;
    private int indexNumber;

    public Player(CellType gameEntity){
        this.gameEntity = gameEntity;
        markedCells = new ArrayList<>();
    }

    @Override
    public CellType getGameEntity() {
        return gameEntity;
    }

    @Override
    public List<Pair<Integer, Integer>> getMarkedCells() {
        return markedCells;
    }

    @Override
    public int getSerialNumber() {
        return 0;
    }

    @Override
    public Pair<Integer, Integer> Move(int size) {
        boolean isCorrect = true;
        Scanner scanner = new Scanner(System.in);
        int firstIndex = 0;
        int secondIndex = 0;
        while(isCorrect){
            String[] input = scanner.nextLine().split(" ");
            firstIndex = Integer.parseInt(input[0]);
            secondIndex = Integer.parseInt(input[1]);
            if (input.length == 2 && Game.isCorrectEnteredIndex(firstIndex, secondIndex, size))
                isCorrect = false;
            else
                System.out.println("Enter it again:");
        }
        markedCells.add(new Pair<>(firstIndex, secondIndex));
        return markedCells.get(markedCells.size() - 1);
    }
}
