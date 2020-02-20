package com.adeng1024.pojo;



import com.adeng1024.dao.ApartmentDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Validated
public class Employee {
    private String id;
    private String name;
    @Email
    private String email;
    private Integer gender;
    private Date birthday;
    private Apartment apartment;

    public Employee(String id,String name, String email, Integer gender, Apartment apartment) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birthday = new Date();
        this.apartment = apartment;
    }
}
