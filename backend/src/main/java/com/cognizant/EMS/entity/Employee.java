package com.cognizant.EMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@NoArgsConstructor
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "first_name")
  private String firstName;
  @JsonIgnore
  @Transient
  private boolean hasFirstName = false;

  @Column(name = "last_name", nullable = false)
  private String lastName;
  @JsonIgnore
  @Transient
  private boolean hasLastName = false;

  @Column(name = "age")
  private int age;
  @JsonIgnore
  @Transient
  private boolean hasAge = false;

  @Column(name = "mobile_number", unique = true, nullable = false)
  private int mobileNumber;
  @JsonIgnore
  @Transient
  private boolean hasMobileNumber = false;

  @Column(name = "address")
  private String address;
  @JsonIgnore
  @Transient
  private boolean hasAddress = false;

  @Column(name = "email_id", unique = true, nullable = false)
  private String emailId;
  @Transient
  private boolean hasEmailId = false;

  @Column(name = "password", nullable = false)
  private String password;
  @JsonIgnore
  @Transient
  private boolean hasPassword = false;

  @Column(name = "join_date")
  private String joinDate;
  @JsonIgnore
  @Transient
  private boolean hasJoinDate = false;

  @Column(name = "total_leave_count")
  private int totalLeaveCount = 36;
  @JsonIgnore
  @Transient
  private boolean hasTotalLeaveCount = false;

  @Column(name = "training_slot")
  private int trainingSlot = 10;
  @JsonIgnore
  @Transient
  private boolean hasTrainingSlot = false;

  @Transient
  private String certificate;

  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private JobDepartment jobid;
  @JsonIgnore
  @Transient
  private boolean hasjobDepartment;

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false)
  private Roles roleid;
  @JsonIgnore
  @Transient
  private boolean hasRole;

  @Transient
  private double salary;

  @JsonIgnore
  @Transient
  private double deductions;

  public Long getId() {

    int leavecount = this.totalLeaveCount>0?0:this.totalLeaveCount;
    this.setSalary(Math.max(this.roleid.getSalary() - ((-Math.min(0,leavecount)) * 200), 0));
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
    this.hasFirstName = true;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
    this.hasLastName = true;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
    this.hasAge = true;
  }

  public int getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(int mobileNumber) {
    this.mobileNumber = mobileNumber;
    this.hasMobileNumber = true;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
    this.hasAddress = true;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
    this.hasEmailId = true;
  }

  public int getTotalLeaveCount() {
    return totalLeaveCount;
  }

  public void setTotalLeaveCount(int totalLeaveCount) {
    this.totalLeaveCount = totalLeaveCount;
    this.hasTotalLeaveCount = true;
  }

  public int getTrainingSlot() {
    return trainingSlot;
  }

  public void setTrainingSlot(int trainingSlot) {
    this.trainingSlot = trainingSlot;
    this.hasTrainingSlot = true;
  }

  public String getCertificate() {
    return certificate;
  }

  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }

  public JobDepartment getJobDepartment() {
    return jobid;
  }

  public void setJobDepartment(JobDepartment jobDepartment) {
    this.jobid = jobDepartment;
    this.hasjobDepartment = true;
  }

  public Roles getRoles() {
    return this.roleid;
  }

  public void setRoles(Roles roleid) {
    this.roleid = roleid;
    this.hasRole = true;
  }

  public String getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(String joinDate) {
    this.joinDate = joinDate;
    this.hasJoinDate = true;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public double getSalary() {
    return this.salary;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
    this.hasPassword=true;
  }

  public void setDeductions(double deductions) {
    this.deductions = deductions;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
        + ", mobileNumber=" + mobileNumber + ", address=" + address + ", emailId=" + emailId + ", password="
        + password + ", joinDate=" + joinDate + ", totalLeaveCount=" + totalLeaveCount + ", trainingSlot="
        + trainingSlot + ", certificate=" + certificate + ", jobid=" + jobid + ", roleid=" + roleid
        + ", salary=" + salary + "]";
  }

  /**
   * @param id
   * @param firstName
   * @param lastName
   * @param age
   * @param mobileNumber
   * @param address
   * @param emailId
   * @param totalLeaveCount
   * @param leaveCount
   * @param trainingSlot
   * @param certificate
   */
  public Employee(Long id, String firstName, String lastName, int age, int mobileNumber, String address,
      String emailId, String password, String joinDate, int totalLeaveCount, int trainingSlot, String certificate,
      JobDepartment jobid, Roles roleid, double salary) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.mobileNumber = mobileNumber;
    this.address = address;
    this.emailId = emailId;
    this.password = password;
    this.joinDate = joinDate;
    this.totalLeaveCount = totalLeaveCount;
    this.trainingSlot = trainingSlot;
    this.certificate = certificate;
    this.jobid = jobid;
    this.roleid = roleid;
    this.salary = salary;
  }

  public Employee(JobDepartment jobDepartment, Long id, String firstName, String lastName, int age,
      int mobileNumber, String address, String emailId, String password, String joinDate, int totalLeaveCount,
      int trainingSlot, String certificate, JobDepartment deptId, Roles roleid) {
    super();
    this.jobid = jobDepartment;
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.mobileNumber = mobileNumber;
    this.address = address;
    this.emailId = emailId;
    this.password = password;
    this.joinDate = joinDate;
    this.totalLeaveCount = totalLeaveCount;
    this.trainingSlot = trainingSlot;
    this.certificate = certificate;
    this.roleid = roleid;
    // this.deptId = deptId;
  }

  public void reqTrainingSlot() {
    // Request training slot logic here
    // ...
  }

  public void reqCertificate(String certificateType) {
    // Request certificate logic here
    // ...
  }

  public boolean hasFirstName() {
    return hasFirstName;
  }

  public boolean hasjobDepartment() {
    return hasjobDepartment;
  }

  public boolean hasTrainingSlot() {
    return hasTrainingSlot;
  }

  public boolean hasTotalLeaveCount() {
    return hasTotalLeaveCount;
  }

  public boolean hasJoinDate() {
    return hasJoinDate;
  }

  public boolean hasEmailId() {
    return hasEmailId;
  }

  public boolean hasAddress() {
    return hasAddress;
  }

  public boolean hasMobileNumber() {
    return hasMobileNumber;
  }

  public boolean hasAge() {
    return hasAge;
  }

  public boolean hasLastName() {
    return hasLastName;
  }

  public boolean hasPassword() {
    return hasPassword;
  }

}
