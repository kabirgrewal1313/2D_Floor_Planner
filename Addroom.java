public class Addroom {
    int x,y,t;
    String type;
    public Addroom(int i, int j,int k){
        x=i;
        y=j;
        t=k;
        switch(k){
            case 1: type="BEDROOM";
            break;
            case 2: type="KITCHEN";
            break;
            case 3: type="BATHROOM";
            break;
        }
    }
}
