package utils.Tipos.Abstrato;

import java.util.Hashtable;
import utils.Tipos.Tipos;
import utils.Tipos.Molde.Funcao;
import utils.Tipos.Molde.Objeto;

public class Molde {
    private String id; // Identificação do molde
    private Hashtable<String, Tipos> informacoes; // Informações do molde, como: constantes, objetos, funções, tipos de retorno...
    private boolean definida;

    public Molde(String id)
    {
        this.id = id;
        this.informacoes = new Hashtable<String, Tipos>();
        this.definida = false;
    }

    public String obterId()
    {
        return this.id;
    }

    public Hashtable<String, Tipos> obterInformacoes()
    {
        return this.informacoes;
    }

    public void mostrarInformacoes()
    {
        System.out.println("//////////////////////////////////////");
        System.out.println("      Informações de " + this.id);
        for(String p : this.informacoes.keySet()) System.out.println("Chave: " + p + " | Valor: " + this.informacoes.get(p));
        System.out.println("//////////////////////////////////////");
    }

    public boolean existeChave(String chave)
    {
        return this.informacoes.containsKey(chave);
    }

    public void atualizarInformacao(String chave, Tipos informacao)
    {
        if(this.informacoes.containsKey(chave))
        {
            this.informacoes.remove(chave);
            this.informacoes.put(chave, informacao);
        }
        else throw new RuntimeException("[ERRO] Chave '" + chave + "' não encontrada!");
    }

    public void inserirInformacao(Tipos informacao)
    {
        String id = informacao.obterId();

        if(!this.informacoes.containsKey(id)) this.informacoes.put(id, informacao);
        else
        {
            if(informacao instanceof Objeto) throw new RuntimeException("[ERRO] Objeto '" + id + "' já declarado");
            else
            {
                if(informacao instanceof Funcao) throw new RuntimeException("[ERRO] Função '" + id + "' já declarada");
                throw new RuntimeException("[ERRO] Constante '" + id + "' já declarada");
            }
        }
    }

    public Tipos obterInformacao(String chave)
    {
        Tipos retorno;
        if(this.informacoes.containsKey(chave)) retorno = this.informacoes.get(chave);
        else throw new RuntimeException("'" + chave + "' não declarado(a)");

        return retorno;
    }

    public boolean definida()
    {
        return this.definida;
    }

    public void definir()
    {
        this.definida = true;
    }

}
