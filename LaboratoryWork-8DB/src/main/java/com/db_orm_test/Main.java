package com.db_orm_test;

import com.db_orm_test.models.*;
import com.db_orm_test.utils.*;
import org.hibernate.Session;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            Scanner in = new Scanner(System.in);

            while (true){
                System.out.println("""
                    Введите работника в следующем формате:
                    <name>|<lastName>|<email>
                    Чтобы завершить работу программы введите "!\"""");
                String line = in.nextLine();
                if (Objects.equals(line, "!")){
                    break;
                }
                String[] customersParts = line.split("\\|");
                Customer customer = new Customer();
                customer.setFirstName(customersParts[0]);
                customer.setLastName(customersParts[1]);
                customer.setEmail(customersParts[2]);
                session.save(customer);

            }
            session.getTransaction().commit();
        }
    }
}
