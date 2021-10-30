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

    public boolean areEquals(Figure f){
        if(f==null)
            return false;
        if(width!=f.width)
            return false;
        if(height!=f.height)
            return false;
        for(var x=0; x<width; x++){
            for(var y=0; y<height; y++){
                if(blocks[x][y]!=f.getBlock(x,y))
                    return false;
            }
        }
        return true;
    }
}
