
import java.time.DayOfWeek;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//program MainClass
public class TravelMate {
    private static Map<String, User> map = new HashMap<String, User>();
    private static Map<String,PlanningJourney> m=new HashMap<>();
    private static int failedcount = 0;
    private static final int loginattempts = 5;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //to display the company logo
        companyLogo();
        //to display menu options
        menuOptions();
        while(true) {
            System.out.println("enter the choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1.User registration");
                    UserRegistration(sc);
                    break;
                case 2:
                    System.out.println("2.Lock account");
                    for (int i = 0; i < loginattempts; i++) {
                        boolean isloggedin = login();
                        if (isloggedin == true) {
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("3.Plan journey");
                    Journey(sc);
                    break;
                case 4:
                    System.out.println("enter the source so you want to reschedule the journey");
                    rescheduleJourney();
                    break;
                case 5:
                    System.out.println("do you want to perform any other operations press 1/0");
                    int a = sc.nextInt();
                    if (a == 1) {
                        System.out.println("the operators you can perform");
                        companyLogo();
                        menuOptions();
                    } else {
                        System.exit(0);
                    }
                    break;

                default:
                    System.out.println("enter the valid choice");
            }
            //System.out.println("_____");
        }
    }

    private static void companyLogo() {
        System.out.println("***display the company logo***");
    }

    private static void menuOptions() {
        System.out.println("***showing the menu options of the company***");
        System.out.println("1.User Registration");
        System.out.println("2.Login");
        System.out.println("3.plan journey");
        System.out.println("4.rescheduleJourney");
        System.out.println("5.exiting");
    }

    private static void UserRegistration(Scanner sc) {
        System.out.println("enter the firstname");
        String firstname = sc.next();
        System.out.println("enter the lastname");
        String lastname = sc.next();
        System.out.println("enter the mobile number");
        int mobilenumber = sc.nextInt();
        System.out.println("enter the emailid");
        String emailId = sc.next();
        System.out.println("enter the gender ");
        String gender = sc.next();
        System.out.println("enter the password");
        String password = sc.next();
        User u = new User(firstname, lastname, mobilenumber, emailId, gender, password);
        map.put(u.getEmailId(), u);
        System.out.println("your registration is sucessfully entered");
    }

    private static boolean m2() {
        //data to be stored in map
        User u1 = new User("bhavani", "kamutam", 1234567891, "Bhavani@123gmail.com", "female", "Bhavani_123");
        User u2 = new User("sainagadurga", "mallula", 456790009, "sai@456gmail.com", "female", "Sai_456");
        User u3 = new User("bhavana", "kadire", 345758996, "Bhavana@789gmail.com", "female", "Bhavana_789");
        User u4 = new User("litheeshwar", "kamutam", 56794003, "litheeshwar@1011gmail.com", "male", "Litheeshwar_1011");
        map.put(u1.getEmailId(), u1);
        map.put(u2.getEmailId(), u2);
        map.put(u3.getEmailId(), u3);
        map.put(u4.getEmailId(), u4);
        //System.out.println("the data is entered into the map sucessfully");
        return true;
    }

    private static boolean login() {
        boolean loggedin = false;
        //checking whether the 	Preloaded data is there or not
        if (m2()) {
            //System.out.println("the data is present in the map");
            loggedin = Userlogin();
        }
        return loggedin;

    }

    private static boolean Userlogin() {
        //this is for login account
        System.out.println("login into your account");


        System.out.println("enter the emailid");
        String emailId = sc.next();

        System.out.println("enter the password");
        String password = sc.next();

        User u1 = map.get(emailId);
        if (u1 != null && u1.getPassword().equals(password)) {
            System.out.println("**user is logged successfully**");
            System.out.println("****");
            return true;
        } else {
            failedcount++;
            System.out.println("no of attempts left: " + (loginattempts - failedcount));
            if (failedcount >= loginattempts) {

                System.out.println("**the user entered ivalid details**");
                AccountStatus(emailId);
            }
            return false;
        }
    }

