package com.javarush.task.task20.task2002;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        // упо гавно хтось придумав воно не паше не пише в файл .....................
        try {
            File yourFile = File.createTempFile("F:\\Java\\JavaRush\\JavaRushTasks\\test1", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            // создаем юсерів сетаем поля які там надо і рагульно заполняем дату
            User userOne = new User();
            userOne.setFirstName("Trinity");
            userOne.setLastName("Malek");
            userOne.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("05/07/1978 06:40:32.1"));
            userOne.setMale(false);
            userOne.setCountry(User.Country.RUSSIA);
            javaRush.users.add(userOne);

            User userTwo = new User();
            userTwo.setFirstName("Sasha");
            userTwo.setLastName("Nikolaichuk");
            userTwo.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("12/09/2003 09:23:39.8"));
            userTwo.setCountry(User.Country.UKRAINE);
            userTwo.setMale(true);
            javaRush.users.add(userTwo);

            User userThird = new User();
            userThird.setFirstName("Masha");
            userThird.setLastName("Golub");
            userThird.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("02/16/1986 23:12:32.2"));
            userThird.setCountry(User.Country.OTHER);
            userThird.setMale(true);
            javaRush.users.add(userThird);

            User userFour = new User();
            userFour.setFirstName("Olga");
            userFour.setLastName("Petryk");
            userFour.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("04/16/1999 19:18:12.3"));
            userFour.setCountry(User.Country.UKRAINE);
            userFour.setMale(false);
            javaRush.users.add(userFour);

            User userFive = new User();
            userFive.setFirstName("Oleg");
            userFive.setLastName("Reshetnik");
            userFive.setBirthDate(new SimpleDateFormat ("MM/dd/yyyy HH:mm:ss.S").parse("09/19/1923 14:12:46.2"));
            userFive.setMale(true);
            userFive.setCountry(User.Country.UKRAINE);
            javaRush.users.add(userFive);

            User userSix = new User();
            userSix.setFirstName("Oksana");
            userSix.setLastName("Polischyk");
            userSix.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("01/08/2011 11:26:03.1"));
            userSix.setCountry(User.Country.UKRAINE);
            userSix.setMale(false);
            javaRush.users.add(userSix);

            User userSeven = new User();
            userSeven.setFirstName("Petro");
            userSeven.setLastName("Petryk");
            userSeven.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("02/11/1983 06:11:36.7"));
            userSeven.setMale(true);
            userSeven.setCountry(User.Country.OTHER);
            javaRush.users.add(userSeven);

            User userEight = new User();
            userEight.setFirstName("Gaga");
            userEight.setLastName("Lady");
            userEight.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("08/23/1986 02:26:11.8"));
            userEight.setCountry(User.Country.OTHER);
            userEight.setMale(false);
            javaRush.users.add(userEight);  // тут добавляем їх в арайлист
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream); // записуем в файл
            outputStream.flush();

            JavaRush loadedObject = new JavaRush(); // читаем з файла
            loadedObject.load(inputStream);

            // якийсь тупняк чи совпадають версії
            if ((javaRush.hashCode() == loadedObject.hashCode())) {
                System.out.println("javaRush hashcode equal loadedObject");
            } else {
                System.out.println("No equal");
            }//here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            if (users.size() == 0)  // якщо арайлист пустий то ноль пишем в строку першу або не ноль) там ниже Have Users
                writer.println("No Users");
                else {
                writer.println("Have Users");
                for (User u : users)  // форичаем з арайлиста гетерами по кругу
                    writer.write(u.getFirstName() + "," + u.getLastName() + "," + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").format(u.getBirthDate()) +
                            "," + u.getCountry() + "," + u.isMale() + "\n"); // заганяем все в строку нову на кажого юсера
                        }
            writer.flush();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String info = reader.readLine();
            // читаем першу строку шо там пише в файлі ага немає
            if (info.equals("No Users")) users = new ArrayList<>();

            else if (info.equals("Have Users")){  // якщо е то роздиляем линию по пробелам и заганяем строку в масив
                String line;
                while ((line = reader.readLine()) != null){
                    if (line.equals(" ")) continue;
                    String [] data = line.split(","); // вот масив строк
                    User user = new User(); // робимо юсера з строки
                    user.setFirstName(data[0]);
                    user.setLastName(data[1]);
                    user.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse(data[2]));
                    user.setCountry(User.Country.valueOf(data[3]));
                    user.setMale(Boolean.parseBoolean(data[4]));
                    users.add(user);

                     }
            }
            else System.out.println("Wrong load file data");
            reader.close();

            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
