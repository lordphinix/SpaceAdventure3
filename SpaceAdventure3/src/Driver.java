// Thomas M. Bird - 2022

import java.util.*;//remove later
//Main Class that creates a Title Object and runs it's sole method.
public class Driver {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // rm later
        Info testInfo =new Info("test player", "test ship");
        Tools testTools = new Tools();
        Combat testCombat = new Combat(sc, testInfo, testTools);
        testCombat.play(sc);
        //end of rm
        //Title title = new Title();
        //Drivertitle.show();
    }
}
