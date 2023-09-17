/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import java.util.*;
import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AAtributos extends PAtributos
{
    private final LinkedList<PBllocoFecho> _bllocoFecho_ = new LinkedList<PBllocoFecho>();

    public AAtributos()
    {
        // Constructor
    }

    public AAtributos(
        @SuppressWarnings("hiding") List<?> _bllocoFecho_)
    {
        // Constructor
        setBllocoFecho(_bllocoFecho_);

    }

    @Override
    public Object clone()
    {
        return new AAtributos(
            cloneList(this._bllocoFecho_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAtributos(this);
    }

    public LinkedList<PBllocoFecho> getBllocoFecho()
    {
        return this._bllocoFecho_;
    }

    public void setBllocoFecho(List<?> list)
    {
        for(PBllocoFecho e : this._bllocoFecho_)
        {
            e.parent(null);
        }
        this._bllocoFecho_.clear();

        for(Object obj_e : list)
        {
            PBllocoFecho e = (PBllocoFecho) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._bllocoFecho_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._bllocoFecho_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._bllocoFecho_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PBllocoFecho> i = this._bllocoFecho_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PBllocoFecho) newChild);
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
