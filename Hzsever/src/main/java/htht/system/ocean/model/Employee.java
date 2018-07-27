package htht.system.ocean.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    @Id
    @Column(name = "LOGINNAME")
    private String loginname;

    @Column(name = "EMPLOYEE_NUM")
    private String employeeNum;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "EMPLOYEE_AGE")
    private BigDecimal employeeAge;

    @Column(name = "EMPLOYEE_SEXUAL")
    private String employeeSexual;

    @Column(name = "EMPLOYEE_BIRTHDAY")
    private Date employeeBirthday;

    @Column(name = "EMPLOYEE_PHONE")
    private String employeePhone;

    @Column(name = "PEOPLES_CODE")
    private String peoplesCode;

    @Column(name = "EMPLOYEE_HOMETOWN")
    private String employeeHometown;

    @Column(name = "DEPARTMENT_CODE")
    private String departmentCode;

    @Column(name = "INDENTITY_CODE")
    private String indentityCode;

    @Column(name = "EMPLOYEE_ARR_DATE")
    private Date employeeArrDate;

    @Column(name = "EMPLOYEE_WORK_DATE")
    private Date employeeWorkDate;

    @Column(name = "OCCUPATIONTITLE_CODE")
    private String occupationtitleCode;

    @Column(name = "OCCUPATIONTITLE_TIME")
    private Date occupationtitleTime;

    @Column(name = "MANAGE_DUTY_CODE")
    private String manageDutyCode;

    @Column(name = "EMPLOYEE_MANAGE_DUTY_DATE")
    private Date employeeManageDutyDate;

    @Column(name = "RECORD_CODE")
    private String recordCode;

    @Column(name = "EMPLOYEE_RECORD_DATE")
    private Date employeeRecordDate;

    @Column(name = "DEGREE_CODE")
    private String degreeCode;

    @Column(name = "EMPLOYEE_DEGREE_DATE")
    private Date employeeDegreeDate;

    @Column(name = "ISUSED")
    private Short isused;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PARENTID")
    private Short parentid;

    @Column(name = "VISITECOUNT")
    private Short visitecount;

    @Column(name = "EMP_CHECK")
    private String empCheck;

    @Column(name = "EMP_CHECKDETAIL")
    private String empCheckdetail;

    @Column(name = "PROTOCOLFILE")
    private String protocolfile;

    /**
     * @return LOGINNAME
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * @param loginname
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    /**
     * @return EMPLOYEE_NUM
     */
    public String getEmployeeNum() {
        return employeeNum;
    }

    /**
     * @param employeeNum
     */
    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    /**
     * @return EMPLOYEE_NAME
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return EMPLOYEE_AGE
     */
    public BigDecimal getEmployeeAge() {
        return employeeAge;
    }

    /**
     * @param employeeAge
     */
    public void setEmployeeAge(BigDecimal employeeAge) {
        this.employeeAge = employeeAge;
    }

    /**
     * @return EMPLOYEE_SEXUAL
     */
    public String getEmployeeSexual() {
        return employeeSexual;
    }

    /**
     * @param employeeSexual
     */
    public void setEmployeeSexual(String employeeSexual) {
        this.employeeSexual = employeeSexual;
    }

    /**
     * @return EMPLOYEE_BIRTHDAY
     */
    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    /**
     * @param employeeBirthday
     */
    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    /**
     * @return EMPLOYEE_PHONE
     */
    public String getEmployeePhone() {
        return employeePhone;
    }

    /**
     * @param employeePhone
     */
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    /**
     * @return PEOPLES_CODE
     */
    public String getPeoplesCode() {
        return peoplesCode;
    }

    /**
     * @param peoplesCode
     */
    public void setPeoplesCode(String peoplesCode) {
        this.peoplesCode = peoplesCode;
    }

    /**
     * @return EMPLOYEE_HOMETOWN
     */
    public String getEmployeeHometown() {
        return employeeHometown;
    }

    /**
     * @param employeeHometown
     */
    public void setEmployeeHometown(String employeeHometown) {
        this.employeeHometown = employeeHometown;
    }

    /**
     * @return DEPARTMENT_CODE
     */
    public String getDepartmentCode() {
        return departmentCode;
    }

    /**
     * @param departmentCode
     */
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    /**
     * @return INDENTITY_CODE
     */
    public String getIndentityCode() {
        return indentityCode;
    }

    /**
     * @param indentityCode
     */
    public void setIndentityCode(String indentityCode) {
        this.indentityCode = indentityCode;
    }

    /**
     * @return EMPLOYEE_ARR_DATE
     */
    public Date getEmployeeArrDate() {
        return employeeArrDate;
    }

    /**
     * @param employeeArrDate
     */
    public void setEmployeeArrDate(Date employeeArrDate) {
        this.employeeArrDate = employeeArrDate;
    }

    /**
     * @return EMPLOYEE_WORK_DATE
     */
    public Date getEmployeeWorkDate() {
        return employeeWorkDate;
    }

    /**
     * @param employeeWorkDate
     */
    public void setEmployeeWorkDate(Date employeeWorkDate) {
        this.employeeWorkDate = employeeWorkDate;
    }

    /**
     * @return OCCUPATIONTITLE_CODE
     */
    public String getOccupationtitleCode() {
        return occupationtitleCode;
    }

    /**
     * @param occupationtitleCode
     */
    public void setOccupationtitleCode(String occupationtitleCode) {
        this.occupationtitleCode = occupationtitleCode;
    }

    /**
     * @return OCCUPATIONTITLE_TIME
     */
    public Date getOccupationtitleTime() {
        return occupationtitleTime;
    }

    /**
     * @param occupationtitleTime
     */
    public void setOccupationtitleTime(Date occupationtitleTime) {
        this.occupationtitleTime = occupationtitleTime;
    }

    /**
     * @return MANAGE_DUTY_CODE
     */
    public String getManageDutyCode() {
        return manageDutyCode;
    }

    /**
     * @param manageDutyCode
     */
    public void setManageDutyCode(String manageDutyCode) {
        this.manageDutyCode = manageDutyCode;
    }

    /**
     * @return EMPLOYEE_MANAGE_DUTY_DATE
     */
    public Date getEmployeeManageDutyDate() {
        return employeeManageDutyDate;
    }

    /**
     * @param employeeManageDutyDate
     */
    public void setEmployeeManageDutyDate(Date employeeManageDutyDate) {
        this.employeeManageDutyDate = employeeManageDutyDate;
    }

    /**
     * @return RECORD_CODE
     */
    public String getRecordCode() {
        return recordCode;
    }

    /**
     * @param recordCode
     */
    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    /**
     * @return EMPLOYEE_RECORD_DATE
     */
    public Date getEmployeeRecordDate() {
        return employeeRecordDate;
    }

    /**
     * @param employeeRecordDate
     */
    public void setEmployeeRecordDate(Date employeeRecordDate) {
        this.employeeRecordDate = employeeRecordDate;
    }

    /**
     * @return DEGREE_CODE
     */
    public String getDegreeCode() {
        return degreeCode;
    }

    /**
     * @param degreeCode
     */
    public void setDegreeCode(String degreeCode) {
        this.degreeCode = degreeCode;
    }

    /**
     * @return EMPLOYEE_DEGREE_DATE
     */
    public Date getEmployeeDegreeDate() {
        return employeeDegreeDate;
    }

    /**
     * @param employeeDegreeDate
     */
    public void setEmployeeDegreeDate(Date employeeDegreeDate) {
        this.employeeDegreeDate = employeeDegreeDate;
    }

    /**
     * @return ISUSED
     */
    public Short getIsused() {
        return isused;
    }

    /**
     * @param isused
     */
    public void setIsused(Short isused) {
        this.isused = isused;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return PARENTID
     */
    public Short getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Short parentid) {
        this.parentid = parentid;
    }

    /**
     * @return VISITECOUNT
     */
    public Short getVisitecount() {
        return visitecount;
    }

    /**
     * @param visitecount
     */
    public void setVisitecount(Short visitecount) {
        this.visitecount = visitecount;
    }

    /**
     * @return EMP_CHECK
     */
    public String getEmpCheck() {
        return empCheck;
    }

    /**
     * @param empCheck
     */
    public void setEmpCheck(String empCheck) {
        this.empCheck = empCheck;
    }

    /**
     * @return EMP_CHECKDETAIL
     */
    public String getEmpCheckdetail() {
        return empCheckdetail;
    }

    /**
     * @param empCheckdetail
     */
    public void setEmpCheckdetail(String empCheckdetail) {
        this.empCheckdetail = empCheckdetail;
    }

    /**
     * @return PROTOCOLFILE
     */
    public String getProtocolfile() {
        return protocolfile;
    }

    /**
     * @param protocolfile
     */
    public void setProtocolfile(String protocolfile) {
        this.protocolfile = protocolfile;
    }
}