import java.util.*;
import java.io.*;

//Class for loading in game data from a text file. 
public class Load {
    String name = "";
    String shipName = "";
    int health = 1;
    String location = "";
    int missions= 0;

    public Load(){
    }

    //Method that runs the actual loading and saves everything to instance variables for the intializer's use.
    //Load is NOT protected from tampering. It responds to what SHOULD be there. If somebody wants to corrupt their save, let them.
    public void run(){
        try {
            File data = new File("SaveFile.txt");
            Scanner loader = new Scanner(data);
            name = loader.nextLine();
            shipName = loader.nextLine();
            health = loader.nextInt();
            location = loader.next();
            missions = loader.nextInt();
            loader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Code 0002 - Load Failure"); // I think this exception was prechecked somewhere but here in case.
                                                                    //Error code does not include failures resulting from file tampering or other corruption
        }
    }
    
}
