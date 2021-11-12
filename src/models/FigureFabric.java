package models;

import sample.Main;

import java.util.Random;

public class FigureFabric {
    private Random random = new Random();

    public Figure create(){
        var n =random.nextInt(18);
        boolean[][] blocks;
        if (n==0) {
            blocks = new boolean[2][2];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            return new Figure(blocks);
        }
        if (n==1) {
            blocks = new boolean[2][2];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            return new Figure(blocks);
        }
        if (n==2) {
            blocks = new boolean[2][3];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[0][2] = true;
            return new Figure(blocks);
        }
        if (n==3) {
            blocks = new boolean[2][3];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[1][1] = true;
            blocks[1][2] = true;
            return new Figure(blocks);
        }
        if (n==4) {
            blocks = new boolean[3][2];
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[2][1] = true;
            return new Figure(blocks);
        }
        if (n==5) {
            blocks = new boolean[3][3];
            blocks[1][0] = true;
            blocks[2][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[1][2] = true;
            return new Figure(blocks);
        }
        if (n==6) {
            blocks = new boolean[1][5];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[0][2] = true;
            blocks[0][3] = true;
            blocks[0][4] = true;
            return new Figure(blocks);
        }
        if (n==7) {
            blocks = new boolean[2][4];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[0][2] = true;
            blocks[0][3] = true;
            blocks[1][3] = true;
            return new Figure(blocks);
        }
        if (n==8) {
            blocks = new boolean[2][4];
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[0][2] = true;
            blocks[0][3] = true;
            return new Figure(blocks);
        }
        if (n==9) {
            blocks = new boolean[2][3];
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[0][2] = true;
            blocks[1][2] = true;
            return new Figure(blocks);
        }
        if (n==10) {
            blocks = new boolean[3][3];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[2][0] = true;
            blocks[1][1] = true;
            blocks[1][2] = true;
            return new Figure(blocks);
        }
        if (n==11) {
            blocks = new boolean[3][2];
            blocks[0][0] = true;
            blocks[2][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[2][1] = true;
            return new Figure(blocks);
        }
        if (n==12) {
            blocks = new boolean[3][3];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[0][2] = true;
            blocks[1][2] = true;
            blocks[2][2] = true;
            return new Figure(blocks);
        }
        if (n==13) {
            blocks = new boolean[3][3];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[1][2] = true;
            blocks[2][2] = true;
            return new Figure(blocks);
        }
        if (n==14) {
            blocks = new boolean[3][3];
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[2][1] = true;
            blocks[1][2] = true;
            return new Figure(blocks);
        }
        if (n==15) {
            blocks = new boolean[2][4];
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[1][2] = true;
            blocks[1][3] = true;
            return new Figure(blocks);
        }
        if (n==16) {
            blocks = new boolean[3][3];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[1][1] = true;
            blocks[1][2] = true;
            blocks[2][2] = true;
            return new Figure(blocks);
        }
        if (n==17) {
            blocks = new boolean[3][3];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[0][2] = true;
            blocks[1][1] = true;
            blocks[2][0] = true;
            blocks[2][1] = true;
            blocks[2][2] = true;
            return new Figure(blocks);
        }
        else {
            blocks = new boolean[1][1];
            return new Figure(blocks);
        }
    }
}
