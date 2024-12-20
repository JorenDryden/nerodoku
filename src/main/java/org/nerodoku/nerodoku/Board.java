package org.nerodoku.nerodoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board extends ArrayList<ArrayList<Integer>> {

    private final Integer[] nullRow = {null, null, null, null, null, null, null, null, null};

    public Board() {
    }

    public boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(i) || !isValidColumn(i)) {
                return false;
            }
        }
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isValidGrid(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidRow(int row) {
        boolean[] seen = new boolean[10];
        for (Integer val : this.get(row)) {
            if (val != null && val > 0 && val <= 9) {
                if (seen[val]) return false;
                seen[val] = true;
            }
        }
        return true;
    }

    private boolean isValidColumn(int col) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 9; i++) {
            Integer val = this.get(i).get(col);
            if (val != null && val > 0 && val <= 9) {
                if (seen[val]) return false;
                seen[val] = true;
            }
        }
        return true;
    }

    private boolean isValidGrid(int startRow, int startCol) {
        boolean[] seen = new boolean[10];
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                Integer val = this.get(row).get(col);
                if (val != null && val > 0 && val <= 9) {
                    if (seen[val]) return false;
                    seen[val] = true;
                }
            }
        }
        return true;
    }

    public void generateEasy() {
        generatePuzzle(30);
    }

    public void generateMedium() {
        generatePuzzle(25);
    }

    public void generateHard() {
        generatePuzzle(20);
    }

    private void generatePuzzle(int clues) {
        clear();
        Random random = new Random();
        int count = 0;

        while (count < clues) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (this.get(row).get(col) == null) {
                int value = random.nextInt(9) + 1;
                this.get(row).set(col, value);
                if (isSolved() && isValid()) {
                    count++;
                } else {
                    this.get(row).set(col, null); // Undo if invalid
                }
            }
        }
    }

    private boolean isValid() {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(i) || !isValidColumn(i)) return false;
        }
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isValidGrid(row, col)) return false;
            }
        }
        return true;
    }

    public void printBoard() {
        int counter = 1;
        for (ArrayList<Integer> row : this) {
            System.out.print(counter +"   ");
            counter++;
            for (Integer val : row) {
                System.out.print((val == null ? "_" : val) + " ");
            }
            System.out.println();
        }
    }

    public void clear(){
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> row = new ArrayList<>(Arrays.asList(nullRow));
            this.add(row);
        }
    }
}
