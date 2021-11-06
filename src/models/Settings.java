package models;

import java.awt.*;

public class Settings {
    public double getTimerDuration() {
        return timerDuration;
    }

    public void setTimerDuration(double timerDuration) {
        this.timerDuration = timerDuration;
    }

    private double timerDuration = 1;

    public Color getBlockColor() {
        return blockColor;
    }

    public void setBlockColor(Color blockColor) {
        this.blockColor = blockColor;
    }

    private Color blockColor = Color.GRAY;

    public Color getFigureColor() {
        return figureColor;
    }

    public void setFigureColor(Color figureColor) {
        this.figureColor = figureColor;
    }

    private Color figureColor = Color.LIGHT_GRAY;

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    private Color backgroundColor = Color.BLACK;
}
