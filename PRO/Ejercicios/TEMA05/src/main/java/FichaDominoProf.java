public class FichaDominoProf {
    private int izda,dcha;

    public FichaDominoProf(int izda, int dcha) {
        this.izda = izda;
        this.dcha=dcha;
    }

    public FichaDominoProf voltea() {
        return new FichaDominoProf(this.dcha,this.izda);
    }

    public boolean encaja(FichaDominoProf f){
        return this.izda==f.izda || this.izda==f.dcha || this.dcha==f.dcha || this.dcha==f.izda;
    }

    @Override
    public String toString() {
        return String.format("[%d|%d]",this.izda,this.dcha).replace("0"," ");
    }
}
