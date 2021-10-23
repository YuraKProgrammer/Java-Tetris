package models;

import sample.Main;

import java.util.Random;

public class FigureFabric {
    private Random random = new Random();

    public Figure create(){
        var n =random.nextInt(10);
        boolean[][] blocks;
        if (n==0) { //Горизонтальная палка из 3
            blocks = new boolean[3][1];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[2][0] = true;
            return new Figure(blocks);
        }
        if (n==1) { //Вертикальная палка из 3
            blocks = new boolean[1][3];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[0][2] = true;
            return new Figure(blocks);
        }
        if (n==2) { //Квадрат 2х2
            blocks = new boolean[2][2];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            return new Figure(blocks);
        }
        if (n==3) { //Крест
            blocks = new boolean[3][3];
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[2][1] = true;
            blocks[1][2] = true;
            return new Figure(blocks);
        }
        if (n==4) {
            blocks = new boolean[2][3];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[0][1] = true;
            blocks[0][2] = true;
            return new Figure(blocks);
        }
        if (n==5) {
            blocks = new boolean[3][2];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            blocks[2][1] = true;
            return new Figure(blocks);
        }
        if (n==6) {
            blocks = new boolean[2][2];
            blocks[0][0] = true;
            blocks[1][0] = true;
            blocks[0][1] = true;
            return new Figure(blocks);
        }
        if (n==7) {
            blocks = new boolean[2][2];
            blocks[0][0] = true;
            blocks[0][1] = true;
            blocks[1][1] = true;
            return new Figure(blocks);
        }
        if (n==8) { //Вертикальная палка из 2
            blocks = new boolean[2][1];
            blocks[0][0] = true;
            blocks[1][0] = true;
            return new Figure(blocks);
        }
        if (n==9) { //Вертикальная палка из 2
            blocks = new boolean[1][2];
            blocks[0][0] = true;
            blocks[0][1] = true;
            return new Figure(blocks);
        }
        else {
            blocks = new boolean[1][1];
            return new Figure(blocks);
        }
    }
}
