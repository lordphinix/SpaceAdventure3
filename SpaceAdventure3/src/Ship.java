import java.util.*;

//Class responsble for handling interactions with the 'ship' menu. Serves as the hub class for most of game.
public class Ship {
    Scanner sc;
    String input = "";
    Info keyInfo;
    Tools helper;

    //The picture of space
    String Space1 = (" ______________________________");
    String Space2 = ("|               *              |");
    String Space3 = ("|    *                         |");
    String Space4 = ("|                        *     |");
    String Space5 = ("|               *              |");
    String Space6 = ("|         *                    |");
    String Space7 = ("|                              |");
    String Space8 = ("|                  *           |");
    String Space9 = ("|      *                  *    |");
    String Space10= (" ______________________________");

    //The picture of a planet... should get multiple types eventually
    String Planet1 = (" ______________________________");
    String Planet2 = ("|             ****             |");
    String Planet3 = ("|          **********          |");
    String Planet4 = ("|        **************        |");
    String Planet5 = ("|      ******************      |");
    String Planet6 = ("|      ******************      |");
    String Planet7 = ("|        **************        |");
    String Planet8 = ("|          **********          |");
    String Planet9 = ("|             ****             |"); 
    String Planet10= (" ______________________________");

    //Constuructor that takes in the game scanner, info and tools objects and puts them in a instance variable.
    public Ship(Scanner tempScan, Info tempInfo, Tools tempTool){
        sc = tempScan;
        keyInfo= tempInfo;
        helper = tempTool;
    }

    //Main method for the classes functionality
    public void run(){
        helper.clear();
        while (!input.equals("Q") && !input.equals("q") && !input.equals("quit") && !input.equals("Quit")){ // Another example of a while loop that waits for the quit command as it is the last one that would need reciving
            if (keyInfo.getLocation().equals("Space")){ // 
                System.out.println("                                           " + Space1);
                System.out.println("     You walk through the cold metal       " + Space2);
                System.out.println("     halls of your starship as it          " + Space3);
                System.out.println("     floats through the endless sea        " + Space4);
                System.out.println("     of the stars. It's moments like       " + Space5);
                System.out.println("     this that remind you why you          " + Space6);
                System.out.println("     took to the stars to begin with.      " + Space7);
                System.out.println("                                           " + Space8);
                System.out.println("     Despite that you really should        " + Space9);
                System.out.println("     find something to do.                 " + Space10);
                System.out.println("                                                                         ");
                System.out.println("                                                                         ");
                System.out.println("    [E]xplore                 [T]ravel                 [M]issions        ");
                System.out.println("                                                                         ");
                System.out.println("     [I]nfo                    [S]ave                    [Q]uit          ");
                System.out.println("                                                                         ");
            } else if (keyInfo.getLocation().equals(("Aukbesh"))){// repeat this for all planets
                System.out.println("                                           " + Planet1);
                System.out.println("     You orbit around the desert world     " + Planet2);
                System.out.println("     of Aukbesh. Far from 'civilized'      " + Planet3);
                System.out.println("     space Aukbesh has become a hive       " + Planet4);
                System.out.println("     for crime and vice.                   " + Planet5);
                System.out.println("                                           " + Planet6);
                System.out.println("                                           " + Planet7);
                System.out.println("                                           " + Planet8);
                System.out.println("     It would be unwise to explore         " + Planet9);
                System.out.println("     without some personal protection.     " + Planet10);
                System.out.println("                                                                         ");
                System.out.println("                                                                         ");
                System.out.println("    [E]xplore                 [T]ravel                 [M]issions        ");
                System.out.println("                                                                         ");
                System.out.println("     [I]nfo                    [S]ave                    [Q]uit          ");
                System.out.println("                                                                         ");
            } else if (keyInfo.getLocation().equals(("Placeholder for future planet name"))){// repeat this for all planets
                
            }


            System.out.println("What will you do?");
            input = sc.next();

            if (input.equals("E") || input.equals("e") || input.equals("explore") || input.equals("Explore")){ // Command for leaving the ship to explore. Creates and runs a planet object
                //Exploring off the ship

            } else if (input.equals("T") || input.equals("t") || input.equals("travel") || input.equals("Travel")){ // Submenu for traveling
                //Update as planets added (Start by carrying over planets from ver 2)
                while (!input.equals("Back") && !input.equals("back")){
                    helper.clear();
                    System.out.println("Destinations:"); // Maybe make it not show destiation if you're already there...
                    System.out.println();
                    System.out.println("Aukbesh");
                    System.out.println("Space");
                    System.out.println("Back");
                    Random rando = new Random();
                    int randInt = rando.nextInt(2);
                    helper.space();
                    input = sc.next();

                    if (input.equals("Aukbesh") || input.equals("aukbesh")){
                        keyInfo.setLocation("Aukbesh");
                        if (randInt  == 1){
                            //placeholder for combat
                        }
                        input = "Back";
                    }
                }
                helper.clear();

            } else if (input.equals("M") || input.equals("m") || input.equals("missions") || input.equals("Missions")){ // Submenu for looking over current and completed missions
                //A interactive list of missions

            } else if (input.equals("I") || input.equals("i") || input.equals("info") || input.equals("Info")){ // Submenu for displaying player information
                //Update if we add new pieces of information
                while (!input.equals("Back") && !input.equals("back") && !input.equals("B") && !input.equals("b") && !input.equals("Yes") && !input.equals("yes") && !input.equals("Y") && !input.equals("y")){
                    helper.clear();
                    System.out.println("Captain Name: "+keyInfo.getName());
                    System.out.println("Ship Name: "+keyInfo.getShipName());
                    System.out.println("Ship Health: "+keyInfo.getHealth());
                    System.out.println("Ship Location: "+keyInfo.getLocation());
                    System.out.println("Mission Completion: "+keyInfo.getMissions()+"/"+ keyInfo.MAX_MISSIONS);
                    System.out.println();
                    System.out.println("Go [B]ack?");
                    input = sc.next();
                }
                helper.clear();

            } else if (input.equals("S") || input.equals("s") || input.equals("save") || input.equals("Save")){ // Saves the game 
                Save gameSave = new Save(keyInfo);
                gameSave.run();
                helper.clear();
                System.out.println("Game Saved");
                helper.space();
            } else if(input.equals("Q") && input.equals("q") && input.equals("quit") && input.equals("Quit")){ // To stop the else from activating

            } else {
                helper.clear();
                System.out.println("Invalid Command");
                helper.space();
            }        
        }
        helper.clear();
    }

}
