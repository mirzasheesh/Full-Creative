package internship;

public class Threading {
    public static void main(String[] args) {
        System.out.println("<== Railway Station ==>");
        Train[] trains = {
            new Train("Rajdhani Express", 4400),
            new Train("Chennai Express", 1200),
            new Train("Sampakranti Express", 1800),
            new Train("Shatabdi Express", 600),
            new Train("Gareeb Rath", 3200)
        };

        Train t1 = new Train("EMU", 10000);
        //System.out.println(t1.getState());
        t1.start();
        //System.out.println(t1.getState());
        for(Train trn : trains){
            trn.start();
        }
        System.out.println("\n All traines departed... \n");
        //System.out.println(t1.getState());
    }   
}

class Train extends Thread{

    String name;
    int routeLength;

    @Override
    public void run() {
        try{
            Thread.sleep(this.routeLength * 10);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(this.name + ": reached destination and travelled: " + this.routeLength + "kms");
    }

    Train(String name, int routeLength){
        this.name = name;
        this.routeLength = routeLength;
        System.out.println(this.name + ": leaving platform");
    }
}