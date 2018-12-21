/**
 * A collection of predesigned levels
 * Created by John on 15/12/2018.
 */
public class LevelPack {
    Level l[];
    Character g[][];
    int a;
    int b;
    int n;
    int m;
    int r;
    public LevelPack() {
        l = new Level[20];

        //Level 1
        r = 0;
        n = 3;
        m = 2;
        g = grid(n,m);
        a = 0;
        b = 1;
        write(a,b);
        l[0] = new Level(a,b,g,r);

        //Level 2
        r = 0;
        n = 3;
        m = 2;
        g = grid(n,m);
        a = 0;
        b = 0;
        write(a,b);
        //Write rocks
        rock(1,0);
        l[1] = new Level(a,b,g,r);

        //Level 3
        r = 0;
        n = 3;
        m = 3;
        g = grid(n,m);
        a = 1;
        b = 2;
        write(a,b);
        //Write rocks
        rock(2,2);
        rock(0,0);
        rock(0,1);
        l[2] = new Level(a,b,g,r);

        //Level 4
        r = 0;
        n = 3;
        m = 3;
        g = grid(n,m);
        a = 0;
        b = 2;
        write(a,b);
        l[3] = new Level(a,b,g,r);

        //Level 5
        r = 0;
        n = 4;
        m = 3;
        g = grid(n,m);
        a = 0;
        b = 1;
        write(a,b);
        //Write rocks
        rock(1,2);
        rock(0,0);
        rock(0,2);
        l[4] = new Level(a,b,g,r);

        //Level 6
        r = 0;
        n = 3;
        m = 4;
        g = grid(n,m);
        a = 1;
        b = 0;
        write(a,b);
        l[5] = new Level(a,b,g,r);

        //Level 7
        r = 0;
        n = 3;
        m = 4;
        g = grid(n,m);
        a = 3;
        b = 0;
        write(a,b);
        l[6] = new Level(a,b,g,r);

        //Level 8
        r = 0;
        n = 4;
        m = 4;
        g = grid(n,m);
        a = 0;
        b = 2;
        write(a,b);
        rock(0,3);
        rock(2,2);
        l[7] = new Level(a,b,g,r);

        //Level 9
        r = 0;
        n = 4;
        m = 4;
        g = grid(n,m);
        a = 2;
        b = 3;
        write(a,b);
        rock(1,1);
        l[8] = new Level(a,b,g,r);

        //Level 10
        r = 0;
        n = 4;
        m = 4;
        g = grid(n,m);
        a = 1;
        b = 1;
        write(a,b);
        l[9] = new Level(a,b,g,r);

        //Level 11
        r = 0;
        n = 5;
        m = 4;
        g = grid(n,m);
        a = 0;
        b = 3;
        write(a,b);
        rock(0,0);
        rock(3,2);
        l[10] = new Level(a,b,g,r);

        //Level 12
        r = 0;
        n = 4;
        m = 5;
        g = grid(n,m);
        a = 2;
        b = 4;
        write(a,b);
        l[11] = new Level(a,b,g,r);

        //Level 13
        r = 0;
        n = 4;
        m = 5;
        g = grid(n,m);
        a = 1;
        b = 1;
        write(a,b);
        rock(0,0);
        rock(1,0);
        rock(1,3);
        rock(2,3);
        l[12] = new Level(a,b,g,r);

        //Level 14
        r = 0;
        n = 5;
        m = 5;
        g = grid(n,m);
        a = 2;
        b = 2;
        write(a,b);
        l[13] = new Level(a,b,g,r);

        //Level 15
        r = 0;
        n = 5;
        m = 5;
        g = grid(n,m);
        a = 0;
        b = 0;
        write(a,b);
        rock(3,0);
        rock(4,2);
        l[14] = new Level(a,b,g,r);

        //Level 16
        r = 0;
        n = 6;
        m = 5;
        g = grid(n,m);
        a = 2;
        b = 1;
        write(a,b);
        rock(3,1);
        rock(2,4);
        rock(5,4);
        l[15] = new Level(a,b,g,r);

        //Level 17
        r = 0;
        n = 6;
        m = 5;
        g = grid(n,m);
        a = 3;
        b = 1;
        write(a,b);
        rock(0,0);
        rock(1,3);
        rock(2,1);
        rock(5,4);
        l[16] = new Level(a,b,g,r);

        //Level 18
        r = 0;
        n = 6;
        m = 6;
        g = grid(n,m);
        a = 2;
        b = 1;
        write(a,b);
        rock(3,3);
        rock(4,5);
        rock(5,5);
        l[17] = new Level(a,b,g,r);

        //Level 19
        r = 0;
        n = 6;
        m = 7;
        g = grid(n,m);
        a = 3;
        b = 3;
        write(a,b);
        rock(0,0);
        rock(2,2);
        rock(3,0);
        rock(3,2);
        rock(3,4);
        rock(3,5);
        rock(4,2);
        rock(5,4);
        l[18] = new Level(a,b,g,r);

        //Level 20
        r = 0;
        n = 7;
        m = 7;
        g = grid(n,m);
        a = 3;
        b = 6;
        write(a,b);
        rock(0,2);
        rock(3,0);
        rock(3,6);
        rock(5,1);
        rock(6,4);
        l[19] = new Level(a,b,g,r);

        /*for (int i = 0; i < 20; i++) {
            l[i].print();
        }*/
    }

    private void rock(int x, int y) {
        //rocks
        r++;
        g[x][y] = 'o';
    }

    private void write(int sY, int fY) {
        g[n-1][a] = 'P';
        g[0][b] = 'F';
    }

    private Character[][] grid(int n, int m) {
        Character[][]grid = new Character[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = ' ';
            }

        }
        return grid;
    }
}
