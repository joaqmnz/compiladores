/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import java.util.*;
import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AParametrosAssinatura extends PParametrosAssinatura
{
    private PParametroAssinatura _esquerdo_;
    private final LinkedList<PParametroAssinatura> _direito_ = new LinkedList<PParametroAssinatura>();

    public AParametrosAssinatura()
    {
        // Constructor
    }

    public AParametrosAssinatura(
        @SuppressWarnings("hiding") PParametroAssinatura _esquerdo_,
        @SuppressWarnings("hiding") List<?> _direito_)
    {
        // Constructor
        setEsquerdo(_esquerdo_);

        setDireito(_direito_);

    }

    @Override
    public Object clone()
    {
        return new AParametrosAssinatura(
            cloneNode(this._esquerdo_),
            cloneList(this._direito_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParametrosAssinatura(this);
    }

    public PParametroAssinatura getEsquerdo()
    {
        return this._esquerdo_;
    }

    public void setEsquerdo(PParametroAssinatura node)
    {
        if(this._esquerdo_ != null)
        {
            this._esquerdo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._esquerdo_ = node;
    }

    public LinkedList<PParametroAssinatura> getDireito()
    {
        return this._direito_;
    }

    public void setDireito(List<?> list)
    {
        for(PParametroAssinatura e : this._direito_)
        {
            e.parent(null);
        }
        this._direito_.clear();

        for(Object obj_e : list)
        {
            PParametroAssinatura e = (PParametroAssinatura) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._direito_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._esquerdo_)
            + toString(this._direito_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._esquerdo_ == child)
        {
            this._esquerdo_ = null;
            return;
        }

        if(this._direito_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._esquerdo_ == oldChild)
        {
            setEsquerdo((PParametroAssinatura) newChild);
            return;
        }

        for(ListIterator<PParametroAssinatura> i = this._direito_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PParametroAssinatura) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
