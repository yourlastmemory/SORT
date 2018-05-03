package model;

public class InsertionSort extends AbstractSort {

    public InsertionSort(Integer diapasonMin, Integer diapasonMax, Integer arraySize, Integer repeatCount) {
        super(diapasonMin, diapasonMax, arraySize, repeatCount);
    }

    @Override
    public void sort() {
        Long startTime= System.currentTimeMillis();
        int temp,j;
        for (int i = 1; i < getValuesList().size(); i++) {
            temp=getValuesList().get(i);
            for (j = i - 1; j>=0 && getValuesList().get(j)>temp; j--) {
                getValuesList().set(j+1,getValuesList().get(j));
            }
            getValuesList().set(j+1,temp);

        }
        getTimeList().add( System.currentTimeMillis()-startTime);
    }

}
