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

    private Player player;
    private Balls[] spheres;

    public Game() {
        kamera = new GLEntwicklerkamera(1000,1000);
        kamera.setzePosition(0, 0, 1);
        kamera.verschiebe(0, 1100, 0);
        kamera.setzeBlickpunkt(0, 10, 0);

        light = new GLLicht();
        sky = new GLHimmel("src/img/Sterne.jpg");
        key = new GLTastatur();

        player = new Player(100, 100);
        Floor spielfeld = new Floor(1000, 1000);

        spheres = new Balls[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new Balls();
        }
    }

    public void run() {

    }
}

