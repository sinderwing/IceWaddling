import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

/**
 * Created by John on 17/11/2018.
 */
public class LevelGenerator {
    int startX;
    int startY;
    int finishX;
    int finishY;

    public Level generate(int difficulty) {
        //Set up grid according to difficulty
        int total;
        if (difficulty < 10) {
            total = 6;
        } else if (difficulty < 30) {
            total = 7;
        } else if (difficulty < 60) {
            total = 8;
        } else if (difficulty < 100) {
            total = 9;
        } else {
            //Maximum difficulty...
            total = 10;
        }

        Random random = new Random();
        //Set boundaries between 2xm and nx2 matrix as to not be trivial
        total -= 4;
        int n = random.nextInt(total + 1); //exclusive interval 0 --> total + 1
        int m = total - n;
        n += 2;
        m += 2;
        System.out.println("n: "+n+"\n m: "+m);

        Character grid[][] = new Character[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //Set up empty tiles
                grid[i][j] = ' ';
            }

        }

        boolean solvable = false;
        Character[] directions = null; //{'w','a','s','d'};
        Character[] nullW = {'a','s','d'};
        Character[] nullA = {'w','s','d'};
        Character[] nullS = {'w','a','d'};
        Character[] nullD = {'w','a','s'};

        //1 means part of path, 0 means has to be closed with rock
        int occupied[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                occupied[i][j] = 0;
            }
        }

        ArrayList<Coordinate> path = new ArrayList<>();
        int steps = 0;
        // Try until solvable instance has been found
        //while (!solvable) {
            //Start somewhere on the bottom row
            Coordinate prev = new Coordinate(n-1, random.nextInt(m));
            path.add(prev);
            Coordinate next = new Coordinate(prev.x, prev.y);
            //Can't immediately go down
            Character prevDir = 'w';
            while (next.x != 0) {
                next.x = prev.x;
                next.y = prev.y;
                switch (prevDir) {
                    case 'w':
                        directions = nullS;
                        break;
                    case 's':
                        directions = nullW;
                        break;
                    case 'a':
                        directions = nullD;
                        break;
                    case 'd':
                        directions = nullA;
                        break;
                }
                Character nextDir = directions[random.nextInt(3)];
                switch (nextDir) {
                    case 'w':
                        next.x--;
                        break;
                    case 's':
                        next.x++;
                        break;
                    case 'a':
                        next.y--;
                        break;
                    case 'd':
                        next.y++;
                        break;
                }
                //not illegal move
                if (!(next.x < 0 || next.x >= n || next.y < 0 || next.y >= m)) {
                    path.add(next);
                    occupied[next.x][next.y] = 1;
                    prevDir = nextDir;
                    steps++;
                    // continue
                    prev = next;
                    System.out.println("("+next.x+","+next.y+")");
                }
                //Otherwise try again
            }
        //}
        //Fill rest with rocks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (occupied[i][j] == 0) {
                    grid[i][j] = 'o';
                }
            }
        }

        System.out.println("steps: "+steps);
        //Set up start (P for penguin)
        //startY = random.nextInt(m);
        //grid[n-1][startY] = 'P';
        Coordinate p = path.get(0);
        grid[p.x][p.y] = 'P';

        //Set up finish
        //finishY = random.nextInt(m);
        //grid[0][finishY] = 'F';
        for (int i = 0; i < path.size()-1; i++) {
            System.out.println("path["+i+"]: ("+path.get(i).x+","+path.get(i).y+")");

        }
        Coordinate f = path.get(steps-1);
        /*System.out.println(f.x);
        System.out.println(f.y);*/
        grid[f.x][f.y] = 'F';

        return new Level(startY,finishY,grid, 0);
    }
}
