/*package com.pulkitvyascoder.models;

import java.sql.Date;

public class Customers {
    private Integer id;
    private String customerName;
    private String customerNumber;
    private String customerEmail;
    private String it;
    private Date insertionDate;

    public Customers() {
    }

    public Customers(Integer id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public Customers(Integer id, String customerName, String customerNumber, String customerEmail, String it, Date insertionDate) {
        this.id = id;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerEmail = customerEmail;
        this.it = it;
        this.insertionDate = insertionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public Date getInsertionDate() {
        return insertionDate;
    }

    public void setInsertionDate(Date insertionDate) {
        this.insertionDate = insertionDate;
    }

    @Override
    public String toString (){
        return getId()+  " | " + getCustomerName();
    }
}
*/

package com.pulkitvyascoder.models;

public class Customers {
    private Integer id;
    private String FName;
    private String LName;
    private String Locality;
    private String Address;
    private String City;
    private String State;
    private int Pincode;
    private String Country;
    private String Phone;
    private String Email;
    private String Password;
    private String Gender;

    public Customers() {

    }

    public Customers(Integer id, String FName, String LName, String customerNumber, String customerEmail, String Locality, String Address, String City, String State, int Pincode, String Country, String Password, String Gender) {
        this.id = id;
        this.FName = FName;
        this.LName = LName;
        this.Phone = customerNumber;
        this.Email = customerEmail;
        this.Locality = Locality;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Pincode = Pincode;
        this.Country = Country;
        this.Password = Password;
        this.Gender = Gender;
    }

    public Customers(int id, String customerName) {
        this.id = id;
        this.FName = customerName;
        this.LName = " ";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomerName(String FName, String LName) {
        this.FName = FName;
        this.LName = LName;
    }

    public String getCustomerNumber() {
        return Phone;
    }

    public void setCustomerNumber(String customerNumber) {
        this.Phone = customerNumber;
    }

    public String getCustomerEmail() {
        return Email;
    }

    public void setCustomerEmail(String customerEmail) {
        this.Email = customerEmail;
    }

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }

    public String getLocality() {
        return Locality;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public Integer getPincode() {
        return Pincode;
    }

    public String getCountry() {
        return Country;
    }

    public String getPhone() {
        return Phone;
    }

    public String getPassword() {
        return Password;
    }

    public String getGender() {
        return Gender;
    }
}
