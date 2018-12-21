/**
 * Created by John on 17/11/2018.
 *
 * ~ means cracked ice
 * o means rock
 */
public class Level {
    int n;
    int m;
    int startX;
    int startY;
    int finishX;
    int finishY;
    int tiles;
    int rocks;
    int cracked;
    Character grid[][];

    public Level(int sY, int fY, Character grid[][], int rocks) {
        startX = grid.length-1; //always start from the bottom
        startY = sY;
        finishX = 0;            //always finish at the top
        finishY = fY;
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        tiles = n * m - 1;
        this.rocks = rocks;
        cracked += rocks;
    }

    public Character[][] copy() {
        Character copy[][] = new Character[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //Deep copy
                copy[i][j] = grid[i][j];
            }
        }

        return copy;
    }

    public void reset(Character backup[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //Deep copy
                grid[i][j] = backup[i][j];
            }
        }
        cracked = rocks;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("-");
        for (int i = 0; i < m; i++) {
            sb.append("----");
        }
        String line = sb.toString();
        System.out.println(line);
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
            System.out.println(line);

        }
    }

    /**
     * @param p Player to move
     * @return boolean player surviving move
     */
    public int move(Player p, Character direction) {
        int x = 0;
        int y = 0;
        switch (direction) {
            case 'w':
                x = p.x -1;
                y = p.y;
                break;
            case 's':
                x = p.x +1;
                y = p.y;
                break;
            case 'a':
                x = p.x;
                y = p.y -1;
                break;
            case 'd':
                x = p.x;
                y = p.y +1;
        }
        try {
            if (checkDeath(x, y)) {
                return 1;
            } else if (checkRock(x,y)) {
                return 0;
            }
            boolean f = (grid[x][y] == 'F');
            grid[x][y] = 'P';
            grid[p.x][p.y] = '~';
            //one tile closer to completing the level
            cracked++;
            p.move(direction);
            //System.out.println("tiles: "+tiles);
            //System.out.println("cracked: "+cracked);

            if (checkWin(x, y)) {
                return 2;
            } else if (f) {
                return 3;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            //play 'thud' sound effect
        }
        return 0;
    }

    public boolean checkDeath(int x, int y) {
        boolean restart = false;
        if (grid[x][y] == '~') {
            restart = true;
        }

        return restart;
    }

    public boolean checkRock(int x, int y) {
        boolean rock = false;

        if (grid[x][y] == 'o') {
            rock = true;
        }

        return rock;
    }

    public boolean checkWin(int x, int y) {
        boolean win = false;
        if (cracked == tiles && x == finishX && y == finishY) {
            win = true;
        }

        return win;
    }
}
