public class Addfurniture {
    int x,y,t;
    String type;
    public Addfurniture(int i,int j,int k){
        x=i;
        y=j;
        t=k;
        switch(k){
            case 1: type="BED";
            break;
            case 2: type="DINING TABLE";
            break;
            case 3: type="WASH BASIN";
            break;
        }
    }
}
