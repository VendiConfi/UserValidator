package loginregister; // Assuming your UserDTO class is in the "loginregister" package

public class UserDTO {
    private int id;
    private String name;
    private String employeeId;
    private String address;
    private String doj; // Update the field name to 'doj'
    private String status;

    // Constructors, getters, and setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { // Add the setName method with String parameter
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoj() { // Update the getter method name to 'getDoj'
        return doj;
    }

    public void setDoj(String doj) { // Add the setDoj method with String parameter
        this.doj = doj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", name=" + name + ", employeeId=" + employeeId + ", address=" + address
                + ", doj=" + doj + ", status=" + status + "]";
    }
}

