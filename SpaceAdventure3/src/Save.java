import java.io.*;

//Class that saves the game to a text file. Text file not protected against tampering.
public class Save {
    private Info keyInfo;

    //Constructor, takes in the info object that the games been using and puts it in an instance variable
    public Save(Info inInfo){
        keyInfo=inInfo;

    }

    //Classes sole method, reads the things in the info file and saves them onto a text file named "SaveFile.txt"
    public void run(){
        try {
            File save = new File("SaveFile.txt");
            PrintWriter saver = new PrintWriter(save);
            saver.println(keyInfo.getName());
            saver.println(keyInfo.getShipName());
            saver.println(keyInfo.getHealth());
            saver.println(keyInfo.getLocation());
            saver.println(keyInfo.getMissions());;
            saver.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Code 0001 - Save Failure"); // Shouldn't appear but here in case.
        }
    }
}

