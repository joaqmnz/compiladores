import bemtevi.analysis.*;
import bemtevi.node.*;
import java.util.*;

public class Semantico extends DepthFirstAdapter
{
    private Stack<Hashtable<String, Integer>> pilha = new Stack<Hashtable<String, Integer>>();

    public Semantico()
    {
        
    }

    @Override
    public void inStart(Start node)
    {
        System.out.println("Início da análise semântica\n\n");
    }

    @Override
    public void outStart(Start node)
    {
        System.out.println("\n\nFim da análise semântica");
    }

    @Override
    public void inAFamilia(AFamilia node)
    {
        System.out.println("Entrando em familia\n");
    }

    @Override
    public void outAFamilia(AFamilia node)
    {
        System.out.println("Saindo de familia");
    }
    
    @Override
    public void inARelacao(ARelacao node)
    {
        System.out.println("Entrando em relacao");
    }

    @Override
    public void outARelacao(ARelacao node)
    {
        TIdMolde direito = node.getDireito();
        TIdMolde esquerdo = node.getEsquerdo();

        System.out.println("Direito: " + direito.toString());
        System.out.println("Esquerdo: " + esquerdo.toString());

        System.out.println("Saindo de relacao\n");
    }
}
