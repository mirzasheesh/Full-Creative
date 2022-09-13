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

        for(Train trn : trains){
            trn.start();
        }
        System.out.println("\n All traines departed... \n");
    }   
}

class Train extends Thread{

    String name;
    int routeLength;

    @Override
    public void run() {
        for(long start = 0; start < this.routeLength * 9999;){
            start = start + 1;
            System.out.print("");
        }
        System.out.println(this.name + ": reached destination and travelled: " + this.routeLength + "kms");
    }

    Train(String name, int routeLength){
        this.name = name;
        this.routeLength = routeLength;
        System.out.println(this.name + ": leaving platform");
    }
}