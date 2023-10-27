package ba.unsa.etf.rpr;

public class Sat {
    private  int sati,minute,sekunde;
    public Sat (int s,int m,int sek){
        this.postavi(s,m,sek);
    }
    public void postavi(int s,int m,int sek){
        sati=s;
        minute=m;
        sekunde=sek;
    }
    public void sljedeci(){
        sekunde++;
        if(sekunde==60) {
            sekunde=0;
            minute++;
        }
        if(minute==60){
            minute=0;
            sati++;
        }
        if(sati==24){
            sati=0;
        }
    }
    public void prethodni(){
        sekunde--;
        if(sekunde<0){
            sekunde=59;minute--;
        }
        if(minute<0){
            minute=59;sati--;
        }
        if(sati<0){
            sati=23;
        }
    }
    public void pomjeriZa(int pomak){
        if(pomak<0){
            while(pomak<0){
                prethodni();
                pomak++;
            }
        }
        else if(pomak>0){
            while(pomak>0){
                sljedeci();
                pomak--;
            }
        }
    }
    public int getSekunde(){return sekunde;}
    public int getMinute(){return minute;}
    public int getSati(){return  sati;}
    public void ispisi(){
        System.out.println(sati+":"+minute+":"+sekunde);
    }
}