    private static void AccountStatus(String emailid) {
        User u = map.get(emailid);
        if (u != null) {
            //if email is given correct then then automatically the account is going to be locked
            u.setAccountstatus("locked");
            //System.out.println("****");
        }
        System.out.println("the account is locked due to too many login attempts");

    }
    private static Boolean Journey(Scanner sc){
        System.out.println("enter the source");
        String source1=sc.next();
        System.out.println("enter the destination");
        String destination1=sc.next();
       // System.out.println("enter the date");
        LocalDate t=getdate(sc);
       // System.out.println("enter the number of passengers");
        int noofpassengers=getPassengers(sc);
        //System.out.println("enter the ticket price");
       // double ticketprice=sc.nextDouble();
        journeydata();
        //System.out.println(m.get(source));
       if(m.containsKey(source1))
       {
           System.out.println("the user can plan a journey");
       }
       else
       {
           System.out.println("the user cannot plan a journey");
       }
       System.out.println("the number of routes available :");
       Set<String> keyset=m.keySet();
       for(String k:keyset){
           System.out.println(m.get(k));
        }
        PlanningJourney p=m.get(source1);
       double bookingcost=noofpassengers*p.getTicketprice();
        System.out.println("the booking cost for the passenger is"+bookingcost);
       if(t.getDayOfWeek().equals(DayOfWeek.SUNDAY)||t.getDayOfWeek().equals(DayOfWeek.SATURDAY))
       {
           bookingcost=bookingcost+200;
           bookingcost=(bookingcost*18/100)+bookingcost;
           System.out.println("the booking cost in weekends is"+bookingcost);
       }
       System.out.println("the number of seats available in the vehicle:"+p.getNoofPassengers());
        return true;
    }
    private static boolean journeydata(){
        PlanningJourney p1=new PlanningJourney("Hyderabad","Bangalore",LocalDate.now(),500,90);
        PlanningJourney p2=new PlanningJourney("Bangalore","Mumbai",LocalDate.now(),670.89,60);
        PlanningJourney p3=new PlanningJourney("pune","mumbai",LocalDate.now(),700,40);
        PlanningJourney p4=new PlanningJourney("Mumbai","Hyderabad",LocalDate.now(),490.50,70);
        PlanningJourney p5=new PlanningJourney("chennai","hyderabad",LocalDate.parse("2024-02-25",DateTimeFormatter.ISO_LOCAL_DATE),670,60);
        m.put(p1.getSource(), p1);
        m.put(p2.getSource(), p2);
        m.put(p3.getSource(), p3);
        m.put(p4.getSource(), p4);
        m.put(p5.getSource(), p5);
        System.out.println("the data is added into the map");
        return true;
    }

    //program for the planning journey----
//program for available journey routes


    private static LocalDate getdate(Scanner sc) {
        //checking the localdate in the method
        LocalDate date = LocalDate.now();
        LocalDate edate;
        // DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-mm-dd");
        while (true) {
            System.out.println("enter the date");
            String text = sc.next();
            edate = LocalDate.parse(text);
            try {
                if (edate.isBefore(date)) {
                    System.out.println("user cannot enter the past date journey will not be planned");
                } else {
                    System.out.println("the new date is");
                    return edate;
                }
            } catch (Exception e) {
                System.out.println("the date is not in the format of yyyy-mm-dd");
            }
        }
    }

    private static int getPassengers(Scanner sc) {
        int noOfPassengers;
        while (true) {
            System.out.println("enter the number of passengers");
            noOfPassengers = Integer.parseInt(sc.next());

            try {
                if (noOfPassengers <= 0) {
                    System.out.println("the user cannot plan a journey");
                } else {
                    System.out.println("the no of passengers is:");
                    return noOfPassengers;
                }
            }
            catch (Exception e) {
                System.out.println("please enter a vaild input");
            }

        }


    }
    private static  Map rescheduleJourney()
    {
        String Source=sc.next();
        LocalDate l=LocalDate.now();
        System.out.println("enter the date you want to edit ");
        String s=sc.next();
        journeydata();
        System.out.println("the checking one:"+m.get(Source));
        PlanningJourney updatedPlanningJourney=m.get(Source);
       if(updatedPlanningJourney!=null);
        {
            updatedPlanningJourney.setDate(LocalDate.parse(s));
            m.put(updatedPlanningJourney.getSource(), updatedPlanningJourney);
            System.out.println("the journey is rescheduled according to your changes");
        }

      System.out.println("the rescheduling of your journey");
        Set<String> keyset=m.keySet();
        for(String k:keyset){
            System.out.println(m.get(k));
        }
        return m;
    }
//now the user has to book and reschedule the journey

    }


