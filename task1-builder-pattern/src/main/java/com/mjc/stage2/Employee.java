package com.mjc.stage2;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Employee {
    private String name;
    private String lastName;
    private String position;
    private String phone;
    private String email;
    private String carNumber;

    public Employee() {
    }

    public static EmployeeBuilder getBuilder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {

        private Employee employee;

        public EmployeeBuilder() {
            this.employee = new Employee();
        }
        public EmployeeBuilder setName(String name){
            employee.name=name;
            return this;
        }
        public EmployeeBuilder setLastName(String lastName){
            employee.lastName=lastName;
            return this;
        }
        public EmployeeBuilder setPosition(String position){
            employee.position=position;
            return this;
        }
        public EmployeeBuilder setPhone(String phone){
            employee.phone=phone;
            return this;
        }
        public EmployeeBuilder setEmail(String email){
            employee.email=email;
            return this;
        }
        public EmployeeBuilder setCarNumber(String carNumber){
            employee.carNumber=carNumber;
            return this;
        }

        public Employee build(){
            return employee;
        }
    }
}
