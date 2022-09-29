import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PASapp {

  //class variable/s
  static Scanner scan = new Scanner(System.in);
  static Random r = new Random();

  static ArrayList<CustomerAccount> accountList = new ArrayList<CustomerAccount>();
  static List<Policy> policyList = new ArrayList<Policy>();
  static List<Claim> claimList = new ArrayList<Claim>();


  public static void main(String[] args) {
    
    //initTest();
    run();
  }

  static void run() {
    Designer.clearConsole();
    Designer.printPasAppHeader();
    System.out.println(Designer.horizontalLine(65));
    System.out.format(
      "%s %s %s %25s %27s",
      "| ",
      "Commands",
      "|",
      "Actions",
      " |\n"
    );
    System.out.println(Designer.horizontalLine(65));

    String[] MENU = {
      "[ 1 ]    |  Create a new Customer Account.",
      "[ 2 ]    |  Get a policy quote and buy the policy.",
      "[ 3 ]    |  Cancel a specific policy.",
      "[ 4 ]    |  File an accident claim against a policy.",
      "[ 5 ]    |  Search for a Customer account.",
      "[ 6 ]    |  Search for and display a specific policy.",
      "[ 7 ]    |  Search for and display a specific claim.",
      "[ 0 ]    |  Exit.",
    };

    for (int i = 0; i < MENU.length; i++) {
      System.out.format("%s %-60s %1s", "| ", MENU[i], " |\n");
    }

    System.out.println(Designer.horizontalLine(65));
    System.out.println();
    System.out.print("Your Action : ");
    String command = scan.nextLine();

    //System.out.println(command);
    switch (Integer.parseInt(command)) {
      case 0:
        System.exit(0);
        break;
      case 1:
        createCustomerAccount();
        break;
      case 2:
        createPolicy();
        break;
      case 3:
        cancelAPolicy();
        break;
      case 4:
        claimPolicy();
        break;
      case 5:
        searchCustomer();
        break;
      case 6:
        
        break;
      case 7:
        searchClaim();
        break;
      default:
        break;
    }
  }

  private static void searchClaim() {
    System.out.print("PAS : Enter a Claim# : ");
    String s = scan.nextLine();

    for (Claim clm : claimList) {
      if (s.equals(clm.getClaimNumber())) {
        clm.getClaimedPolicy().display();
        clm.display();
      }
    }
  }

  private static void cancelAPolicy() {

  }

  private static void searchCustomer() {
    Designer.clearConsole();

    System.out.print("PAS : Enter an Account # : ");
    String s = scan.nextLine();

    for (CustomerAccount account : accountList) {
      if (s.equals(account.getAccountNumber())) {
        account.display();
        for (Policy policy : account.getCustomerPolicyList()) {
          policy.display();
        }
      }
    }
  }

  private static void createPolicy() {
    String policyNum, effDate, expDate;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    Designer.clearConsole();
    
    System.out.print("PAS : Enter an account number of a customer : ");
    String s = scan.nextLine();

    //checks if the search query matches with any of the account numbers in accountList
    for (CustomerAccount ca : accountList) {
      if (!s.equals(ca.getAccountNumber())) {
        System.out.println("PAS : No match found for Customer #" + s);
      } else {
        //*policy creation starts here */

        Designer.clearConsole();

        policyNum = createPolicyNumber();
        System.out.println("POLICY#" + policyNum);

        //for effective date
        LocalDateTime now = LocalDateTime.now(); //gets the current date
        effDate = dtf.format(now);
        System.out.print("Effective Date : " + effDate);

        //for expiry date
        expDate = dtf.format(LocalDateTime.now().plusMonths(6)); //adds 6 months to the effective date
        System.out.print("\tExpiry Date    : " + expDate);

        System.out.println(
            "\n" +
            "\tAccount #" +
            ca.getAccountNumber() +
            "\n" +
            "\tCustomer Name : " +
            ca.getLastName() +
            "," +
            ca.getFirstName() +
            "\n" +
            "\tAddress       : " +
            ca.getAddress()
          );

        //create a policy holder
        String firstName, lastName, dateOfBirth, address, licenseNumber, dateOfIssuance;

        System.out.print("First Name : ");
        firstName = scan.nextLine();
        System.out.print("Last Name : ");
        lastName = scan.nextLine();
        System.out.print("Date Of Birth(MM/DD/YYYY) : ");
        dateOfBirth = scan.nextLine();
        System.out.print("Address : ");
        address = scan.nextLine();
        System.out.print("License Number : ");
        licenseNumber = scan.nextLine();
        System.out.print("License Issuance Date : ");
        dateOfIssuance = scan.nextLine();

        PolicyHolder ph = new PolicyHolder(
          firstName,
          lastName,
          dateOfBirth,
          address,
          licenseNumber,
          dateOfIssuance
        );

        Policy policy = new Policy(policyNum, effDate, expDate, ph);

        //assign vehicles to policy holder
        scan.reset();
        System.out.print("How many vehicles do you want to register? : ");
        int numOfVehicles = scan.nextInt();

        for (int i = 0; i < numOfVehicles; i++) {
          System.out.println("Vehicle #" + (i + 1));

          scan.nextLine();
          System.out.print("Brand : ");
          String make = scan.nextLine(); //for make
          System.out.print("Model : ");
          String model = scan.nextLine(); //for model
          System.out.print("Year(YYYY) : ");
          String year = scan.nextLine(); //for year

          //type
          String[] typeArray = {
            "4-Door sedan",
            "2-Door sports car",
            "SUV",
            "Truck",
          };
          System.out.print(
            "Type [1] 4-door sedan, [2] 2-door sports car, [3] SUV, or [4] truck : "
          );
          scan.reset();
          int t = scan.nextInt();
          String type = typeArray[t - 1];

          //fueltype
          String[] fuelTypeArray = { "Diesel", "Electric", "Petrol" };
          System.out.print(
            "Fuel Type [1] Diesel, [2] Electric, [3] Petrol, : "
          );
          scan.reset();
          int f = scan.nextInt();
          String fueltype = fuelTypeArray[f - 1];

          //price
          System.out.print("Purchase price : ");
          scan.reset();
          double price = scan.nextDouble();

          //color
          System.out.print("Color : ");
          scan.nextLine();
          String color = scan.nextLine();

          //create vehicle obj
          Vehicle vehicle = new Vehicle(
            make,
            model,
            year,
            type,
            fueltype,
            price,
            color
          );

          policy.getVehicleList().add(vehicle);
          RatingEngine re = new RatingEngine(policy);
          policy.setPolicyPremium(re.getPremium());
        }
        policy.setPremium(policy.getVehicleList());
        ca.display();
        policy.display();

        System.out.println("PAS : Would you like to purchase this policy ? [Y]es/[N]o : ");
        String b = scan.nextLine();
        if (b.equalsIgnoreCase("n")) {
          System.out.println("PAS : You did not purchased this Policy ");
          System.out.print("\nPAS : Press any key to return to the main menu...");
          run();
        } else if (b.equalsIgnoreCase("y")) {
          ca.getCustomerPolicyList().add(policy);
          System.out.println("PAS : Policy#" + policyNum + " has been bought.");
          policyList.add(policy);
          run();
        }
      }
    }
  }

  private static void createCustomerAccount() {
    String accountNumber, firstName, lastName, address;
    accountNumber = generateAccountNumber();
    boolean correct = false;

    do {
      Designer.clearConsole();

      System.out.print("First Name : ");
      scan.reset();
      firstName = scan.nextLine();

      System.out.print("Last Name  : ");
      scan.reset();
      lastName = scan.nextLine();

      System.out.print("Address    : ");
      scan.reset();
      address = scan.nextLine();

      System.out.print(
        "Account #" +
        accountNumber +
        "\nName    : " +
        lastName +
        "," +
        firstName +
        "\nAddress : " +
        address +
        "\n" +
        "\n"
      );

      System.out.print("PAS : Is the data provided correct? [Y]es/[N]o :");
      String choice = scan.nextLine();

      if (choice.equalsIgnoreCase("Y")) {
        break;
      } else if (choice.equalsIgnoreCase("N")) {}
    } while (!correct);

    CustomerAccount c = new CustomerAccount(
      accountNumber,
      firstName,
      lastName,
      address
    );
    accountList.add(c);

    Designer.clearConsole();
    System.out.println(
      "PAS : Succesfully added customer #" + c.getAccountNumber()
    );
    Designer.pause(1000);
    System.out.println("\nPAS : Press any key to continue...");
    scan.nextLine();
    Designer.clearConsole();
    run();
  }

  static String generateAccountNumber() {
    //todo : add condition that will check if this number combination already exist
    DecimalFormat df = new DecimalFormat("0000");
    String s = df.format(r.nextInt(9999));
    return s;
  }

  static String createPolicyNumber() {
    //todo : add condition that will check if this number combination already exist
    DecimalFormat df = new DecimalFormat("000000");
    String s = df.format(r.nextInt(999999));
    return s;
  }

  static  String createClaimNumber (){
    String s = "";
    DecimalFormat df = new DecimalFormat("00000");
    return s = "C" +  df.format(r.nextInt(99999));
  }

  static void claimPolicy() {

    System.out.print("PAS : Enter a Policy # : ");
    String n = scan.nextLine();

    for (CustomerAccount ca : accountList) {
      for (Policy policy : ca.getCustomerPolicyList()) {
        if (n.equals(policy.getPolicyNumber())) {
          
          System.out.print("PAS : Are you sure you want to claim Policy" + policy.getPolicyNumber() + "? [Y]es/[N]o : " );
          String c = scan.nextLine();
 
          if (c.equalsIgnoreCase("n")) {
            run();
          } else if (c.equalsIgnoreCase("y")) {

            policy.display();

            //*Claim object creations starts here */
            String  claimNum, accidentDate, accidentAddress, accidentDesc, dmgDesc;
            double cost;

            claimNum = createClaimNumber();

            System.out.print("PAS : Date of the accident(MM/DD/YYYY) : ");
            accidentDate = scan.nextLine();

            System.out.print("PAS : Location of the accident : ");
            accidentAddress = scan.nextLine();

            System.out.print("PAS ; Description of the accident : ");
            accidentDesc = scan.nextLine();

            System.out.print("PAS : Description of the damage to the vehicle : ");
            dmgDesc = scan.nextLine();

            System.out.print("PAS : Estimated cost of repair : ");
            scan.reset(); cost = scan.nextDouble();

            policy.claim();

            Claim clm = new Claim(claimNum, accidentDate, accidentAddress, accidentDesc, dmgDesc, cost, policy);
            claimList.add(clm);

            System.out.println("PAS : You Have claimed Policy#" + policy.getPolicyNumber());

            System.out.println("PAS : Press ENTER to return to the main menu ");
            scan.nextLine();
            run();
          }
        }
      }
    }
  }

  static void unitTest() {
    PolicyHolder polholder = new PolicyHolder(
      "Vannessa",
      "Lopez",
      "9/29/1998",
      "Pitogo, Makati",
      "x12fdqacxf",
      "12/12/2008"
    );
    //PolicyHolder polholder2 = new  PolicyHolder("Ryanish", "Lerbert", "4/2/2005", "Pitogo, Makati", "qrgfqvq33cxf", "12/12/2022");

    Policy policy1 = new Policy("123456", "12/29/1998", "1/15/2001", polholder);
    //Policy policy2 = new Policy("678901", "9/20/1995", "1/17/2005",polholder2);

    Vehicle v = new Vehicle(
      "toyota",
      "123",
      "2009",
      "4-doors",
      "petrol",
      1_000_000,
      "yellow"
    );
    Vehicle c = new Vehicle(
      "chev",
      "679",
      "2017",
      "2-door sports car",
      "petrol",
      2_000_000,
      "red"
    );
    Vehicle x = new Vehicle(
      "porshe",
      "vroom",
      "2022",
      "2-door sports car",
      "Deisel",
      2_000_000,
      "black"
    );

    policy1.addToVehicleList(v);
    policy1.addToVehicleList(c);
    policy1.addToVehicleList(x);
    //policy2.addToVehicleList(x);

    RatingEngine re = new RatingEngine(policy1);

    policy1.setPolicyPremium(re.getPremium());

    Designer.clearConsole();

    policy1.setPremium(policy1.getVehicleList());
    policy1.display();
    //policy2.setPremium(policy2.getVehicleList());
    //policy2.display();
    //System.out.println(policy1.print());
  }
}
