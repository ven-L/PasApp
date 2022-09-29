import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class RatingEngine {

    //instance variable 
    private double premium;

    public RatingEngine(Policy policy) {

        double vp, vpf  = 0;                                       // vehicle  purchase price and vehicle price factor.
        
        
        for (Vehicle v : policy.getVehicleList()) {
            int year = Integer.parseInt( v.getYear() );
            
            int dlx = getDlx(policy);                            //number of  years since driver license was first issued.
            vp = v.getPrice();
            
            if (  year <= 1) {
                vpf = 0.01;
            } else if (year >= 2 && year <= 3) {
                vpf = 0.008;
            } else if (year >= 4 && year <= 5) {
                vpf = 0.007;
            } else if (year >= 6 && year <= 10) {
                vpf = 0.006;
            } else if (year >= 11 && year <= 15) {
                vpf = 0.004;
            } else if (year >= 16 && year <= 20) {
                vpf = 0.002;
            } else if (year >= 21 && year <= 40) {
                vpf = 0.001;
            }

            double vehiclePremium = (vp * vpf) + ((vp / 100) / dlx);

            v.setPremium(vehiclePremium);
        }
    }

    public double getPremium() {
        return  this.premium;
    }

    static int getDlx(Policy policy) {
        String dlYear = policy.getPolicyHolder().getDateOfIssuance();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate licenseYear = LocalDate.parse(dlYear,formatters);
        Period period = Period.between(licenseYear, LocalDate.now());
        return period.getYears();
    }
}
