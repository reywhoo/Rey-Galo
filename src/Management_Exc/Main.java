package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {


    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Person mm = null;
        Person ee = null;

        for(Person p: persons){
            if(manager.equals(p.getName())){
                mm = p;
            } else if(employee.equals(p.getName())){
                ee = p;
            }
        }

        if(mm == null){
            throw new NoSuchElementException(manager + " does not exist");
        }
        if(ee == null){
            throw new NoSuchElementException(employee + " does not exist");
        }


        if(!(mm instanceof Manager)){
            throw new ClassCastException(mm.getName() + " is not a manager");
        }
        if(!(ee instanceof Employee)){
            throw new ClassCastException(ee.getName() + " is not an employee");
        }

        Manager mrg = (Manager) mm;
        Employee e = (Employee) ee;

        mrg.giveRaise(e , salary);
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Person mrg = null;
        Person dev = null;

        for(Person p: persons){
            if(manager.equals(p.getName())){
                mrg = p;
            } else if (developer.equals(p.getName())){
                dev = p;
            }
        }

        if(dev == null){
            throw new NoSuchElementException(developer + " does not exist");
        }
        if(mrg == null){
            throw new NoSuchElementException(manager + " does not exist");
        }

        if(!(mrg instanceof Manager)){
            throw new ClassCastException(mrg.getName() + " is not a manager");
        }
        if(!(dev instanceof Developer)){
            throw new ClassCastException(dev.getName() + " is not a developer");
        }


        Manager m = (Manager) mrg;
        Developer d = (Developer) dev;

        d.setProjectManager(m);


    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Person cc = null;
        Person ee = null;

        for(Person p: persons){
            if(customer.equals(p.getName())){
                cc = p;
            } else if (employee.equals(p.getName())) {
                ee = p;
            }
        }

        if(cc == null){
            throw new NoSuchElementException(customer + " does not exist");
        }
        if(ee == null){
            throw new NoSuchElementException(employee + " does not exist");
        }

        if(!(cc instanceof Customer)){
            throw new ClassCastException(cc.getName() + " is not a customer");
        }
        if(!(ee instanceof Employee)){
            throw new ClassCastException(ee.getName() + " is not an employee");
        }

        Customer cus = (Customer) cc;
        Employee e = (Employee) ee;

        return ((Customer) cus).speak((Employee) e);

    }




}