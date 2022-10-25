import java.util.*;

//Class for intializing the info prior to loading game proper. Automated for a loaded game but interative for a new one.
public class Initializer {
    Scanner scan;

    // Constuructor for the intializer. Takes in a prexisting scanner from the title screen.
    public Initializer(Scanner inSC){
        scan = inSC;
    }

    // Method called when intializing a new game. Asks player some questions (Name, Ship name, ETC.) then creates and returns an info class which the title class stores.
    public Info freshInitializer(){
        String inName = "";
        String inShipName = "";
        String input = "";
        scan.nextLine();
        System.out.println("Hey Captain! Before we can begin we need to get some administrative things out of the way.");
        System.out.println("First off, what is your name Captain?");
        inName = scan.nextLine();
        while (!input.equals("Yes") && !input.equals("yes")){
            System.out.println("Is '"+ inName + "' correct?");
            input = scan.nextLine();
            if (input.equals("No") || input.equals("no")){
                System.out.println("What's your name?");
                inName = scan.nextLine();
            } else if (input.equals("Yes") || input.equals("yes")){
            } else {
                System.out.println("I'm afraid I don't understand. Could you try 'Yes' or 'No'?");
            }
        }
        System.out.println("Nice to meet you Captain "+ inName + ". What will you name your ship?");
        input = "";
        inShipName = scan.nextLine();
        while (!input.equals("Yes") && !input.equals("yes")){
            System.out.println("Is '"+ inShipName + "' correct?");
            input = scan.nextLine();
            if (input.equals("No") || input.equals("no")){
                System.out.println("What will you name your ship?");
                inShipName = scan.nextLine();
            } else if (input.equals("Yes") || input.equals("yes")){
            } else {
                System.out.println("I'm afraid I don't understand. Could you try 'Yes' or 'No'?");
            }
        }
        System.out.println("Wonderful, I think that's about it.");
        System.out.println("Have fun on your adventure " + inName);
        Info keyInfo = new Info(inName, inShipName);
        return keyInfo;
    }

    //For use when loading a saved game. Creates a load object which reads in info from a text file then uses that to create and return an info object for strage by title class.
    public Info loadInitializer(){
        Load loader = new Load();
        loader.run();
        Info keyInfo = new Info(loader.name, loader.shipName, loader.health, loader.location, loader.missions);
        return keyInfo;
    }
}
