/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import java.util.*;
import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AAtributos extends PAtributos
{
    private final LinkedList<PBlocoFecho> _blocoFecho_ = new LinkedList<PBlocoFecho>();

    public AAtributos()
    {
        // Constructor
    }

    public AAtributos(
        @SuppressWarnings("hiding") List<?> _blocoFecho_)
    {
        // Constructor
        setBlocoFecho(_blocoFecho_);

    }

    @Override
    public Object clone()
    {
        return new AAtributos(
            cloneList(this._blocoFecho_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAtributos(this);
    }

    public LinkedList<PBlocoFecho> getBlocoFecho()
    {
        return this._blocoFecho_;
    }

    public void setBlocoFecho(List<?> list)
    {
        for(PBlocoFecho e : this._blocoFecho_)
        {
            e.parent(null);
        }
        this._blocoFecho_.clear();

        for(Object obj_e : list)
        {
            PBlocoFecho e = (PBlocoFecho) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._blocoFecho_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._blocoFecho_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._blocoFecho_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PBlocoFecho> i = this._blocoFecho_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PBlocoFecho) newChild);
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
