package com.emakarov.hw02generics;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final TreeMap<Customer, String> map = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> smallestCustomer = map.firstEntry();
        return smallestCustomer == null ? null : new AbstractMap.SimpleEntry<>(new Customer(smallestCustomer.getKey()),
                smallestCustomer.getValue()); // это "заглушка, чтобы скомилировать"
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Customer nextCustomer = map.higherKey(customer);
        return nextCustomer == null ? null : new AbstractMap.SimpleEntry<>(new Customer(nextCustomer),
                map.get(nextCustomer));
    }

    public void add(Customer customer, String data) {
        map.put(customer, data);
    }
}
