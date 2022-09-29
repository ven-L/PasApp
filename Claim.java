public class Claim {
    private String claimNumber;
    private String accidentDate;
    private String accidentAddress;
    private String accidentDescription;
    private String damageDescription;
    private double repairCost;
    private Policy claimedPolicy;

    //constructor
    public Claim(String claimNumber, String accidentDate, String accidentAddress, String accidentDescription, String damageDescription, double repairCost, Policy claimedPolicy) {
        this.claimNumber = claimNumber;
        this.accidentDate = accidentDate;
        this.accidentAddress = accidentAddress;
        this.accidentDescription = accidentDescription;
        this.damageDescription = damageDescription;
        this.repairCost = repairCost;
        this.claimedPolicy = claimedPolicy;
    }

    public Policy getClaimedPolicy() {
        return this.claimedPolicy;
    }

    public void setClaimedPolicy(Policy claimedPolicy) {
        this.claimedPolicy = claimedPolicy;
    }

    public String getClaimNumber() {
        return this.claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getAccidentDate() {
        return this.accidentDate;
    }

    public void setAccidentDate(String accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getAccidentAddress() {
        return this.accidentAddress;
    }

    public void setAccidentAddress(String accidentAddress) {
        this.accidentAddress = accidentAddress;
    }

    public String getAccidentDescription() {
        return this.accidentDescription;
    }

    public void setAccidentDescription(String accidentDescription) {
        this.accidentDescription = accidentDescription;
    }

    public String getDamageDescription() {
        return this.damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public double getRepairCost() {
        return this.repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    public void display(){
        System.out.println("Claim# " + getClaimNumber());
        System.out.println("\tDate of Accident :" + getAccidentDate());
        System.out.println("\tAddress of the Accident : " + getAccidentAddress());
        System.out.println("\tDescrption of Accident  : " + getAccidentDescription());
        System.out.println("\tDamage to Vehicle : " + getDamageDescription());
        System.out.println("\tRepair Cost : " + getRepairCost());
    }
}
