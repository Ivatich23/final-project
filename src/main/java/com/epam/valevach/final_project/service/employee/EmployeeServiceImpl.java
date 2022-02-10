package com.epam.valevach.final_project.service.employee;

import com.epam.valevach.final_project.dao.employee.EmployeeDAOImpl;
import com.epam.valevach.final_project.dao.order.OrderDAOImpl;
import com.epam.valevach.final_project.entity.Employee;
import com.epam.valevach.final_project.entity.Order;
import com.epam.valevach.final_project.exceptions.EmployeeOrderAssignedException;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDAOImpl employeeDAO =EmployeeDAOImpl.getInstance();
    private static EmployeeServiceImpl instance;
    private EmployeeServiceImpl(){}
    public static EmployeeServiceImpl getInstance(){
        synchronized (EmployeeServiceImpl.class) {
            if (instance == null) {
                instance = new EmployeeServiceImpl();
            }
        }
        return instance;
    }

    @Override
    public void create(Employee entity) {
      /*  UserInputValidation validation = UserInputValidation.getInstance();
        if(!validation.checkNotNull(entity.getEmpName())||
                !validation.checkNotNull(entity.getPosition())||
                !validation.checkNotNull(entity.getSurName())||
                !validation.checkNotNull(String.valueOf(entity.getDepId()))||
                !validation.checkNotNull(String.valueOf(entity.getSalary()))){
            throw new RuntimeException();
        }*/
        employeeDAO.create(entity);
    }

    @Override
    public Employee read(Integer id) {
        return employeeDAO.read(id);
    }

    @Override
    public void delete(Employee entity) {
        OrderDAOImpl orderDAO = OrderDAOImpl.getInstance();
        List<Order> orders = orderDAO.findOrdersByEmployeeId(entity);
        if (orders.size() > 0) {
            throw new EmployeeOrderAssignedException();
        }
        employeeDAO.delete(entity);
    }

    @Override
    public void update(Employee entity) {
       /* UserInputValidation validation = UserInputValidation.getInstance();
        if(!validation.checkNotNull(entity.getEmpName())||
                !validation.checkNotNull(entity.getPosition())||
                !validation.checkNotNull(entity.getSurName())||
                !validation.checkNotNull(String.valueOf(entity.getDepId()))||
                !validation.checkNotNull(String.valueOf(entity.getSalary()))){
            throw new RuntimeException();
        }*/
        employeeDAO.update(entity);
    }

    @Override
    public List<Employee> readEmployeesByDepartment(Integer depId) {
        return employeeDAO.readEmployeesByDepartment(depId);
    }

    @Override
    public List<Employee> sowAllEmployee() {
        return employeeDAO.showAllEmployee();
    }


    public  boolean checkEmployeeId(int id) {
       if(employeeDAO.read(id).getId()==0){
           return false;
       }
        return true;
    }
}
