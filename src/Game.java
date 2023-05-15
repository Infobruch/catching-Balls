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
    int timer = 0;
    int ballsCount = 50;

    public Game() {
        kamera = new GLEntwicklerkamera(1000, 1000);
        kamera.setzePosition(0, 0, 1);
        kamera.verschiebe(0, 1100, 0);
        kamera.setzeBlickpunkt(0, 10, 0);

        light = new GLLicht();
        sky = new GLHimmel("src/img/Sterne.jpg");
        key = new GLTastatur();

        floor = new Floor(1000, 1000);
        player = new Player(0, 0, 30,1,floor);
        floor.getRightX();
        spheres = new Balls[ballsCount];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new Balls(spheres, i, 10, player, floor, 1);
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
            if (key.istGedrueckt('w')){
                System.out.println("lool");
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
        }
    }
}

