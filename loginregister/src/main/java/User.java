
public class User {
    private int id;
    private String name;
    private String employeeId; // Change the data type to String
    private String address;
    private String doj;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) { // Change the parameter data type to String
        this.employeeId = employeeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


        public String getDoj() {
            return doj;
        }

        public void setDoj(String doj) {
            this.doj = doj;
        }

        // ... other fields and methods ...
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", employeeId=" + employeeId + ", address=" + address + ", doj="
                + doj + ", status=" + status + "]";
    }
}
