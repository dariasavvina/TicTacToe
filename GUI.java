package com.company;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GUI {
    static public void printMap(CellType[][] maps, int size){
        System.out.print("  ");
        for (int i = 0; i < size; i++)
            System.out.print(i + " ");
        //IntStream.rangeClosed(1, size).forEach(System.out::print);
        System.out.println();
        System.out.print(" -");
        for (int k = 0; k < size; k++)
            System.out.print("--");
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i);
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(printCell(maps[i][j]));
                System.out.print("|");
            }
            System.out.println();
            System.out.print(" -");
            for (int k = 0; k < size; k++)
                System.out.print("--");
            System.out.println();
        }
    }

    static private String printCell(CellType cell){
        return cell == CellType.Cross ? "+" : cell == CellType.Zero ? "0" : " ";
    }
}
