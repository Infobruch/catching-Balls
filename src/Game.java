/*
Ideen:
- Wenn der Ball den Rand trifft wird die Textur des Balls geändert
- Wenn der Ball den rand trifft wird die Textur geändert sodass die Seite die getroffen wurde rot wird
- Es wird ein Level System geben welches immer schwieriger wird indem
*/
import GLOOP.*;
public class Game {
    private GLKamera kamera;
    private GLLicht light;
    private GLHimmel sky;
    private GLTastatur key;
    private Floor floor;
    private Player player;
    private Balls[] spheres;
    private Button scoreButton;
    int timer = 0, score = 0;
    public int ballsCount = 50;

    public Game() {
        kamera = new GLKamera(1000, 1000);
        kamera.setzePosition(0, 0, 1);
        kamera.verschiebe(0, 1100, 0);
        kamera.setzeBlickpunkt(0, 10, 0);

        light = new GLLicht();
        sky = new GLHimmel("src/img/Sterne.jpg");
        key = new GLTastatur();

        scoreButton = new Button();
        scoreButton.build(0, 0, 0, 50, 25, "Score: " + score, 40, true);
        scoreButton.rotate(-90, 0, 0);
        scoreButton.setPos(0, 0, -550);

        floor = new Floor(1000, 1000);
        player = new Player(0, 0, 30, 1, floor);
        floor.getRightX();
        spheres = new Balls[ballsCount];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new Balls(spheres, i, 10, player, floor, 1);
        }
    }

    public void updateScore() {
        for (int i = 0; i < spheres.length; i++) {
            score += spheres[i].getScore();
            spheres[i].resetScore();
            scoreButton.setText("Score: " + score, 40);
        }
    }

    public void run() {
        while (!key.esc()) {
            if (timer == 100) {
                floor.resetBorders();
                timer = 0;
            }
            for (int i = 0; i < spheres.length; i++) {
                spheres[i].move();
            }
            if (key.istGedrueckt('w')) {
                player.moveUp();
            } else if (key.istGedrueckt('a')) {
                player.moveLeft();
            } else if (key.istGedrueckt('s')) {
                player.moveDown();
            } else if (key.istGedrueckt('d')) {
                player.moveRight();
            }
            Sys.warte(1);
            timer++;
            updateScore();
            if (score == ballsCount) {
                scoreButton.setPos(0, 0, 0);
                scoreButton.setTextColor(255, 215, 0);
                scoreButton.setText("You WON", 80);
                Sys.warte(1000);
                Sys.beenden();
            }
        }
    }
}