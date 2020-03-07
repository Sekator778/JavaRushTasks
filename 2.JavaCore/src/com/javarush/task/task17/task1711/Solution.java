package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String name = "";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");
        Date bd = null;
        String sex;
        Person person = null;
        switch (args[0]) {

            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        name = args[i];
                        sex = args[i + 1];
                        bd = format.parse(args[i + 2]);
                        if (sex.equals("м")) {
                            person = Person.createMale(name, bd);
                        } else {
                            person = Person.createFemale(name, bd);
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        int id = Integer.parseInt(args[i]);
                        person = allPeople.get(id);
                        name = args[i + 1];
                        sex = args[i + 2];
                        bd = format.parse(args[i + 3]);
                        person.setName(name);
                        person.setBirthDate(bd);
                        if (sex.equals("м")) {
                            person.setSex(Sex.MALE);
                        } else {
                            person.setSex(Sex.FEMALE);
                        }
                        System.out.println(allPeople.indexOf(person));
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setBirthDate(null);
                        person.setSex(null);
                    }
                    break;
                }

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        bd = person.getBirthDate();
                        String strDate = format1.format(bd);
                        if (person.getSex() == Sex.MALE) {
                            sex = "м";
                        } else {
                            sex = "ж";
                        }
                        System.out.println(person.getName() + " " + sex + " " + strDate);
                    }
                    break;
                }
            default:
                System.out.println("what the fuck you write this ?");
        }
    }
}
