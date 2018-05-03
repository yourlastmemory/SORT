package model;

import java.util.ArrayList;

public class BubbleSort extends AbstractSort {


    public BubbleSort(Integer diapasonMin, Integer diapasonMax, Integer arraySize, Integer repeatCount) {
        super(diapasonMin, diapasonMax, arraySize, repeatCount);
    }

    @Override
    public void sort() {

        Long startTime= System.currentTimeMillis();
        boolean isSorted=false;
        int swapVar;
        while (!isSorted){
            isSorted=true;
            for (int i = 0; i <getValuesList().size()-1 ; i++) {
                if (getValuesList().get(i)>getValuesList().get(i+1)){
                    isSorted=false;

                    swapVar=getValuesList().get(i);
                    getValuesList().set(i,getValuesList().get(i+1));
                    getValuesList().set(i+1,swapVar);
                }
            }
        }
        getTimeList().add( System.currentTimeMillis()-startTime);

    }
}
