package services;

import models.Wine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WineService {
    public List<Wine> wines = new ArrayList<>();
    final private Wine wine = new Wine(1,"Bendida",2021,"Wild Rubin");

    public String addWine(Wine wine){
        if (validate(wine.getName(),wine.getYear(),wine.getType()).equals("Успешно добавено вино в базата данни!")){
            wines.add(wine);
        }
        return validate(wine.getName(),wine.getYear(),wine.getType());
    }
    public String deleteWineById(Integer id){
        wines.add(wine);
        for (Wine wine: wines){
            if(wine.getId() == id){
                wines.remove(wine);
                return "Успешно изтрито вино от базата данни по идентификатор!";
            } else {
                return "Не съществува вино с такъв идентификатор, имате грешка";
            }
        }
        return null;
    }
    public String deleteWineByName(String name){
        wines.add(wine);
        for (Wine wine: wines){
            if(wine.getName().equals(name)){
                wines.remove(wine);
                return "Успешно изтрито вино от базата данни по име!";
            } else {
                return "Не съществува вино с такова име, имате грешка";
            }
        }
        return null;
    }

    private String validate(String name,Integer year,String type){
        if(name == null)
        {
           return "Невалидни данни! Въведете име на вино";
        }
        if(null == year)
        {
            return "Невалидни данни! Въведете година на производство на вино";
        }
        if(type == null)
        {
            return "Невалидни данни! Въведете сорт на вино";
        }
        if (year < 0) {
            return "Невалидни данни! Годината е в невалиден формат, моля опитайте отново";
        }
        return "Успешно добавено вино в базата данни!";
    }

}
