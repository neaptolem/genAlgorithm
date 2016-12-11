public class Main {
    private static Function y = new Function();
    private static Population popCurrent = new Population(y);
    private static Population popNext = new Population(y);

    public static void main(String[] args) {
        int num = 10;
        popCurrent.evpop();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 4; j++) {
                popNext.set(j, popCurrent.get(j));
                popNext.pickchroms();
                popNext.crossover();
                popNext.mutation();
            }
            for(int j=0;j<4;j++){
                popCurrent.set(j, popNext.get(j));
            }
        }
    }
}
