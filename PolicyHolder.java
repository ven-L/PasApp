public class PolicyHolder {
    
    //instance variable
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String Address;
    private String licenseNumber;
    private String dateOfIssuance;

    //constructor
    public PolicyHolder(String firstName, String lastName, String dateOfBirth, String Address, String licenseNumber, String dateOfIssuance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.Address = Address;
        this.licenseNumber = licenseNumber;
        this.dateOfIssuance = dateOfIssuance;
    }
      
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDateOfIssuance() {
        return this.dateOfIssuance;
    }

    public void setDateOfIssuance(String dateOfIssuance) {
        this.dateOfIssuance = dateOfIssuance;
    }
    
    public void display() {
      
    }
}
