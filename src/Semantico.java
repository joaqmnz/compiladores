import bemtevi.analysis.*;
import bemtevi.node.*;
import java.util.*;

public class Semantico extends DepthFirstAdapter
{
    private Stack<Hashtable<String, String>> tabela_simbolos;
    private Stack<Hashtable<String, String>> funcoes;
    private Stack<String[]> tabela_tipos;
    
    public Semantico()
    {
        this.tabela_simbolos = new Stack<Hashtable<String, String>>();
        this.tabela_simbolos.push(new Hashtable<String, String>());

        this.tabela_tipos = new Stack<String[]>();

        this.funcoes = new Stack<Hashtable<String, String>>();
    }

    private boolean existe(Stack<Hashtable<String, String>> pilha, String valor_ou_chave, boolean procurar_chave_ou_valor)
    {
        Stack<Hashtable<String, String>> aux = new Stack<Hashtable<String, String>>();
        boolean existe = false;
        int size = pilha.size();

        for(int i = 0; i < size; i++)
        {
            Hashtable<String, String> escopo_atual = pilha.peek();

            // Se procurar_chave_ou_valor == true significa que quer procurar pela chave
            // Se procurar_chave_ou_valor == false significa que quer procurar pelo valor
            if(procurar_chave_ou_valor)
            {
                if(escopo_atual.containsKey(valor_ou_chave))
                {
                    existe = true;
                    break;
                }
            }
            else
            {
                if(escopo_atual.containsValue(valor_ou_chave))
                {
                    existe = true;
                    break;
                }
            }
            
            aux.push(pilha.pop());
        }

        size = aux.size();

        if(size > 0)
            for(int i = 0; i < size; i++) pilha.push(aux.pop());

        return existe;
    }

    private String obter_valor_chave(String key)
    {
        Stack<Hashtable<String, String>> aux = new Stack<Hashtable<String, String>>();
        String valor_chave = "";
        int size = this.tabela_simbolos.size();

        for(int i = 0; i < size; i++)
        {
            Hashtable<String, String> escopo_atual = this.tabela_simbolos.peek();

            if(escopo_atual.containsKey(key))
            {
                valor_chave = escopo_atual.get(key);
                break;
            }
            
            aux.push(this.tabela_simbolos.pop());
        }

        if(aux.size() > 0)
        {
            for(int i = 0; i < aux.size(); i++)
            {
                this.tabela_simbolos.push(aux.pop());
            }
        }

        return valor_chave;
    }

    private Hashtable<String, String> obter_funcao(String nome_funcao)
    {
        Stack<Hashtable<String, String>> aux = new Stack<Hashtable<String, String>>();
        Hashtable<String, String> funcao = new Hashtable<String, String>();
        int tamanho_pilha = this.funcoes.size();

        for(int i = 0; i < tamanho_pilha; i++)
        {
            Hashtable<String, String> funcao_atual = this.funcoes.peek();
            if(funcao_atual.get("nome").intern() == nome_funcao.intern())
            {
                funcao = funcao_atual;
                break;
            }
            
            aux.push(this.funcoes.pop());
        }

        int size = aux.size();

        if(size > 0)
            for(int i = 0; i < size; i++) this.funcoes.push(aux.pop());
        
        return funcao;
    }

    private void inserir_tabela_tipos(String valor1, String valor2)
    {
        String elemento[] = new String[2];
        elemento[0] = valor1;
        elemento[1] = valor2.trim();
        this.tabela_tipos.push(elemento);
    }

    @Override
    public void inAPrograma(APrograma node)
    {
        Hashtable<String, String> leianumero = new Hashtable<String, String>();
        // System.out.println("Inserindo função: leiaNumero -> Numero");
        leianumero.put("nome", "leiaNumero");
        leianumero.put("retorno", "Numero");
        leianumero.put("parametros", "falso");
        this.funcoes.push(leianumero);
        
        Hashtable<String, String> leiatexto = new Hashtable<String, String>();
        // System.out.println("Inserindo função: leiaTexto -> Texto");
        leiatexto.put("nome", "leiaTexto");
        leiatexto.put("retorno", "Texto");
        leiatexto.put("parametros", "falso");
        this.funcoes.push(leiatexto);
    }

    @Override
    public void inARelacao(ARelacao node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        TIdMolde esquerdo = node.getEsquerdo();
        TIdMolde direito = node.getDireito();

        if(!escopo_atual.containsKey(direito.toString()))
        {
            // System.out.println("Adicionando " + direito.toString() + "como filha de Todos");
            escopo_atual.put(direito.toString(), "Todos");
        }

        if(!escopo_atual.containsKey(esquerdo.toString()))
        {
            // System.out.println("Adicionando " + esquerdo.toString() + "como filha de " + direito.toString());
            escopo_atual.put(esquerdo.toString(), direito.toString());
        }
        else
        {
            throw new RuntimeException("Molde " + esquerdo.toString() + "já declarado");
        }

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inADefMolde(ADefMolde node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        TIdMolde molde = node.getIdMolde();

        if(!escopo_atual.containsKey(molde.toString()))
        {
            // System.out.println("Adicionando " + molde.toString() + "como filha de Todos");
            escopo_atual.put(molde.toString(), "Todos");
        }

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        Hashtable<String, String> novo_escopo = new Hashtable<String, String>();

        PTipo retorno_funcao = node.getTipo();
        TId nome_funcao = node.getId();

        if(!this.existe(this.tabela_simbolos, nome_funcao.toString(), true))
        {
            // System.out.println("Adicionando função: " + nome_funcao.toString() + "-> " + retorno_funcao.toString());
            novo_escopo.put(nome_funcao.toString(), retorno_funcao.toString());

            this.tabela_simbolos.push(novo_escopo);
        }
        else
        {
            throw new RuntimeException("Função " + nome_funcao.toString() + "já declarada");
        }
    }

    @Override
    public void outAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        TId funcao = node.getId();

        // System.out.println("Removendo escopo da função " + funcao.toString());
        this.tabela_simbolos.pop();
    }

