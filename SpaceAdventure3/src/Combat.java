import java.util.*;

public class Combat {
    Scanner sc;
    Info playInfo;
    Tools helper;
    String input = "";

    private static final String EDGE = "|";
    private static final String TB_EDGE = "__________________";
    private static final String SPACER = " ";
    private static final String OFFSET = "                ";
    private static final int BOARD_SIZE = 8;
    private static final char PLAYER = 'P'; // These to might be placeholders for other symbols.
    private static final char ENEMY = 'E';

    private int pX;
    private int pY;

    private int eX;
    private int eY;

    private int eHealth;

    private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];


    public Combat(Scanner tempScan, Info tempInfo, Tools tempTools){
        sc = tempScan;
        playInfo = tempInfo;
        helper = tempTools;
        Random rando = new Random();
        pX= rando.nextInt(BOARD_SIZE);
        pY= rando.nextInt(BOARD_SIZE/2);
        pY+= BOARD_SIZE/2;
        eX= rando.nextInt(BOARD_SIZE);
        eY= rando.nextInt(BOARD_SIZE/2);

        eHealth = rando.nextInt(10)+5; //Change this later to scale with the player

        for (int i = 0; i < BOARD_SIZE; i++){
            for (int q = 0 ; q < BOARD_SIZE; q++){
                board[i][q] = '*';
            }
        }

        board[pY][pX]= PLAYER;
        board[eY][eX]= ENEMY;
    }

    private void printout(){
        System.out.print(OFFSET);
        System.out.println(TB_EDGE);
        for (int i = 0; i < BOARD_SIZE; i++){
            System.out.print(OFFSET);
            System.out.print(EDGE);
            for (int q = 0 ; q < BOARD_SIZE; q++){
                System.out.print(board[i][q]);
                System.out.print(SPACER);
            }
            System.out.println(EDGE);
        }
        System.out.print(OFFSET);
        System.out.println(TB_EDGE);
        helper.space();
        System.out.println("     Player HP: "+playInfo.getHealth()+"            Enemy HP: "+eHealth);
        helper.space();
        System.out.println("         UP                     [L]ASER");
        System.out.println("    LEFT    RIGHT");
        System.out.println("        DOWN                    [E]SCAPE");
    }

    public void play(Scanner sc){
        String input ="NULL";
        boolean validmove = false;
        while (!input.equals("quit")){ // Change this once testing done
        printout();
        input = sc.next();
        helper.clear();
        if(input.equals("up") || input.equals("Up")){
            validmove= move(0, 0);     
        } else if (input.equals("Right") || input.equals("right")){
            validmove= move(1, 0);
        } else if (input.equals("down") || input.equals("Down")){
            validmove= move(2, 0);
        } else if (input.equals("Left") || input.equals("left")){
            validmove= move(3, 0);
        } else {
            System.out.println("Command Not Understood");
        }
        }

    }

    /*
    // dir indicates a direction via numbers (Up 0, Right 1, Down 2, Left 3)
    // type indicates if its a player or an enemy moving
    */
    public boolean move(int dir, int type){
        boolean out = true;
        if (type == 0){
            if (dir == 0){
                if (pY > 0){
                    if ((pY - 1) != eY || pX != eX){
                        board[pY][pX]= '*';
                        pY--;
                        board[pY][pX]= PLAYER;
                    } else {
                        System.out.println("Movement invalid");
                        out = false;
                    }
                } else {
                    System.out.println("Movement invalid");
                    out = false;
                }

            } else if (dir == 1){
                if (pX < BOARD_SIZE-1){
                    if ((pX + 1) != eX || pY != eY){ 
                        board[pY][pX]= '*';
                        pX++;
                        board[pY][pX]= PLAYER;
                    }  else {
                        System.out.println("Movement invalid");
                        out = false;
                    }
                } else {
                    System.out.println("Movement invalid");
                    out = false;
                }
            }
            else if (dir == 2){
                if (pY  < BOARD_SIZE-1){
                    if ((pY + 1) != eY || eX != pX){
                        board[pY][pX]= '*';
                        pY++;
                        board[pY][pX]= PLAYER;
                    }  else {
                        System.out.println("Movement invalid");
                        out = false;
                    }
                } else {
                    System.out.println("Movement invalid");
                    out = false;
                }

            }
            else if (dir == 3){
                if (pX > 0){
                    if ((pX - 1) != eX || pY != eY){
                        board[pY][pX]= '*';
                        pX--;
                        board[pY][pX]= PLAYER;
                    } else {
                        System.out.println("Movement invalid");
                        out = false;
                    }
                } else {
                    System.out.println("Movement invalid");
                    out = false;
                }

            } else {
                System.out.println("Error Code 0003 - Critical Failure in Movement System : Please Reboot"); // Shouldn't appear 
            }
        } else if (type == 1){
            //stub for enemy movemnt, mostly the same as player
            if (eY > 0){
                if ((eY - 1) != pY || eX != pX){
                    board[eY][eX]= '*';
                    eY--;
                    board[eY][eX]= ENEMY;
                } else {
                    out = false;
                }
            } else {
                out = false;
            }

        } else if (dir == 1){
            if (eX < BOARD_SIZE-1){
                if ((eX + 1) != pX || pY != eY){ 
                    board[eY][eX]= '*';
                    eX++;
                    board[eY][eX]= ENEMY;
                }  else {
                    out = false;
                }
            } else {
                out = false;
            }
        }
        else if (dir == 2){
            if (eY  < BOARD_SIZE-1){
                if ((eY + 1) != pY || eX != pX){
                    board[eY][eX]= '*';
                    eY++;
                    board[eY][eX]= ENEMY;
                }  else {
                    out = false;
                }
            } else {
                out = false;
            }

        }
        else if (dir == 3){
            if (eX > 0){
                if ((eX - 1) != pX || pY != eY){
                    board[eY][eX]= '*';
                    eX--;
                    board[eY][eX]= ENEMY;
                } else {
                    out = false;
                }
            } else {
                out = false;
            }
        } else {
            System.out.println("Error Code 0003 - Critical Failure in Movement System : Please Reboot"); // Shouldn't appear 
        }
        
        return out;
    }



    //Enemy AI section (For when we get there)



}