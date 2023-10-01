import bemtevi.analysis.*;
import bemtevi.node.*;
import java.util.*;

public class Semantico extends DepthFirstAdapter
{
    private Stack<Hashtable<String, String>> pilha = new Stack<Hashtable<String, String>>();
    private boolean entrar; //Variavel que serve para saber se deve ou nao entrar no nó atual
    //definir uma funcao para obter o tipo de retorno

    public Semantico()
    {
        this.pilha.push(new Hashtable<String, String>());
        this.entrar = true;
    }

    //verificar como esta o push e pop da pilha
    private String[] existe(String key)
    {
        Stack<Hashtable<String, String>> pilha_aux = new Stack<Hashtable<String, String>>();
        String retorno[] = new String[2];

        for(int i = 0; i < this.pilha.size(); i++)
        {
            Hashtable<String, String> escopo_atual = this.pilha.pop();
            if(escopo_atual.containsKey(key))
            {
                retorno[0] = key;
                retorno[1] = escopo_atual.get(key);
                pilha_aux.push(escopo_atual);
                break;
            }
            
            pilha_aux.push(escopo_atual);
        }

        for(int i = 0; i < pilha_aux.size(); i++)
        {
            this.pilha.push(pilha_aux.pop());
        }

        return retorno;
    }

    @Override
    public void inAPrograma(APrograma node)
    {
        Hashtable<String, String> escopo_atual = this.pilha.pop();

        System.out.println("Adicionando Comunicacao como filha de Todos");
        escopo_atual.put("Comunicacao", "Todos");

        System.out.println("Adicionando função: Primitivo -> escreva");
        escopo_atual.put("escreva", "primitivo");

        System.out.println("Adicionando função: Texto -> leiaTexto");
        escopo_atual.put("leiaTexto", "Texto");

        System.out.println("Adicionando função:  Numero -> leiaNumero");
        escopo_atual.put("leiaNumero", "Numero");

        System.out.println("Adicionando função: Bool -> leiaBool");
        escopo_atual.put("leiaBool", "Bool");

        this.pilha.push(escopo_atual);
    }

    @Override
    public void inARelacao(ARelacao node)
    {
        Hashtable<String, String> escopo_atual = this.pilha.pop();

        TIdMolde esquerdo = node.getEsquerdo();
        TIdMolde direito = node.getDireito();

        if(!escopo_atual.containsKey(direito.toString()))
        {
            System.out.println("Adicionando " + direito.toString() + "como filha de Todos");
            escopo_atual.put(direito.toString(), "Todos");
        }

        if(!escopo_atual.containsKey(esquerdo.toString()))
        {
            System.out.println("Adicionando " + esquerdo.toString() + "como filha de " + direito.toString());
            escopo_atual.put(esquerdo.toString(), direito.toString());
        }

        this.pilha.push(escopo_atual);
    }

    @Override
    public void inADefMolde(ADefMolde node)
    {
        Hashtable<String, String> escopo_atual = this.pilha.pop();

        TIdMolde molde = node.getIdMolde();

        if(!escopo_atual.containsKey(molde.toString()))
        {
            System.out.println("Adicionando " + molde.toString() + "como filha de Todos");
            escopo_atual.put(molde.toString(), "Todos");
        }

        this.pilha.push(escopo_atual);
    }

    @Override
    public void inAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        Hashtable<String, String> escopo_atual = new Hashtable<String, String>();

        PTipo retorno_funcao = node.getTipo();
        TId nome_funcao = node.getId();

        System.out.println("Adicionando função: " + retorno_funcao.toString() + "-> " + nome_funcao.toString());
        escopo_atual.put(nome_funcao.toString(), retorno_funcao.toString());

        this.pilha.push(escopo_atual);
    }

    @Override
    public void outAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        TId funcao = node.getId();

        System.out.println("Removendo escopo da função " + funcao.toString());
        this.pilha.pop();
    }

    @Override
    public void inAIdParametro(AIdParametro node)
    {
        Hashtable<String, String> escopo_atual = this.pilha.pop();

        PTipo tipo = node.getTipo();
        TId id = node.getId();

        System.out.println("Adicionando parâmetro: " + tipo.toString() + "-> " + id.toString());
        
        escopo_atual.put(id.toString(), tipo.toString());

        this.pilha.push(escopo_atual);
    }

    @Override
    public void inAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        Hashtable<String, String> escopo_atual = this.pilha.pop();

        PTipoPrimitivo tipo = node.getTipoPrimitivo();
        TId id = node.getId();

        if(!escopo_atual.containsKey(id.toString()))
        {
            System.out.println("Adicionando constante: " + tipo.toString() + "-> " + id.toString());
            escopo_atual.put(id.toString(), tipo.toString());
        }
        else
        {
            throw new RuntimeException("Constante " + id.toString() + "já declarada");
        }

        this.pilha.push(escopo_atual);
    }

    @Override
    public void inAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        Hashtable<String, String> escopo_atual = this.pilha.pop();

        PTipoMolde molde = node.getTipoMolde();
        TId id = node.getId();

        if(!escopo_atual.containsKey(id.toString()))
        {
            if(escopo_atual.containsKey(molde.toString()))
            {
                escopo_atual.put(id.toString(), molde.toString());
            }
            else
            {
                throw new RuntimeException("Tipo molde " + molde.toString() + "não declarado");
            }
        }
        else
        {
            throw new RuntimeException("Id " + id.toString() + "já declarado");
        }
    }

    @Override
    public void inADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        PIdOuAttr id_ou_attr = node.getIdOuAttr();
        PExp exp = node.getExp();

        String existe[] = this.existe(id_ou_attr.toString());

        if(existe[0] != null)
        {
            String existe2[] = this.existe(exp.toString());

            if(existe2[0] != null)
            {
                System.out.println("Atribuindo: " + id_ou_attr.toString() + "-> " + exp.toString());
            }
            else
            {
                throw new RuntimeException("Função " + exp.toString() + "não existente");
            }
        }
        else
        {
            throw new RuntimeException("Variável " + id_ou_attr.toString() + "não existente");
        }
    }

    // @Override
    // public void inASomaExp(ASomaExp node)
    // {
    //     Hashtable<String, String> escopo_atual = this.pilha.peek();

    //     PExp esquerdo = node.getEsquerdo();
    //     PExp direito = node.getDireito();

    //     // String tipo_esquerdo = escopo_atual.get(esquerdo.toString());
    //     String tipo_direito = escopo_atual.get(direito.toString());

    //     if(!escopo_atual.containsKey(esquerdo.toString()))
    //     {
    //         throw new RuntimeException("Variável " + esquerdo.toString() + "não declarada");
    //     }
    //     if(!escopo_atual.containsKey(direito.toString()))
    //     {
    //         throw new RuntimeException("Variável " + direito.toString() + "não declarada");
    //     }

    //     if(!(tipo_direito.intern() == tipo_esquerdo.intern()))
    //     {
    //         System.out.println("Variável " + esquerdo.toString() + "-> " + tipo_esquerdo);
    //         System.out.println("Variável " + direito.toString() + "-> " + tipo_direito);

    //         throw new RuntimeException("Tipos de variáveis incompatíveis");
    //     }
        
    //     System.out.println("Soma: " + esquerdo.toString() + "+ " + direito.toString());
    // }
}
