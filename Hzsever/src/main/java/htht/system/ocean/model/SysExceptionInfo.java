package htht.system.ocean.model;

import javax.persistence.*;

@Table(name = "SYS_EXCEPTION_INFO")
public class SysExceptionInfo {
    @Id
    @Column(name = "EXCEPTION_ID")
    private Short exceptionId;

    @Column(name = "ERROR_TYPE")
    private String errorType;

    @Column(name = "ERROR_STACK_INFO")
    private String errorStackInfo;

    /**
     * @return EXCEPTION_ID
     */
    public Short getExceptionId() {
        return exceptionId;
    }

    /**
     * @param exceptionId
     */
    public void setExceptionId(Short exceptionId) {
        this.exceptionId = exceptionId;
    }

    /**
     * @return ERROR_TYPE
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * @param errorType
     */
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    /**
     * @return ERROR_STACK_INFO
     */
    public String getErrorStackInfo() {
        return errorStackInfo;
    }

    /**
     * @param errorStackInfo
     */
    public void setErrorStackInfo(String errorStackInfo) {
        this.errorStackInfo = errorStackInfo;
    }
}