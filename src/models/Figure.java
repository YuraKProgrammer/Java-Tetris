package models;

public class Figure {
    public int getWidth() {
        return width;
    }

    private int width;

    public int getHeight() {
        return height;
    }

    private int height;

    public Figure(boolean[][] blocks){
        width=blocks.length;
        height=blocks[0].length;
        this.blocks = blocks;
    }

    public boolean getBlock(int x, int y){
        return blocks[x][y];
    }

    private boolean[][] blocks;
}
