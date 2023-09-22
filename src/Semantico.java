import bemtevi.analysis.*;
import bemtevi.node.*;

public class Semantico extends DepthFirstAdapter
{
    public Semantico(){}

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

    
    
}
