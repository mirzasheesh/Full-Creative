package internship;

public class Sync {
    public static void main(String[] args) {
        Apartment newF = new Apartment();
        Apartment newG = new Apartment();
        for (int i = 15; i > 0; i--) {
            (new BuildMore(newF, i)).start();
            (new BuildMore(newG, i)).start();
        }
    }
}

class Apartment {
    static int rooms;
    static int currentTeam = 96;

    synchronized static void buildRooms(int increament) {
        currentTeam++;
        try {
            // There is no fix time, sometimes worker can be lazy
            int n = (int) (Math.random() * 50);
            System.out.println("Team: " + (char) currentTeam + ", started construction... can take " + (250 * n) + " milliseconds");
            Thread.sleep(250 * n);
        } catch (Exception e) {
            System.out.println(e);
        }
        rooms = rooms + increament;
        System.out.println("Team: " + (char) currentTeam + ", built " + increament + " new rooms, total rooms: " + rooms);
    }
}

class BuildMore extends Thread {
    Apartment flat;
    int count;

    @Override
    public void run() {
        (this.flat).buildRooms(this.count);
    }

    BuildMore(Apartment flat, int count) {
        this.flat = flat;
        this.count = count;
    }
}