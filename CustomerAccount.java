import java.util.ArrayList;

public class CustomerAccount {
    
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String address;
    private ArrayList<Policy> customerPolicyList = new ArrayList<Policy>();
    private ArrayList<PolicyHolder> customerPolicyHolderList;

    //class constructor
    public CustomerAccount(String accountNumber, String firstName, String lastName, String address) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Policy> getCustomerPolicyList() {
        return this.customerPolicyList;
    }

    public void addToCustomerPolicyList(Policy policy) {
        this.customerPolicyList.add(policy);
    }

    public ArrayList<PolicyHolder> getCustomerPolicyHolderList() {
        return this.customerPolicyHolderList;
    }

    public void addToCustomerPolicyHolderList(PolicyHolder policyHolder) {
        this.customerPolicyHolderList.add(policyHolder);
    }

    public void display() {

        System.out.println(
            "CUSTOMER " + getAccountNumber() + " DETAILS" +
            "\n" +
            "\n\tName : " + getLastName() + "," + getFirstName() +
            "\n\tAddress : " + getAddress()
        );
        }
    }
