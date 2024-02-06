package lab1;

class Data{
    private static int overallNum;
    private static double sum;
    private static double maximum;
    public Data(){
        overallNum = 0;
        sum = 0;
        maximum = Integer.MIN_VALUE;
    }
    public void addData(double data){
        overallNum++;
        sum+=data;
        if(data>maximum)
            maximum = data;
    }
    public double getAverage(){
        return overallNum==0 ? 0 : (sum/overallNum);
    }
    public double getMaximum(){
        return maximum;
    }
}