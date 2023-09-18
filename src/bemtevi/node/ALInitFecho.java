/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class ALInitFecho extends PLInitFecho
{
    private PInitObjeto _initObjeto_;

    public ALInitFecho()
    {
        // Constructor
    }

    public ALInitFecho(
        @SuppressWarnings("hiding") PInitObjeto _initObjeto_)
    {
        // Constructor
        setInitObjeto(_initObjeto_);

    }

    @Override
    public Object clone()
    {
        return new ALInitFecho(
            cloneNode(this._initObjeto_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALInitFecho(this);
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._initObjeto_);
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

        throw new RuntimeException("Not a child.");
    }
}
