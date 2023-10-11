package utils.Arvore;

import java.util.ArrayList;

public class ArvoreFamilia {
    private String molde;
    private ArrayList<ArvoreFamilia> filhos;

    public ArvoreFamilia(String molde)
    {
        this.filhos = new ArrayList<ArvoreFamilia>();
        this.molde = molde;
    }

    public String obterMolde()
    {
        return this.molde;
    }

    public void inserir(String molde)
    {
        if(!this.existeMolde(molde))
        {
            System.out.println("[INSERÇÃO] '" + molde + "' como filho de '" + this.molde + "'");
            ArvoreFamilia filho = new ArvoreFamilia(molde);
            this.filhos.add(filho);
        }
        else throw new RuntimeException("[ERRO] Molde '" + molde + "' já declarado");
    }

    public void inserirFilho(String nomePai, String nomeFilho)
    {
        if(this.filhos.size() > 0)
        {
            for(ArvoreFamilia filho : this.filhos)
            {
                if(filho.obterMolde().intern() == nomePai.intern())
                {
                    filho.inserir(nomeFilho);
                    return;
                }
                filho.inserirFilho(nomePai, nomeFilho);
            }
        }
    }

    public boolean existeMolde(String nomeMolde)
    {
        return this.existeMoldeAux(nomeMolde) == 1;
    }

    private int existeMoldeAux(String nomeMolde)
    {
        int i = 0;
        for(ArvoreFamilia filho : this.filhos)
        {
            if(filho.obterMolde().intern() == nomeMolde.intern())
            {
                i++;
                break;
            }
            i = filho.existeMoldeAux(nomeMolde) + i;
        }
        return i;
    }
    
}
