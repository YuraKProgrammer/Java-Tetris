package models;

public class FigureRotator2 implements IFigureRotator{

    @Override
    public Figure rotate(Figure f) {
        boolean[][] blocks = new boolean[f.getHeight()][f.getWidth()];
        for (var x=0; x<f.getHeight(); x++){
            for (var y=0; y<f.getWidth(); y++){
                blocks[x][y]=f.getBlock(y,f.getHeight()-x-1);
            }
        }
        return new Figure(blocks);
    }
}
