package principal.model;

public class Ninja extends Morador{
    private TipoNinja tipo;

    public Ninja(String nome, int idade, Sexo sexo, Status status, TipoNinja tipo) {
        super(nome, idade, sexo, status);
        this.tipo = tipo;
    }

    public TipoNinja getTipo() {
        return tipo;
    }

    public void setTipo(TipoNinja tipo) {
        this.tipo = tipo;
    }
}
