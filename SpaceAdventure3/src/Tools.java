
// Class containg useful 'helper' methods for use across the whole game. Mostly things that need to be repeatedly printed.
public class Tools {
    public Tools(){

    }

    // prints two lines to simulate a space between two objects
    public void space(){
        System.out.println();
        System.out.println();
    }

    //Prints a number of lines to give the impression that the screen is cleared. Wish I knew how to do an actual clear.
    public void clear(){
        for (int i = 0; i < 30; i++){
            System.out.println();
        }
    }

    //The actual title screen... needs to be printed more then once belive it or not
    public void title(){
                System.out.println("***********************************");
                System.out.println();
                System.out.println("           Thomas Bird's");
                System.out.println("          Space Adventure");
                System.out.println();
                System.out.println();
                System.out.println("              [S]tart");
                System.out.println("              [L]oad");
                System.out.println("              [Q]uit");
                System.out.println();
                System.out.println("***********************************");
    }
}
