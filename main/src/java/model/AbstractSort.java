package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class AbstractSort {
    private ArrayList<Integer> valuesList;
    private ArrayList<Long> timeList;
    private Double avarageTime;

    private Integer diapasonMin;
    private Integer diapasonMax;
    private Integer arraySize;
    private Integer repeatCount;

    public AbstractSort(Integer diapasonMin, Integer diapasonMax, Integer arraySize, Integer repeatCount) {
        setValuesList(new ArrayList<>());
        setTimeList(new ArrayList<>());
        this.diapasonMin = diapasonMin;
        this.diapasonMax = diapasonMax;
        this.arraySize = arraySize;
        this.repeatCount = repeatCount;
    }

    public Integer getDiapasonMin() {
        return diapasonMin;
    }

    public void setDiapasonMin(Integer diapasonMin) {
        this.diapasonMin = diapasonMin;
    }

    public Integer getDiapasonMax() {
        return diapasonMax;
    }

    public void setDiapasonMax(Integer diapasonMax) {
        this.diapasonMax = diapasonMax;
    }

    public void sort(){
    }
    public void buildStatistics(String fillMethod){
        for (int i = 0; i <repeatCount ; i++) {
            switch (fillMethod){
                case "Случайные числа":  {
                    generateRandom();
                    break;
                }
                case "По возрастанию":  {
                    generateAscending();
                    break;
                }
                case "По убыванию":  {
                    generateDescending();
                    break;
                }
            }
             sort();
            calculateAverage(getTimeList());
        }
    }
    private void calculateAverage(ArrayList<Long> times){
        Double sec=0.001;
        Double sum = 0d;
        for (Long arrayTimes: getTimeList()) {
            sum=sum+arrayTimes;
        }
        avarageTime=roundResult((sum*sec)/repeatCount,3);
    }
    private double roundResult (double d, int precise) {

        precise = (int) Math.pow(10,precise);
        d = d*precise;
        int i = (int) Math.round(d);
        return (double) i/precise;

    }
    private void generateRandom(){
        valuesList=new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            valuesList.add(new Random().nextInt(getDiapasonMax()-getDiapasonMin())+getDiapasonMin());
        }
    }
    private void generateDescending(){
         generateRandom();
         Collections.sort(getValuesList());
         Collections.reverse(getValuesList());
    }
    private void generateAscending(){
        generateRandom();
        Collections.sort(getValuesList());
    }

    ArrayList<Integer> getValuesList() {
        return valuesList;
    }

    private void setValuesList(ArrayList<Integer> valuesList) {
        this.valuesList = valuesList;
    }

    ArrayList<Long> getTimeList() {
        return timeList;
    }

    private void setTimeList(ArrayList<Long> timeList) {
        this.timeList = timeList;
    }

    public Integer getArraySize() {
        return arraySize;
    }

    public void setArraySize(Integer arraySize) {
        this.arraySize = arraySize;
    }

    public Integer getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Double getAvarageTime() {
        return avarageTime;
    }

    public String toString(String clas,String fill) {
        return clas +
                "\nМетод заполнения: "+fill+
                "\nДиапазон значений "+ diapasonMin +"  "+ diapasonMax +
                "\nРазмер массива " + arraySize +
                "\nПовторения " + repeatCount +
                "\nСреднее время " + avarageTime;
    }
}
