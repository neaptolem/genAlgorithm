class Chrom{
    private int fit;
    private short[] bit=new short[6];
    Chrom(int fit,short[] bit){
        this.fit=fit;
        for (int i=0;i<6;i++){
            this.bit[i]=bit[i];
        }
    }
    Chrom(){
        this.fit=0;
        for (int i=0;i<6;i++){
            this.bit[i]=0;
        }
    }
    Chrom(Chrom chrom){
        this.fit=chrom.getFit();
        for(int i=0; i<bit.length;i++){
            this.bit[0]=chrom.getBit(i);
        }
    }

    public int getFit() {
        return fit;
    }

    public void setFit(int fit) {
        this.fit = fit;
    }

    public short[] getBit() {
        return bit;
    }
    public short getBit(int i) {
        return bit[i];
    }

    public void setBit(short[] bit) {
        this.bit = bit;
    }
    public void  setBit(int i, short num){
        bit[i]=num;
    }
    public int x(){
        short z;
        z= (short) (bit[0]*1+bit[1]*2+bit[2]*4+bit[3]*8+bit[4]*16);
        if (bit[5]==1) z*=-1;
        return z;
    }
    @Override
    public String toString(){
        String str="bit:";
        for(int i=0;i<bit.length;i++){
            str+=bit[i]+" ";
        }
        str=str+" fit:"+fit;
        return str;
    }
}