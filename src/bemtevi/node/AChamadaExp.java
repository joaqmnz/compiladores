/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import java.util.*;
import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AChamadaExp extends PExp
{
    private final LinkedList<PIdFecho> _idFecho_ = new LinkedList<PIdFecho>();
    private PListaExp _listaExp_;

    public AChamadaExp()
    {
        // Constructor
    }

    public AChamadaExp(
        @SuppressWarnings("hiding") List<?> _idFecho_,
        @SuppressWarnings("hiding") PListaExp _listaExp_)
    {
        // Constructor
        setIdFecho(_idFecho_);

        setListaExp(_listaExp_);

    }

    @Override
    public Object clone()
    {
        return new AChamadaExp(
            cloneList(this._idFecho_),
            cloneNode(this._listaExp_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAChamadaExp(this);
    }

    public LinkedList<PIdFecho> getIdFecho()
    {
        return this._idFecho_;
    }

    public void setIdFecho(List<?> list)
    {
        for(PIdFecho e : this._idFecho_)
        {
            e.parent(null);
        }
        this._idFecho_.clear();

        for(Object obj_e : list)
        {
            PIdFecho e = (PIdFecho) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._idFecho_.add(e);
        }
    }

    public PListaExp getListaExp()
    {
        return this._listaExp_;
    }

    public void setListaExp(PListaExp node)
    {
        if(this._listaExp_ != null)
        {
            this._listaExp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listaExp_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._idFecho_)
            + toString(this._listaExp_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._idFecho_.remove(child))
        {
            return;
        }

        if(this._listaExp_ == child)
        {
            this._listaExp_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PIdFecho> i = this._idFecho_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PIdFecho) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._listaExp_ == oldChild)
        {
            setListaExp((PListaExp) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}