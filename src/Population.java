import java.util.Random;

public class Population {
    private Chrom[] chroms = new Chrom[4];
    private Function function;

    public Population(Function function) {
        for (int i = 0; i < chroms.length; i++) chroms[i] = new Chrom();
        this.function = function;
    }

    public Chrom[] getChroms() {
        return chroms;
    }

    public void setChroms(Chrom[] chroms) {
        this.chroms = chroms;
    }

    public void evpop() {
        int i, j, value;
        int random;
        Random rand = new Random();
        for (j = 0; j < 4; j++) {
            for (i = 0; i < 6; i++) {
                random = rand.nextInt(100);
                random = random % 2;
//               System.out.println(random);
                chroms[j].setBit(i, (short) random);
            }
            value = chroms[j].x();
            chroms[j].setFit(function.y(chroms[j].x()));
            System.out.println(chroms[j]+"  value:"+value);
        }
    }

    public Chrom get(int i) {
        return chroms[i];
    }

    public void set(int i, Chrom chrom) {
        chroms[i] = new Chrom(chrom);
    }

    public void pickchroms() {
        Chrom temp;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (chroms[j + 1].getFit() > chroms[j].getFit()) {
                    temp = chroms[j + 1];
                    chroms[j + 1] = chroms[j];
                    chroms[j] = temp;
                }
            }
        }

        for (int i = 0; i < 3; i++) System.out.println("pickchroms: " + chroms[i]);
    }

    public void crossover() {
        int random;
        Random rand = new Random();
        random = rand.nextInt(100);
        random = (random % 5) + 1;
        for (int i = 0; i < random; i++) {
            chroms[2].setBit(i, chroms[0].getBit(i));
            chroms[3].setBit(i, chroms[1].getBit(i));
        }
        for (int i = random; i < 6; i++) {
            chroms[2].setBit(i, chroms[0].getBit(i));
            chroms[3].setBit(i, chroms[1].getBit(i));
        }
        for (int i = 0; i < 4; i++) {
            chroms[i].setFit(function.y(chroms[i].x()));
        }
        for (int i = 0; i < 4; i++) System.out.println("crossover: " + chroms[i]);
    }

    public void mutation() {
        int random;
        int row, col, value;
        Random rand = new Random();
        random = rand.nextInt(100);
        random = random % 50;
        if (random > 25) {
            col = rand.nextInt(100) % 6;
            row = rand.nextInt(100) % 4;
            if (chroms[row].getBit(col) == 0) {
                chroms[row].setBit(col, (short) 1);
            } else if (chroms[row].getBit(col) == 1) {
                chroms[row].setBit(col, (short) 0);
            }
            chroms[row].setFit(function.y(chroms[row].x()));
            value=chroms[row].x();
            for (int i = 0; i < 4; i++) System.out.println("mutation: " + chroms[i]+"  value:"+value);
        }
    }
}
