package com.javarush.task.task30.task3013;

/* 
Набираем код
Приложу своё решение потому что даже не могу объяснить (как собака которая всё понимает)
Попробую объяснить для "будущих" поколений.
Для начала нужно 2 вещи:
1.Понять что в int - 32 ячейки для битов.
2.Количество битов, занимаемых заданным числом (например число 6 - это бинарное 110, т.е. три бита. Остальные биты левее заполняются нулями.
Далее нужно все биты этого числа превратить в "1"! Что мы и делаем number |= number >> 1; вот этими операциями.
Затем переворачиваем  число ~number получив 29 ячеек "1" и 3 ячейки "0", тут же сдвигаем биты вправо  и нулей становится 2.
И на конец через "&" сравниваем полученное число с тем, где наши 3 бита были единицами:
11111111111111111111111111111100
00000000000000000000000000000111
Ну а тут совпадение только в одном месте. Где нам и нужно.
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 3456;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) { // ebanytsa gde takoe nado ?????????????????
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 3;
        number |= number >> 4;
        number &= ~number >> 1;
        return number;
    }
}