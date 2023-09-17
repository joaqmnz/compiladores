/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import java.util.*;
import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AExpListaExp extends PListaExp
{
    private PExp _exp_;
    private final LinkedList<PLExpFecho> _lExpFecho_ = new LinkedList<PLExpFecho>();

    public AExpListaExp()
    {
        // Constructor
    }

    public AExpListaExp(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") List<?> _lExpFecho_)
    {
        // Constructor
        setExp(_exp_);

        setLExpFecho(_lExpFecho_);

    }

    @Override
    public Object clone()
    {
        return new AExpListaExp(
            cloneNode(this._exp_),
            cloneList(this._lExpFecho_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpListaExp(this);
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public LinkedList<PLExpFecho> getLExpFecho()
    {
        return this._lExpFecho_;
    }

    public void setLExpFecho(List<?> list)
    {
        for(PLExpFecho e : this._lExpFecho_)
        {
            e.parent(null);
        }
        this._lExpFecho_.clear();

        for(Object obj_e : list)
        {
            PLExpFecho e = (PLExpFecho) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._lExpFecho_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._lExpFecho_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._lExpFecho_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        for(ListIterator<PLExpFecho> i = this._lExpFecho_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PLExpFecho) newChild);
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
