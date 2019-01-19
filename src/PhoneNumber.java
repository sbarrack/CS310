import java.util.Iterator;
import data_structures.*;

public class PhoneNumber implements Comparable<PhoneNumber> {
    String areaCode, prefix, number;
    String phoneNumber;
   
    // Constructor.  Creates a new PhoneNumber instance.  The parameter
    // is a phone number in the form xxx-xxx-xxxx, which is area code -
    // prefix - number.  The phone number must be validated, and an
    // IllegalArgumentException thrown if it is invalid.
    public PhoneNumber(String n) {
    	
    }
    
    // Follows the specifications of the Comparable Interface.  
    public int compareTo(PhoneNumber n) {
    	
    	return 0;
    }
       
    // Returns an int representing the hashCode of the PhoneNumber.
    public int hashCode() {
    	
    	return 0;
    }
   
    // Private method to validate the Phone Number.  Should be called
    // from the constructor.   
    private void verify(String n) {
    	
    }
       
    // Returns the area code of the Phone Number.
    public String getAreaCode() {
    	
    	return "";
    }
       
    // Returns the prefix of the Phone Number.
    public String getPrefix() {
    	return "";
    }
       
    // Returns the the last four digits of the number.
    public String getNumber() {
    	
    	return "";
    }

    // Returns the Phone Number.       
    public String toString() {
    
    	return "";
    }
    
}            