    @Override
    public void inAIdParametro(AIdParametro node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        PTipo tipo = node.getTipo();
        TId id = node.getId();

        // System.out.println("Adicionando parâmetro: " + id.toString() + "-> " + tipo.toString());
        
        escopo_atual.put(id.toString(), tipo.toString());

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        PTipoPrimitivo tipo = node.getTipoPrimitivo();
        TId id = node.getId();

        if(!escopo_atual.containsKey(id.toString()))
        {
            // System.out.println("Adicionando constante: " + id.toString() + "-> " + tipo.toString());
            escopo_atual.put(id.toString(), tipo.toString());
        }
        else
        {
            throw new RuntimeException("Constante " + id.toString() + "já declarada");
        }

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override
    public void inAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        PTipoMolde molde = node.getTipoMolde();
        TId id = node.getId();

        if(!escopo_atual.containsKey(id.toString()))
        {
            if(escopo_atual.containsKey(molde.toString()))
            {
                // System.out.println("Adicionando objeto: " + id.toString() + "-> " + molde.toString());
                escopo_atual.put(id.toString(), molde.toString());
            }
            else
            {
                throw new RuntimeException("Tipo molde " + molde.toString() + "não declarado");
            }
        }
        else
        {
            throw new RuntimeException("Id " + id.toString() + "já existente");
        }
    }

    @Override
    public void inADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        
    }

    @Override
    public void outAListaExp(AListaExp node)
    {
        int tamanho_lista = node.getDireito().size() + 1;
        this.inserir_tabela_tipos(Integer.toString(tamanho_lista), "Numero");
    }

    @Override
    public void outAChamadaExp(AChamadaExp node)
    {
        String elemento[] = this.tabela_tipos.pop();
        int desempilhar = Integer.parseInt(elemento[0]);
        String funcao_chamada = node.getId().toString().trim();

        if(this.existe(this.funcoes, funcao_chamada, false))
        {
            Hashtable<String, String> funcao = this.obter_funcao(funcao_chamada);
            if(funcao.get("parametros").intern() == "verdade") System.out.println("Aceita parametros");
            else throw new RuntimeException("Função " + funcao_chamada + " não aceita parâmetros, mas " + desempilhar + " foram passados");
        }
    }

    @Override
    public void outAIdExp(AIdExp node)
    {
        TId id = node.getId();

        if(this.existe(this.tabela_simbolos, id.toString(), true))
        {
            String tipo_id = this.obter_valor_chave(id.toString());
            this.inserir_tabela_tipos(id.toString().replace(" ", ""), tipo_id);
        }
        else
        {
            throw new RuntimeException("Variável " + id.toString() + "não declarada");
        }
    }

    @Override
    public void outAVerdadeExp(AVerdadeExp node)
    {
        TVerdade verdade = node.getVerdade();
        this.inserir_tabela_tipos(verdade.toString().replace(" ", ""), "Bool");
    }

    @Override
    public void outAFalsoExp(AFalsoExp node)
    {
        TFalso falso = node.getFalso();
        this.inserir_tabela_tipos(falso.toString().replace(" ", ""), "Bool");
    }

    @Override
    public void outANumeroExp(ANumeroExp node)
    {
        TNumero numero = node.getNumero();
        this.inserir_tabela_tipos(numero.toString().replace(" ", ""), "Numero");
    }

    @Override
    public void outASomaExp(ASomaExp node)
    {
        String elemento1[] = this.tabela_tipos.pop();
        String elemento2[] = this.tabela_tipos.pop();

        if(elemento1[1].intern() == "Numero")
        {
            if(!(elemento2[1].intern() == "Numero"))
            {
                throw new RuntimeException("Impossível realizar soma entre Numero e " + elemento2[1]);
            }
            else
            {
                // System.out.println("Soma: " + elemento1[0] + " + " + elemento2[0]);
                String soma = "( " + elemento1[0] + " + " + elemento2[0] + " )";
                this.inserir_tabela_tipos(soma, "Numero");
            }
        }
        else
        {
            throw new RuntimeException("Tipo " + elemento1[1] + "não pertence à uma soma");
        }
    }

    @Override
    public void outASubtracaoExp(ASubtracaoExp node)
    {
        String elemento1[] = this.tabela_tipos.pop();
        String elemento2[] = this.tabela_tipos.pop();

        if(elemento1[1].intern() == "Numero")
        {
            if(!(elemento2[1].intern() == "Numero"))
            {
                throw new RuntimeException("Impossível realizar subtração entre Numero e " + elemento2[1]);
            }
            else
            {
                // System.out.println("Subtração: " + elemento1[0] + " - " + elemento2[0]);
                String subtracao = "( " + elemento1[0] + " - " + elemento2[0] + " )";
                this.inserir_tabela_tipos(subtracao, "Numero");
            }
        }
        else
        {
            throw new RuntimeException("Tipo " + elemento1[1] + " não pertence à uma subtração");
        }
    }
}
