/**
 * Created by John on 17/11/2018.
 */
public class Player {
    public int x;
    public int y;
    public int level;

    public Player() {
        x = 0;
        y = 0;
        level = 1;
    }

    public void move(Character direction) {
        switch (direction) {
            case 'w':
                x--;
                break;
            case 's':
                x++;
                break;
            case 'a':
                y--;
                break;
            case 'd':
                y++;
                break;
        }
    }
}
