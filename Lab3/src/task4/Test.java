package task4;

import java.util.Collections;
import java.util.Date;
import java.util.Vector;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp1 = new Employee("John", 50000, new Date(), "123456789");
        Employee emp2 = new Employee("Jane", 60000, new Date(), "987654321");
        
        Vector<Employee> team = new Vector<Employee>();
        team.add(emp1);
        team.add(emp2);
        
        for(Employee e : team) {
        	System.out.println(e);
        }
        
        Employee emp3 = (Employee) emp1.clone();
        System.out.println("Clone of John: " + emp3.toString());
        System.out.println(emp1.equals(emp3));
        System.out.println(emp1.equals(emp2));

        Manager mgr1 = new Manager("Steven", 70000, new Date(), "112233445", team, 5000);
        System.out.println(mgr1);

        Manager mgr2 = new Manager("Amanda", 75000, new Date(), "123654789", team, 5300);
        System.out.println(mgr1.equals(mgr2));

        Manager mgr3 = (Manager) mgr1.clone();
        System.out.println("Clone of Manager Steven: " + mgr3.toString());
        System.out.println(mgr1.equals(mgr3));

        Collections.sort(team, new NameComparator());
        System.out.println("Sorted by name: " + team);

        Collections.sort(team, new HireDateComparator());
        System.out.println("Sorted by hire date: " + team);
    }
}
