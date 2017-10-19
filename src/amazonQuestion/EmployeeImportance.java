package amazonQuestion;

import java.util.*;

/**
 * Created by JiahengYu on 03/10/17.
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;

        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Employee> queue = new ArrayDeque<Employee>();
        queue.add(map.get(id));
        int importance = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            importance += employee.importance;
            for (int i : employee.subordinates) {
                queue.add(map.get(i));
            }
        }
        return importance;
    }
}
