package com.adeng1024.dao;

import com.adeng1024.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    static ApartmentDao apartmentDao=new ApartmentDao();
    static Map<String, Employee> employees=new HashMap<>();
    private Integer number=1005;
    static {
        employees.put("1001", new Employee("1001", "AA", "4578784@QQ.com", 1, apartmentDao.getApartmentById("001")));
        employees.put("1002", new Employee("1002", "BB", "4578784@QQ.com", 0, apartmentDao.getApartmentById("002")));
        employees.put("1003", new Employee("1003", "CC", "4578784@QQ.com", 1, apartmentDao.getApartmentById("003")));
        employees.put("1004", new Employee("1004", "DD", "4578784@QQ.com", 0, apartmentDao.getApartmentById("004")));
    }
    //获取全部员工
    public  Collection<Employee>  getEmployees(){
        return employees.values();
    }
    //添加
    public  void addEmployee(Employee employee){
        employee.setApartment(apartmentDao.getApartmentById(employee.getApartment().getId()));
        employee.setId(number.toString());
        employees.put(number.toString(), employee);
        number++;
    }
    //删除员工
    public void  removeEmployeeById(String id){
        employees.remove(id);
    }

    //修改员工
    public void updateEmployee(Employee employee) {
        employee.setApartment(apartmentDao.getApartmentById(employee.getApartment().getId()));
        employees.put(employee.getId(), employee);
    }
    //查询
    public Employee queryEmployeeById(String id){
        return employees.get(id);
    }

}
