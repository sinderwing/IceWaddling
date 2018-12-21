import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

/**
 * Created by John on 17/11/2018.
 */
public class Main {
    public static void main(String [] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        String command;
        Player penguin = new Player();
        boolean exit = false;

        ReadUnit reader = new ReadUnit();
        String[] save = reader.ReadFile("IceWaddling/resources/save.txt");

        int difficulty = Integer.parseInt(save[0]);

        printTitle();
        sc.nextLine();
        printIntro();
        sc.nextLine();

        LevelPack lp = new LevelPack();
        if (difficulty < 0 || difficulty > lp.l.length-1) {
            System.out.println("Save data corrupted. Please edit 'save.txt'");
            System.exit(1);
        }
        Level level = lp.l[difficulty];
        Character[][] backup = level.copy();
        penguin.x = level.startX;
        penguin.y = level.startY;

        level.print();

        while(!exit){
            command = sc.nextLine();
            /**
             * 0: Level continues.
             * 1: Player died.
             * 2: Player won.
             * 3: Player stepped on finish prematurely
             */
            int response = 0;
            switch (command) {
                case "w":
                    response = level.move(penguin, 'w');
                    break;
                case "s":
                    response = level.move(penguin, 's');
                    break;
                case "a":
                    response = level.move(penguin, 'a');
                    break;
                case "d":
                    response = level.move(penguin, 'd');
                    break;
                case "exit":
                    exit = true;
                    // Save data
                    FileOutputStream fileOut = new FileOutputStream("resources/save.txt");
                    String saveData = ""+difficulty;
                    fileOut.write(saveData.getBytes());
                    fileOut.close();
                    break;
                default:
                    System.out.println("Incorrect input. Try again.");
                    break;
            }
            switch (response) {
                case 1:
                    System.out.println("Oh no! Penguin fell through!");
                    System.out.println("Restarting level . . .");

                    level.reset(backup);

                    penguin.x = level.startX;
                    penguin.y = level.startY;
                    break;
                case 2:
                    // If it was last level
                    if (difficulty == lp.l.length-1) {
                        //Reset save data
                        FileOutputStream fileOut = new FileOutputStream("resources/save.txt");
                        fileOut.write("0".getBytes());
                        fileOut.close();

                        printEnding();
                        System.exit(0);
                    }

                    System.out.println("Level complete!");
                    System.out.println("Loading next level . . .");
                    difficulty++;
                    level = lp.l[difficulty];
                    backup = level.copy();
                    penguin.x = level.startX;
                    penguin.y = level.startY;
                    System.out.println("----- Level "+(difficulty+1) +" -----");
                    break;
                case 3:
                    System.out.println("You have to step on all open tiles before the (F)inish tile!");
                    System.out.println("Restarting level . . .");

                    level.reset(backup);

                    penguin.x = level.startX;
                    penguin.y = level.startY;
                    break;
            }

            level.print();
        }
    }

    public static void printTitle() {
        System.out.println(" ___                   __      __              ___     ___ __    __                  ");
        System.out.println("|   |  ____    ____   /  \\    /  \\_____     __| _/  __| _/|  |  |__|  ____     ____  ");
        System.out.println("|   |_/ ___\\ _/ __ \\  \\   \\/\\/   /\\__  \\   / __ |  / __ | |  |  |  | /    \\   / ___\\ ");
        System.out.println("|   |\\  \\___ \\  ___/   \\        /  / __ \\_/ /_/ | / /_/ | |  |__|  ||   |  \\ / /_/  >");
        System.out.println("|___| \\___  > \\___  >   \\__/\\  /  (____  /\\____ | \\____ | |____/|__||___|  / \\___  / ");
        System.out.println("          \\/      \\/         \\/        \\/      \\/      \\/                \\/ /_____/  ");
        System.out.println();
        System.out.println("                               ....,,");
        System.out.println("                             .::o::;'          .....");
        System.out.println("                            ::::::::        .::::o:::.,");
        System.out.println("                           .::' `:::        :::::::''\"");
        System.out.println("                           :::     :       ::'   `.");
        System.out.println("                          .:::     :       :'      ::");
        System.out.println("                         .:::       :     ,:       `::");
        System.out.println("                        .' :        :`. .\" :        :::");
        System.out.println("                       .' .:        :  :  .:        : :");
        System.out.println("                       : ::'        ::. :' :        : :");
        System.out.println("                       :: :         :`: :  :        :`:");
        System.out.println("                       :  :         :  ''  :        : '");
        System.out.println("                     _.---:         :___   :        :");
        System.out.println("                          :        :`   `--:        :");
        System.out.println("                           : :---: :        : :---: :`---.");
        System.out.println("                           '```  '```      '''   ''''");
        System.out.println("");
        System.out.println("                              PRESS ENTER TO START");
    }

    public static void printIntro() {
        System.out.println("Welcome to Ice Waddling! You are a little penguin trying to escape from the SCIENTISTS(!)");
        System.out.println("by traversing different chunks of thin ice. To make sure that the scientists can't follow you,");
        System.out.println("you have to step on every ice tile to crack the ice and make it untraversable. Good luck!");
        System.out.println("Rules:");
        System.out.println("    1.  You are the (P)enguin");
        System.out.println("    2.  You have to reach the (F)inish tile");
        System.out.println("    3.  You have to traverse all empty tiles before reaching the F tile");
        System.out.println("    4.  A tile with 'o' means a rock is occupying it");
        System.out.println("    5.  A tile with '~' means that the ice is cracked");
        System.out.println("    6.  You move one tile by typing a direction W, A, S or D and then pressing enter.");
        System.out.println("        Type 'Exit' to save progress and quit.");
        System.out.println("");
        System.out.println("Press Enter to begin");
    }

    public static void printEnding() throws InterruptedException {
        System.out.println("Conglaturations! [sic]");
        System.out.println("You have successfully escaped the scientists!");
        for (int i = 0; i < 31; i++) {
            switch (i) {
                case 10:
                    System.out.println("----- Credits -----");
                    break;
                case 20:
                    System.out.println("Creator: John Nilsson");
                    break;
                case 30:
                    System.out.println("THE END");
                    break;
                default:
                    System.out.println();
                    break;
            }
            // Simulate scrolling text
            Thread.sleep(550);
        }
    }
}
