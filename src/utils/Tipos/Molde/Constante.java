package utils.Tipos.Molde;

import utils.Tipos.Tipos;

public class Constante extends Tipos {
    private String id;
    private String retorno;
    private String valor;
    private boolean atribuida;
    private String moldeResponsavel;

    public Constante(String id, String retorno, String moldeResponsavel)
    {
        this.id = id;
        this.retorno = retorno;
        this.atribuida = false;
        this.moldeResponsavel = moldeResponsavel;
    }

    @Override
    public String obterId()
    {
        return this.id;
    }

    @Override
    public String obterRetorno()
    {
        return this.retorno;
    }

    @Override
    public boolean foiAtribuida()
    {
        return this.atribuida;
    }

    @Override
    public String obterValor()
    {
        return this.valor;
    }

    @Override
    public void inserirValor(String valor)
    {
        this.valor = valor;
        this.atribuida = true;
    }

    @Override
    public void inserirRetorno(String retorno)
    {
        this.retorno = retorno;
    }

    @Override
    public void inserirId(String id)
    {
        this.id = id;
    }

    @Override
    public String obterMoldeResponsavel()
    {
        return this.moldeResponsavel;
    }

    @Override
    public void inserirMoldeResponsavel(String molde)
    {
        this.moldeResponsavel = molde;
    }

    @Override
    public void atribuir()
    {
        this.atribuida = true;
    }

}
