import java.util.*;

//The class responsable for handling title screen interaction and aspects of game setup
public class Title {
    Scanner sc = new Scanner(System.in); // Scanner for the whole game and the players interactions with it
    String input = "";
    Info keyInfo;
    Ship myShip;
    
    public Title(){
    }

    public void show(){
        Initializer initial = new Initializer(sc); // For use in intialization
        Tools helper = new Tools(); //A Tools object that gets passed through most game methods
        helper.clear();
        
        helper.title();


        while (!input.equals("Q") && !input.equals("q") && !input.equals("quit") && !input.equals("Quit")){ // While loop that waits for the user to say some variant of quit as that marks class end.
            input = sc.next();
            if (input.equals("S") || input.equals("s") || input.equals("start") || input.equals("Start")){ // Waits for a variant of start and begins a new game if typed
                helper.clear();
                keyInfo = initial.freshInitializer();
                myShip = new Ship(sc, keyInfo, helper);// Gives the ship class access to the scanner, info and tools objects
                myShip.run();
                helper.title(); //For if a user quits to menu
                

            } else if (input.equals("L") || input.equals("l") || input.equals("load") || input.equals("Load")){ // Waits for a variant of load and loads a save game if typed
                System.out.println("Game Loading");
                keyInfo = initial.loadInitializer();
                myShip = new Ship(sc, keyInfo, helper);// Gives the ship class access to the scanner, info and tools objects
                myShip.run();
                helper.title(); //For if a user quits to menu

            } else if (input.equals("Q") || input.equals("q") || input.equals("quit") || input.equals("Quit")){ // Friendly goodbye message that doubles as way to stop else from activating on quit
                System.out.println("Thanks for Playing");

            } else { // An else command in case user types invalid commands
                System.out.println("Command Not Understood");
            }
        }

        sc.close();
        //System.exit(0); // Dunno what this did but leaving for now in case
        
    }
}
