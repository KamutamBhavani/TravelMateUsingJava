

import java.util.Objects;
//program to demonstrate user class
public class User {
    private String firstname;
    private String lastname;
    private int mobilenumber;
    private String emailId;
    private String gender;
    private String password;
    private int failedcount;
    private String accountstatus;
    //generated getters and setters if we want to change the values of private fields
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getMobilenumber() {
        return mobilenumber;
    }
    public void setMobilenumber(int mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getFailedcount() {
        return failedcount;
    }
    public void setFailedcount(int failedcount) {
        this.failedcount = failedcount;
    }
    public String getAccountstatus() {
        return accountstatus;
    }
    public void setAccountstatus(String accountstatus) {
        this.accountstatus = accountstatus;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public User(String firstname, String lastname, int mobilenumber, String emailId, String gender, String password)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobilenumber = mobilenumber;
        this.emailId = emailId;
        this.gender = gender;
        this.password = password;
    }
    //generated to string method
    @Override
    public String toString() {
        return "User [firstname=" + firstname + ", lastname=" + lastname + ", mobilenumber=" + mobilenumber
                + ", emailId=" + emailId + ", gender=" + gender + ", password=" + password + ", failedcount="
                + failedcount + ", accountstatus=" + accountstatus + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(accountstatus, emailId, failedcount, firstname, gender, lastname, mobilenumber, password);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(accountstatus, other.accountstatus) && Objects.equals(emailId, other.emailId)
                && failedcount == other.failedcount && Objects.equals(firstname, other.firstname)
                && Objects.equals(gender, other.gender) && Objects.equals(lastname, other.lastname)
                && mobilenumber == other.mobilenumber && password == other.password;
    }

    //end of the User class


}

