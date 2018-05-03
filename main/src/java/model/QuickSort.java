package model;

import javafx.application.Platform;

import java.util.Collections;

public class QuickSort extends AbstractSort {

    public QuickSort(Integer diapasonMin, Integer diapasonMax, Integer arraySize, Integer repeatCount) {
        super(diapasonMin, diapasonMax, arraySize, repeatCount);
    }

    @Override
    public void sort() {
        int start = 0;
        int end = getValuesList().size()-1;
        Long startTime= System.currentTimeMillis();
        sortRecursion(start,end);
        getTimeList().add( System.currentTimeMillis()-startTime);
    }

    private void sortRecursion(int start,int end){

        if (start>=end) return;
        int i=start;
        int j=end;
        int cur=i-(i-j)/2;
        while (i<j){
            while (i<cur && (getValuesList().get(i)<=getValuesList().get(cur))){
                i++;
            }
            while (j>cur && (getValuesList().get(cur)<=getValuesList().get(j))){
                j--;
            }
            if (i<j){
                Collections.swap(getValuesList(),i,j);
                if (i==cur){
                    cur=j;
                }
                else if (j==cur){
                    cur=i;
                }
            }
        }
        if (start<j)
            sortRecursion(start,cur);
        if (end>i)
            sortRecursion(cur+1,end);
    }

}
