/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import java.util.*;
import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AInitListaInit extends PListaInit
{
    private PInitObjeto _initObjeto_;
    private final LinkedList<PLInitFecho> _lInitFecho_ = new LinkedList<PLInitFecho>();

    public AInitListaInit()
    {
        // Constructor
    }

    public AInitListaInit(
        @SuppressWarnings("hiding") PInitObjeto _initObjeto_,
        @SuppressWarnings("hiding") List<?> _lInitFecho_)
    {
        // Constructor
        setInitObjeto(_initObjeto_);

        setLInitFecho(_lInitFecho_);

    }

    @Override
    public Object clone()
    {
        return new AInitListaInit(
            cloneNode(this._initObjeto_),
            cloneList(this._lInitFecho_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInitListaInit(this);
    }

    public PInitObjeto getInitObjeto()
    {
        return this._initObjeto_;
    }

    public void setInitObjeto(PInitObjeto node)
    {
        if(this._initObjeto_ != null)
        {
            this._initObjeto_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._initObjeto_ = node;
    }

    public LinkedList<PLInitFecho> getLInitFecho()
    {
        return this._lInitFecho_;
    }

    public void setLInitFecho(List<?> list)
    {
        for(PLInitFecho e : this._lInitFecho_)
        {
            e.parent(null);
        }
        this._lInitFecho_.clear();

        for(Object obj_e : list)
        {
            PLInitFecho e = (PLInitFecho) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._lInitFecho_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._initObjeto_)
            + toString(this._lInitFecho_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._initObjeto_ == child)
        {
            this._initObjeto_ = null;
            return;
        }

        if(this._lInitFecho_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._initObjeto_ == oldChild)
        {
            setInitObjeto((PInitObjeto) newChild);
            return;
        }

        for(ListIterator<PLInitFecho> i = this._lInitFecho_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PLInitFecho) newChild);
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