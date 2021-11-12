package models;

public class FigureRotator implements IFigureRotator {

    public static final int size = 5;

    @Override
    public Figure rotate(Figure f) {
        return createRotatedFigure(f);
    }

    private Figure createRotatedFigure(Figure f) {
        var cf = new boolean[size][size];
        for (var x = 0; x < f.getWidth(); x++) {
            for (var y = 0; y < f.getHeight(); y++) {
                cf[x][y] = f.getBlock(x, y);
            }
        }
        var rf = new boolean[size][size];
        for (var x = 0; x < size; x++) {
            for (var y = 0; y < size; y++) {
                rf[x][y] = cf[y][size - x - 1];
            }
        }
        for (var i=0; i<2; i++) {
            if (!rf[0][0] && !rf[0][1] && !rf[0][2]) {
                for (var x = 1; x < size; x++) {
                    for (var y = 0; y < size; y++) {
                        rf[x - 1][y] = rf[x][y];
                        if (x+1>2)
                            rf[x][y]=false;
                        else
                            rf[x][y] = rf[x+1][y];
                    }
                }
            }
            if (!rf[0][0] && !rf[1][0] && !rf[2][0]) {
                for (var x = 0; x < size; x++) {
                    for (var y = 1; y < size; y++) {
                        rf[x][y - 1] = rf[x][y];
                        if (y+1>2)
                            rf[x][y]=false;
                        else
                            rf[x][y] = rf[x][y+1];
                    }
                }
            }
        }
        var x1 = size - checkVoidY(rf);
        var y1 = size - checkVoidX(rf);
        var blocks = new boolean[x1][y1];
        for (var x = 0; x < x1; x++) {
            for (var y = 0; y < y1; y++) {
                blocks[x][y] = rf[x][y];
            }
        }
        return new Figure(blocks);
    }

    private int checkVoidX(boolean[][] figure) {
        var k = 0;
        for (var x = 0; x < size; x++) {
            for (var y = 0; y < size; y++) {
                if (!figure[y][x])
                    k++;
                else
                    k = 0;
            }
            if (k == size) {
                if (x == 0) {
                    throw new RuntimeException();
                }
                if (x == 1) {
                    return 4;
                }
                if (x == 2) {
                    return 3;
                }
                if (x == 3) {
                    return 2;
                }
                if (x == 4) {
                    return 1;
                }
            }
            if (k < size) {
                k=0;
            }
        }
        return 0;
    }

    private int checkVoidY(boolean[][] figure) {
        var k = 0;
        for (var y = 0; y < size; y++) {
            for (var x = 0; x < size; x++) {
                if (!figure[y][x])
                    k++;
                else
                    k = 0;
            }
            if (k == size) {
                if (y == 0) {
                    throw new RuntimeException();
                }
                if (y == 1) {
                    return 4;
                }
                if (y == 2) {
                    return 3;
                }
                if (y == 3) {
                    return 2;
                }
                if (y == 4) {
                    return 1;
                }
            }
            if (k < size) {
                k=0;
            }
        }
        return 0;
    }
}