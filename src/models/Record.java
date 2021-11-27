package models;

import java.util.Date;

public class Record {
    private Date gameTime;
    private double score;
    private double difficulty;
    private int gameDurationSec;
    private int countOfTurns;

    /**
     * Время окончания игры
     * @return
     */
    public Date getGameTime() {
        return gameTime;
    }

    public void setGameTime(Date gameTime) {
        this.gameTime = gameTime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public int getGameDurationSec() {
        return gameDurationSec;
    }

    public void setGameDurationSec(int gameDurationSec) {
        this.gameDurationSec = gameDurationSec;
    }

    public int getCountOfTurns() {
        return countOfTurns;
    }

    public void setCountOfTurns(int countOfTurns) {
        this.countOfTurns = countOfTurns;
    }
}
