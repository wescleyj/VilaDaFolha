package principal.model;

public class Ninja extends Morador{
    private TipoNinja tipo;
    private String cla;
    private String time;

    public Ninja(String nome, int idade, Sexo sexo, Status status, TipoNinja tipo, String cla, String time) {
        super(nome, idade, sexo, status);
        this.tipo = tipo;
        this.cla = cla;
        this.time = time;
    }

    public TipoNinja getTipo() {
        return tipo;
    }

    public String getCla() {
        return cla;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTipo(TipoNinja tipo) {
        this.tipo = tipo;
    }
}
