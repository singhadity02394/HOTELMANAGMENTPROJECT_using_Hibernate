package hotelproject;
import javax.persistence.*;

@Entity
public class Driver {
    @Id
    
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String company;
    private String carName;
    private boolean available;

    public Driver() {
        // Default constructor required by Hibernate
    }

    public Driver( Long id,String name, int age, String gender, String company, String carName, boolean available) {
    	this.id=id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.company = company;
        this.carName = carName;
        this.available = available;
    }

    // Getters and setters for all attributes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", company='" + company + '\'' +
                ", carName='" + carName + '\'' +
                ", available=" + available +
                '}';
    }
}
