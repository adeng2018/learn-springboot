package com.adeng1024.dao;

import com.adeng1024.pojo.Apartment;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ApartmentDao {
    static Map<String, Apartment> apartments = new HashMap();
    static {
        apartments.put("001", new Apartment("001","后勤部"));
        apartments.put("002", new Apartment("002","人事部"));
        apartments.put("003", new Apartment("003","财务部"));
        apartments.put("004", new Apartment("004","研发部"));
    }
    public Collection<Apartment> getApartments(){
        return apartments.values();
    }
    public Apartment getApartmentById(String id){
        return apartments.get(id);
    }
}
