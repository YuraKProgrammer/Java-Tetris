package windows;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Figure;
import models.Game;
import models.Settings;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameWindowController {
    public static final int previewSize = 5;
    @FXML
    private ImageView _imageView;

    @FXML
    private ImageView _preview;

    @FXML
    private Text _score;

    private Graphics2D g;

    private final int blockSize = 20;

    private Scene scene;

    private Game game = new Game();

    private BufferedImage image;

    private BufferedImage preview;

    private Settings settings;

    private static BufferedImage createImage (int width, int height, Color color) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.dispose();
        return image;
    }

    public void init(Stage stage, Settings settings) {
        this.settings=settings;
        image = createImage( blockSize* game.getField().width, blockSize* game.getField().height, Color.black);
        preview = createImage( blockSize* previewSize, blockSize* previewSize, Color.black);
        redraw();
    }

    private void redraw() {
        g= image.createGraphics();
        for (var x=0; x< game.getField().width; x++){
            for (var y=0; y< game.getField().height; y++){
                drawBlock(x,y, true,Color.BLACK);
            }
        }
        for (var x=0; x< game.getField().width; x++){
            for (var y=0; y< game.getField().height; y++){
                drawBlock(x,y, game.getField().getBlock(x, y),settings.getBlockColor());
            }
        }
        drawFigure(game.getCurrentFigure());
        _imageView.setImage(SwingFXUtils.toFXImage(image, null));
    }

    private void redrawPreview() {
        g= preview.createGraphics();
        var dx = (previewSize -game.getNextFigure().getWidth())/2;
        var dy = (previewSize -game.getNextFigure().getHeight())/2;
        for (var x = 0; x< previewSize; x++){
            for (var y = 0; y< previewSize; y++){
                drawBlock(x,y, true,Color.BLACK);
            }
        }
        for(var y=0; y<game.getNextFigure().getHeight(); y++){
            for (var x=0; x<game.getNextFigure().getWidth(); x++){
                drawBlock(x+dx, y+dy, game.getNextFigure().getBlock(x,y),settings.getFigureColor());
            }
        }
        _preview.setImage(SwingFXUtils.toFXImage(preview, null));
    }

    private void drawBlock(int x, int y, boolean fill, Color color){
        if(fill) {
            g.setColor(color);
            g.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
        }
    }

    private void drawFigure(Figure figure){
        for(var y=0; y<figure.getHeight(); y++){
            for (var x=0; x<figure.getWidth(); x++){
                drawBlock(game.getFigureX()+x, game.getFigureY()+y, figure.getBlock(x,y),settings.getFigureColor());
            }
        }
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        this.scene.setOnKeyPressed(actionEvent -> {
            //  switch (actionEvent.getCode()){
            if (actionEvent.getCode()== KeyCode.RIGHT)
                if (game.moveRight())
                    redraw();
            if (actionEvent.getCode()==KeyCode.LEFT)
                if (game.moveLeft())
                    redraw();
            if (actionEvent.getCode()==KeyCode.DOWN) {
                game.moveDown();
                redraw();
            }
            if (actionEvent.getCode()==KeyCode.UP) {
                if (game.rotate())
                    redraw();
            }
        });
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(settings.getTimerDuration()),
                        ae -> {
                            game.moveDown();
                            redraw();
                            redrawPreview();
                            _score.setText(String.valueOf(game.getScore()));
                        }
                )
        );
        timeline.setDelay(Duration.seconds(settings.getTimerDuration()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
