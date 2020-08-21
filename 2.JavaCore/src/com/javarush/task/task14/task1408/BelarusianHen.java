package com.javarush.task.task14.task1408;

 class BelarusianHen extends Hen implements Country{
    String country = Country.BELARUS;
    @Override
    public int getCountOfEggsPerMonth() {
        return 200;
    }
    @Override
    public String getDescription(){
        return super.getDescription() + " Моя страна - "+ country + "." + " Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
