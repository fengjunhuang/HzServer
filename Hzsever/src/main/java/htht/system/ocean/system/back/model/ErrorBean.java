package htht.system.ocean.system.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="SYS_EXCEPTION_INFO")
public class ErrorBean {
    @Id
    @Column(name = "EXCEPTION_ID")
    private Long exceptionId;
    @Column(name = "ERROR_TYPE")
    private String errorType;
    @Column(name = "ERROR_STACK_INFO")
    private String errorStackInfo;

    public Long getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(Long exceptionId) {
        this.exceptionId = exceptionId;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorStackInfo() {
        return errorStackInfo;
    }

    public void setErrorStackInfo(String errorStackInfo) {
        this.errorStackInfo = errorStackInfo;
    }

    public static ErrorBean getErrorBean(String errorType, String errorStackInfo){
        ErrorBean errorBean = new ErrorBean();
        errorBean.setErrorType(errorType);
        errorBean.setErrorStackInfo(errorStackInfo);
        return errorBean;
    }
}
