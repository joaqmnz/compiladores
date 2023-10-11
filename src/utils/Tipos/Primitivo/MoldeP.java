package utils.Tipos.Primitivo;

import utils.Tipos.Tipos;

public class MoldeP extends Tipos {
    private String molde;
    private String id;
    
    public MoldeP(){}

    public MoldeP(String id, String molde)
    {
        this.id = id;
        this.molde = molde;
    }

    public MoldeP(String molde)
    {
        this.molde = molde;
    }

    @Override
    public String obterRetorno()
    {
        return this.molde;
    }

    @Override
    public String obterValor()
    {
        return this.molde;
    }

    @Override
    public void inserirValor(String valor)
    {
        this.molde = valor;
    }

    @Override
    public String obterId()
    {
        return this.id;
    }

    @Override
    public void inserirId(String id)
    {
        this.id = id;
    }
}
