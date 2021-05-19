package office.management.OfficeManagement.DAO.dto;

import com.sun.istack.NotNull;

public class EmployeeUpdateDto {
    @NotNull
    private String fullName;
    @NotNull
    private String email;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
