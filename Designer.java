public class Designer {

    static String horizontalLine( int size ) {

        String str = "", addStr = "-";

        for (int i = 0; i < size; i++) {
            str = str + addStr;
        }

        return str ;
    }

    public static String vehicleTableHeader() {
        return
            Designer.horizontalLine(80) +
            "|     MAKE     |     MODEL     |     YEAR     |     TYPE     |FUEL TYPE     |     PRICE     |     COLOR     |     PREMIUM     |" +
            Designer.horizontalLine(80);
    }

    public static void printPasAppHeader() {

        System.out.println(
            " █▀█   ▄▀█   █▀   ▄▀█   █▀█   █▀█\n" + 
            " █▀▀   █▀█   ▄█   █▀█   █▀▀   █▀▀\n" 
        );
    }

    public static void printMainMenu() {

        clearConsole();

        printPasAppHeader();
        
        horizontalLine(65);
        System.out.format("%s %s %s %25s %27s", "| ", "Commands", "|","Actions", " |\n");

        horizontalLine(65);

        String[] MENU = {
            "[ 1 ]    |  Create a new Customer Account.",
            "[ 2 ]    |  Get a policy quote and buy the policy.",
            "[ 3 ]    |  Cancel a specific policy.",
            "[ 4 ]    |  File an accident claim against a policy.",
            "[ 5 ]    |  Search for a Customer account.",
            "[ 6 ]    |  Search for and display a specific policy.",
            "[ 7 ]    |  Search for and display a specific claim.",
            "[ 0 ]    |  Exit."
        };

        for ( int i = 0; i < MENU.length; i ++ ) {
                  System.out.format( "%s %-60s %1s", "| ", MENU[i], " |\n" );
        }

        horizontalLine(65);
    }

    static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    static void pause(int milliseconds) {
        try {
                        Thread.sleep(milliseconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
    }
}

