import bemtevi.analysis.*;
import bemtevi.node.*;
import java.util.*;
import utils.Molde.*;
import utils.Tipos.Abstrato.Molde;
import utils.Arvore.ArvoreFamilia;

public class Semantico extends DepthFirstAdapter
{
    private boolean inserirAtributosMolde; // variavel para inserir informacoes do molde em constante e objeto
    private ArvoreFamilia familia; // arvore das familias
    private Stack<Hashtable<String, String>> tabela_simbolos;
    private Stack<Molde> moldes; // pilha de moldes
    private Stack<Hashtable<String, String>> funcoes;
    private Stack<String[]> tabela_tipos;
    
    public Semantico()
    {
        this.inserirAtributosMolde = true;

        this.familia = new ArvoreFamilia("Todos");

        this.tabela_simbolos = new Stack<Hashtable<String, String>>();
        this.tabela_simbolos.push(new Hashtable<String, String>());

        this.moldes = new Stack<Molde>();

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

    private boolean existeMolde(String idMolde)
    {
        Stack<Molde> aux = new Stack<Molde>();
        boolean existe = false;
        int size = this.moldes.size();

        for(int i = 0; i < size; i++)
        {
            Molde moldeAtual = this.moldes.peek();

            if(moldeAtual.getNome().intern() == idMolde.intern())
            {
                existe = true;
                break;
            }
            
            aux.push(this.moldes.pop());
        }

        size = aux.size();

        if(size > 0)
            for(int i = 0; i < size; i++) this.moldes.push(aux.pop());

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

    private void inserirMolde(Molde molde)
    {
        if(!this.existeMolde(molde.getNome()))
        {
            this.moldes.push(molde);
        }
        else throw new RuntimeException("[ERRO] Molde '" + molde.getNome() + "' já declarado");
    }

    private void inserirInformacaoMolde(EscopoMolde informacao)
    {
        Molde molde_atual = this.moldes.pop();
        molde_atual.inserirInformacao(informacao);
        this.moldes.push(molde_atual);
    }

    @Override
    public void inAPrograma(APrograma node)
    {
        Hashtable<String, String> leianumero = new Hashtable<String, String>();
        System.out.println("Inserindo função: leiaNumero -> Numero");
        leianumero.put("nome", "leiaNumero");
        leianumero.put("retorno", "Numero");
        leianumero.put("parametros", "falso");
        this.funcoes.push(leianumero);
        
        Hashtable<String, String> leiatexto = new Hashtable<String, String>();
        System.out.println("Inserindo função: leiaTexto -> Texto");
        leiatexto.put("nome", "leiaTexto");
        leiatexto.put("retorno", "Texto");
        leiatexto.put("parametros", "falso");
        this.funcoes.push(leiatexto);
    }

    @Override // OK
    public void inARelacao(ARelacao node)
    {
        String esquerdo = node.getEsquerdo().toString().trim();
        String direito = node.getDireito().toString().trim();

        if(!this.familia.existeMolde(direito))
        {
            this.familia.inserir(direito);
            this.familia.inserirFilho(direito, esquerdo);
        }
        else this.familia.inserirFilho(direito, esquerdo);
    }

    @Override //OK
    public void inADefMolde(ADefMolde node)
    {
        Hashtable<String, String> novo_escopo = new Hashtable<String, String>();
        this.tabela_simbolos.push(novo_escopo);

        String idMolde = node.getIdMolde().toString().trim();
        Molde molde = new Molde(idMolde);
        this.inserirMolde(molde);
    }

    @Override
    public void inAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        Hashtable<String, String> novo_escopo = new Hashtable<String, String>();

        PTipo retorno_funcao = node.getTipo();
        TId nome_funcao = node.getId();

        if(!this.existe(this.tabela_simbolos, nome_funcao.toString(), true))
        {
            System.out.println("Adicionando função: " + nome_funcao.toString() + "-> " + retorno_funcao.toString());
            novo_escopo.put(nome_funcao.toString(), retorno_funcao.toString());

            this.tabela_simbolos.push(novo_escopo);
        }
        else
        {
            throw new RuntimeException("Função " + nome_funcao.toString() + "já declarada");
        }

        this.inserirAtributosMolde = false;
    }

    @Override
    public void outAFunc1DecFuncao(AFunc1DecFuncao node)
    {
        System.out.println("Removendo escopo da função " + node.getId().toString());
        this.tabela_simbolos.pop();
    }

    @Override //OK
    public void outAParametros(AParametros node)
    {
        Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();

        int retirar = node.getDireito().size() + 1;
        for(int i = 0; i < retirar; i++)
        {
            String elemento[] = this.tabela_tipos.pop();
            if(!escopo_atual.containsKey(elemento[0]))
            {
                System.out.println("[INSERÇÃO] Adicionando parâmetro '" + elemento[0] + "' -> " + elemento[1]);
                escopo_atual.put(elemento[0], elemento[1]);
            }
            else throw new RuntimeException("[ERRO] Parâmetro '" + elemento[0] + "' já declarado");
        }

        this.tabela_simbolos.push(escopo_atual);
    }

    @Override //OK
    public void inAIdParametro(AIdParametro node)
    {
        String tipo = node.getTipo().toString().trim();
        String id = node.getId().toString().trim();

        this.inserir_tabela_tipos(id, tipo);
    }

    @Override //OK
    public void inAConstanteBlocoFecho(AConstanteBlocoFecho node)
    {
        String tipo = node.getTipoPrimitivo().toString().trim();
        String id = node.getId().toString().trim();

        if(this.inserirAtributosMolde) this.inserirInformacaoMolde(new Constante(id, tipo));
        else
        {
            Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();
            if(!escopo_atual.containsKey(id))
            {
                System.out.println("[INSERÇÃO] Adicionando constante '" + id + "' -> " + tipo);
                escopo_atual.put(id, tipo);
                if(this.inserirAtributosMolde) this.inserirInformacaoMolde(new Constante(id, tipo));
            }
            else
            {
                throw new RuntimeException("[ERRO] Constante '" + id + "' já declarada");
            }

            this.tabela_simbolos.push(escopo_atual);
        }
    }

    @Override //OK
    public void inAObjetoBlocoFecho(AObjetoBlocoFecho node)
    {
        String molde = node.getTipoMolde().toString().trim();
        String id = node.getId().toString().trim();

        if(this.inserirAtributosMolde) this.inserirInformacaoMolde(new Objeto(id, molde));
        else
        {
            Hashtable<String, String> escopo_atual = this.tabela_simbolos.pop();
            if(!escopo_atual.containsKey(id))
            {
                if(this.familia.existeMolde(molde))
                {
                    System.out.println("[INSERÇÃO] Adicionando objeto '" + id + "' -> " + molde);
                    escopo_atual.put(id, molde);
                }
                else
                {
                    throw new RuntimeException("[ERRO] Tipo molde '" + molde + "' não declarado");
                }
            }
            else
            {
                throw new RuntimeException("[ERRO] Id '" + id + "' já declarado");
            }
        }
    }

    @Override
    public void outADefinicaoBlocoFecho(ADefinicaoBlocoFecho node)
    {
        String elemento1[] = this.tabela_tipos.pop();
        String elemento2[] = this.tabela_tipos.pop();

        if(elemento1[1].intern() == elemento2[1].intern())
        {
            System.out.println("Atribuindo: " + elemento2[0] + " = " + elemento1[0]);
        }
        else
        {
            throw new RuntimeException("Não é possível atribuir '" + elemento1[1] + "' a um '" + elemento2[1] + "'");
        }
    }

    @Override
    public void outAIdIdOuAttr(AIdIdOuAttr node)
    {
        String id = node.getId().toString().trim();

        if(this.existe(this.tabela_simbolos, id, true))
        {
            String tipo = this.obter_valor_chave(id);
            this.inserir_tabela_tipos(id, tipo);
        }
        else
            throw new RuntimeException("Variável " + id + "não declarada");
    }

    @Override
    public void outAAtributoIdOuAttr(AAtributoIdOuAttr node)
    {
        String atributo = node.getId().toString().trim();
        if(this.existe(this.tabela_simbolos, atributo, true))
        {
            String tipo = this.obter_valor_chave(atributo);
            if(tipo.intern() != "Numero" && tipo.intern() != "Bool" && tipo.intern() != "Texto")
            {
                int retirar = node.getIdFecho().size();

            }
            else throw new RuntimeException("[ERRO] Variável '" + atributo + "' não é um objeto");
        }
        else throw new RuntimeException("[ERRO] Variável '" + atributo + "' não declarada");

    }

    @Override
    public void outAListaExp(AListaExp node)
    {
        int tamanho_lista = node.getDireito().size() + 1;
        this.inserir_tabela_tipos(Integer.toString(tamanho_lista), "Numero");
    }

    @Override
    public void outAVazioListaExp(AVazioListaExp node)
    {
        this.inserir_tabela_tipos("0", "Numero");
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
            if(funcao.get("parametros").intern() == "verdade".intern())
            {
                System.out.println("Aceita parametros");
            }
            else
            {
                if(desempilhar > 0)
                    throw new RuntimeException("Função " + funcao_chamada + " não aceita parâmetros, mas " + desempilhar + " foram passados");
                else
                    this.inserir_tabela_tipos(funcao_chamada, funcao.get("retorno"));
            }
        }
    }

    @Override
    public void outAIdExp(AIdExp node)
    {
        String id = node.getId().toString().trim();

        if(this.existe(this.tabela_simbolos, id, true))
        {
            String tipo_id = this.obter_valor_chave(id);
            this.inserir_tabela_tipos(id.trim(), tipo_id);
        }
        else
        {
            throw new RuntimeException("Variável " + id + "não declarada");
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
