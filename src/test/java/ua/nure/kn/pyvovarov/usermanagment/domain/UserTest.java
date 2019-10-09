package ua.nure.kn.pyvovarov.usermanagment.domain;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;


public class UserTest extends TestCase {
    public static final int CURRENT_YEAR = 2019;

    //Test case # 1 if the birth day in the next month of the year
    public static final int YEAR_OF_BIRTH1 = 2000;
    public static final int MONTH_OF_BIRTH1 = Calendar.DECEMBER;
    public static final int DATE_OF_BIRTH1 = 3;
    public static final int ETALONE_AGE1 = CURRENT_YEAR - YEAR_OF_BIRTH1 - 1;

    // Test case # 2 if the birth day is today
    public static final int YEAR_OF_BIRTH2 = 1999;
    public static final int MONTH_OF_BIRTH2 = Calendar.AUGUST;
    public static final int DATE_OF_BIRTH2 = 14;
    public static final int ETALONE_AGE2 = CURRENT_YEAR - YEAR_OF_BIRTH2 ;

    // Test case # 3 if the birth day is this month but DayOfBirth later than CurrentDay
    public static final int YEAR_OF_BIRTH3 = 1998;
    public static final int MONTH_OF_BIRTH3 = Calendar.OCTOBER;
    public static final int DATE_OF_BIRTH3 = 15;
    public static final int ETALONE_AGE3 = CURRENT_YEAR - YEAR_OF_BIRTH3 -1 ;

    // Test case # 4 if the birth day is this month but DayOfBirth earlier than CurrentDay
    public static final int YEAR_OF_BIRTH4 = 2000;
    public static final int MONTH_OF_BIRTH4 = Calendar.SEPTEMBER;
    public static final int DATE_OF_BIRTH4 = 15;
    public static final int ETALONE_AGE4 = CURRENT_YEAR - YEAR_OF_BIRTH4;

    // Test case # 5 if the birthday has passed
    public static final int YEAR_OF_BIRTH5 = 1980;
    public static final int MONTH_OF_BIRTH5 = Calendar.AUGUST;
    public static final int DATE_OF_BIRTH5 = 20;
    public static final int ETALONE_AGE5 = CURRENT_YEAR - YEAR_OF_BIRTH5;

    // Test case # 6 if the person was not born and birthYear differs from currentYear
    public static final int YEAR_OF_BIRTH6 = 2050;
    public static final int MONTH_OF_BIRTH6 = Calendar.MARCH;
    public static final int DATE_OF_BIRTH6 = 10;
    public static final int ETALONE_AGE6 = -1;
  
    // Test case # 7 if the person was not born and birthYear equals to currentYear
    public static final int YEAR_OF_BIRTH7 = CURRENT_YEAR;
    public static final int MONTH_OF_BIRTH7 = Calendar.OCTOBER;
    public static final int DATE_OF_BIRTH7 = 11;
    public static final int ETALONE_AGE7 = -1;
    
    private User user;
    private Date dateOfBirth;

    public void testGetFullName() {
        user.setFirstName("John");
        user.setLastName("Doe");
        assertEquals("John Doe", user.getFullName());
    }

   
    // Test case #1
     public void testGetAge1() { 
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH1, MONTH_OF_BIRTH1, DATE_OF_BIRTH1);
        dateOfBirth = calendar.getTime();
        user.setDateOfBirth(dateOfBirth);
        assertEquals(ETALONE_AGE1, user.getAge());
    }

     // Test case #2
    public void testGetAge2() { 
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH2, MONTH_OF_BIRTH2, DATE_OF_BIRTH2);
        dateOfBirth = calendar.getTime();
        user.setDateOfBirth(dateOfBirth);
        assertEquals(ETALONE_AGE2, user.getAge());
    }

    // Test case #3
    public void testGetAge3() { 
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH3, MONTH_OF_BIRTH3, DATE_OF_BIRTH3);
        dateOfBirth = calendar.getTime();
        user.setDateOfBirth(dateOfBirth);
        assertEquals(ETALONE_AGE3, user.getAge());
    }

    // Test case #4
    public void testGetAge4() { 
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH4, MONTH_OF_BIRTH4, DATE_OF_BIRTH4);
        dateOfBirth = calendar.getTime();
        user.setDateOfBirth(dateOfBirth);
        assertEquals(ETALONE_AGE4, user.getAge());
    }

    // Test case #5
    public void testGetAge5() { 
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH5, MONTH_OF_BIRTH5, DATE_OF_BIRTH5);
        dateOfBirth = calendar.getTime();
        user.setDateOfBirth(dateOfBirth);
        assertEquals(ETALONE_AGE5, user.getAge());
    }
    
    // Test case #6
    public void testGetAge6() { 
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH6, MONTH_OF_BIRTH6, DATE_OF_BIRTH6);
        dateOfBirth = calendar.getTime();
        user.setDateOfBirth(dateOfBirth);
        assertEquals(ETALONE_AGE6, user.getAge());
    }
    
    // Test case #7
    public void testGetAge7() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR_OF_BIRTH7, MONTH_OF_BIRTH7, DATE_OF_BIRTH7);
        dateOfBirth = calendar.getTime();
        user.setDateOfBirth(dateOfBirth);
        assertEquals(ETALONE_AGE7, user.getAge());
    }
    
    protected void setUp() throws Exception {
        super.setUp();
        user = new User();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        user = new User();
    }

}