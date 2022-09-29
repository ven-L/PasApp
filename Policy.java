import java.text.DecimalFormat;
import java.util.ArrayList;

public class Policy {

  //instance variables
  private String policyNumber;
  private String effDate;
  private String expDate;
  private PolicyHolder policyHolder;
  private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
  private double policyPremium;
  private boolean claimed = false;

  //class variables
  static DecimalFormat df = new DecimalFormat("$#,##0.00");

  //class constructor
  public Policy(String policyNumber, String effDate, String expDate, PolicyHolder policyHolder) {
    this.policyNumber = policyNumber;
    this.effDate = effDate;
    this.expDate = expDate;
    this.policyHolder = policyHolder;
    this.policyPremium = 0;
  }

  public String getPolicyNumber() {
    return this.policyNumber;
  }

  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  public String getEffDate() {
    return this.effDate;
  }

  public void setEffDate(String effDate) {
    this.effDate = effDate;
  }

  public String getExpDate() {
    return this.expDate;
  }

  public void setExpDate(String expDate) {
    this.expDate = expDate;
  }

  public PolicyHolder getPolicyHolder() {
    return this.policyHolder;
  }

  public void setPolicyHolder(PolicyHolder policyHolder) {
    this.policyHolder = policyHolder;
  }

  public void setVehicleList(ArrayList<Vehicle> vehicleList) {
    this.vehicleList = vehicleList;
  }

  public ArrayList<Vehicle> getVehicleList() {
    return this.vehicleList;
  }

  public void addToVehicleList(Vehicle vehicle) {
    vehicleList.add(vehicle);
  }

  public double getPolicyPremium() {
    return this.policyPremium;
  }

  public void setPolicyPremium(double policyPremium) {
    this.policyPremium = policyPremium;
  }

  public boolean getClaimed() {
    return this.claimed;
  }

  public void setClaimed(boolean claimed) {
    this.claimed = claimed;
  }


  public String isClaimed() {

    String s = "";

    if (this.claimed == false) {
      s = "NOT CLAIMED";
    } else {
      s = "YES";
    }
    return s;
  }
  
  public void claim() {
    this.claimed = true;
  }
  

  public Double getPremium() {
    return this.policyPremium;
  }

  public void setPremium(ArrayList<Vehicle> vehicleList) {
    for (Vehicle vehicle : vehicleList) {
      this.policyPremium = this.policyPremium + vehicle.getPremium();
    }
  }

  static void displayVehicleList(ArrayList<Vehicle> vehicleList) {
    int i = 1;

    System.out.print( Designer.horizontalLine(112) );
    System.out.format( "\n%s %-2s %s %-8s %s %-8s %s %s %s %-18s %s %-8s %s %-15s %s %-10s %s %-12s %s\n","|","#","|","MAKE","|","MODEL","|","YEAR","|","TYPE","|","F-TYPE","|","PRICE","|","COLOR","|","PREMIUM","|");

    for (Vehicle v : vehicleList) {
        System.out.print( Designer.horizontalLine(112) );
        System.out.format( "\n%s %-2s %s %-8s %s %-8s %s %s %s %-18s %s %-8s %s %-15s %s %-10s %s %-12s %s\n","|",(i  + "." ),"|",v.getMake(),"|",v.getModel(),"|",v.getYear(),"|",v.getType(),"|",v.getFueltype(),"|",df.format(v.getPrice()),"|",v.getColor(),"|",df.format(v.getPremium()),"|");
        i++;
    }

    System.out.print(Designer.horizontalLine(112)  + "\n");
  }

  public void display() {
    System.out.println(
      "\nPOLICY #"  + getPolicyNumber() + 
      "\n" +
      "\n\tEFFECTIVE DATE : " + getEffDate() + 
      "\n\tEXPIRY DATE    : " + getExpDate() +
      "\n\tCLAIMED        : " + isClaimed() +
      "\n"
      );
      
      System.out.println(
        "POLICY HOLDER" +
        "\n" + 
        "\n\tFull Name      : " + getPolicyHolder().getLastName() + ", " + getPolicyHolder().getFirstName() + "\t\t\t\t\t\t\t\t\t\t    #" +
        "\n\tLicense Number : " + getPolicyHolder().getLicenseNumber() +
        "\n\tIssuance Date  : " + getPolicyHolder().getDateOfIssuance() +
        "\n\tBirth Date     : " + getPolicyHolder().getDateOfBirth() +
        "\n\tHome Address   : " + getPolicyHolder().getAddress() +
        "\n"
        );
        displayVehicleList(vehicleList);
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t" + "TOTAL PREMIUM AMOUNT :     " + df.format(getPremium()));
  }
}
