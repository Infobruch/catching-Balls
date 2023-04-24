/*
Ideen:
- Wenn der Ball den Rand trifft wird die Textur des Balls geändert
- Wenn der Ball den rand trifft wird die Textur geändert sodass die Seite die getroffen wurde rot wird
- Es wird ein Level System geben welches immer schwieriger wird indem
*/

import GLOOP.*;
public class Game {
    private GLKamera kamera;
    private GLLicht licht;
    private GLHimmel himmel;
    private GLTastatur tastatur;

    private Player dieBox;
    private Balls kugel1, kugel2, kugel3;

    public Game() {
        kamera = new GLKamera();
        kamera.setzePosition(0, 500, 800);

        licht = new GLLicht();
        himmel = new GLHimmel("src/img/Sterne.jpg");
        tastatur = new GLTastatur();

        Floor spielfeld = new Floor(1000, 1000);

        run();
    }

    public void run() {

    }
}

