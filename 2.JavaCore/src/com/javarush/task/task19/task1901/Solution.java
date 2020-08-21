package com.javarush.task.task19.task1901;

/* 
TableAdapter
Измени класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".

Пример, "[Amigo] : DashboardTable".


1. Класс Solution должен содержать public static интерфейс ATable.
2. Класс Solution должен содержать public static интерфейс BTable.
3. Класс Solution должен содержать public static класс TableAdapter.
4. Класс TableAdapter должен реализовывать интерфейс BTable.
5. Класс TableAdapter должен содержать приватное поле aTable типа ATable.
6. Класс TableAdapter должен содержать конструктор с параметром ATable.
7. Класс TableAdapter должен переопределять метод getHeaderText согласно заданию
*/

public class Solution {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable{
       private ATable aTable;
        public TableAdapter (ATable aTable) {
            this.aTable = aTable;
        }
        @Override
        public String getHeaderText() {
            return "[" + aTable.getCurrentUserName() + "]" + " : " + aTable.getTableName();
        }
    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}