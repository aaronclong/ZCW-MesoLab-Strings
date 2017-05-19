package io.github.aaronclong.stringlab;

/**
 * Created by aaronlong on 5/19/17.
 */
public class DriverLicense {
  private String lastName;
  private String firstName;
  private String licenseNumber;
  private String address;
  private String state;
  private String dateOfBirth;
  private String issuedDate;
  private String expirationDate;
  private String sex;
  private String eyes;
  private String height;
  private String organDonor;
  private String licenseClass;

  public DriverLicense lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public DriverLicense firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public DriverLicense licenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
    return this;
  }

  public DriverLicense address(String address) {
    this.address = address;
    return this;
  }

  public DriverLicense state(String state) {
    this.state = state;
    return this;
  }

  public DriverLicense dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public DriverLicense issuedDate(String issuedDate) {
    this.issuedDate = issuedDate;
    return this;
  }

  public DriverLicense expirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  public DriverLicense sex(String sex) {
    this.sex = sex;
    return this;
  }

  public DriverLicense eyes(String eyes) {
    this.eyes = eyes;
    return this;
  }

  public DriverLicense height(String height) {
    this.height = height;
    return this;
  }

  public DriverLicense organDonor(String organDonor) {
    this.organDonor = organDonor;
    return this;
  }

  public DriverLicense licenseClass(String licenseClass) {
    this.licenseClass = licenseClass;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public String getAddress() {
    return address;
  }

  public String getState() {
    return state;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String getIssuedDate() {
    return issuedDate;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public String getSex() {
    return sex;
  }

  public String getEyes() {
    return eyes;
  }

  public String getHeight() {
    return height;
  }

  public String getOrganDonor() {
    return organDonor;
  }

  public String getLicenseClass() {
    return licenseClass;
  }

  @Override
  public String toString() {
    return String.format(
            "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
            lastName, firstName, address, state, licenseNumber,
            dateOfBirth, issuedDate, expirationDate, sex,
            eyes, height, organDonor, licenseClass);
  }
}
