package ua.nure.kn.pyvovarov.usermanagment.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable {


    private static final long serialVersionUID = -138019132080436045L;
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public long getAge() {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(new Date());
    	int currentYear = calendar.get(Calendar.YEAR);
    	int currentMonth = calendar.get(Calendar.MONTH);
    	int currentDay = calendar.get(Calendar.DATE);
    
    	calendar.setTime(getDateOfBirth());
    	
    	int birthYear = calendar.get(Calendar.YEAR);
    	int birthMonth = calendar.get(Calendar.MONTH);
    	int birthDay = calendar.get(Calendar.DATE);
    	long userAge = currentYear - birthYear;
    	if(userAge >= 0) {
    		if(currentMonth - birthMonth < 0) {
    			return --userAge;
    		}
    		else if (currentMonth - birthMonth == 0) {
    			if(currentDay - birthDay >= 0) {
    				return userAge;
    			}
    			else {
    				return --userAge;
    			}
    		}
    	}
    	else if(userAge < 0) {
    		return -1;
    	}
    	return userAge;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = (Date) dateOfBirth.clone();
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}