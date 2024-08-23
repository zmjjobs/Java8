package com.zmj.test;

import com.zmj.bean.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * list移除某个元素
 */
public class RemoveEleTest {

    @Test
    public void listRemove(){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("张三",17,3333.5, Employee.Status.FREE));
        empList.add(new Employee("李四",28,4444.5, Employee.Status.BUSY));
        empList.add(new Employee("赵武",38,5555.5, Employee.Status.VOCATION));
        empList.add(new Employee("王柳",68,6666.5, Employee.Status.FREE));
        empList.add(new Employee("田七",78,7777.5, Employee.Status.BUSY));
        empList.removeIf(e -> e.getAge() < 18);
        System.out.println(empList);
    }

    @Test
    public void mapRemove(){
        HashMap<String, String> map = new HashMap<>();
        map.put("aa",String.valueOf(1));
        map.put("bb",String.valueOf(11));
        map.put("cc",String.valueOf(2));
        map.put("dd",String.valueOf(22));
        map.put("ee","aaaaaaa");
        //通过values删除
        map.values().removeIf(value -> value.equals("1"));
        //通过keySet删除
        map.keySet().removeIf(key -> key == "aa");
        //通过entrySet删除
        map.entrySet().removeIf(entry -> entry.getKey() == "aa");
    }
}
