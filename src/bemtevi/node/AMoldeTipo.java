/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AMoldeTipo extends PTipo
{
    private PTipoMolde _tipoMolde_;

    public AMoldeTipo()
    {
        // Constructor
    }

    public AMoldeTipo(
        @SuppressWarnings("hiding") PTipoMolde _tipoMolde_)
    {
        // Constructor
        setTipoMolde(_tipoMolde_);

    }

    @Override
    public Object clone()
    {
        return new AMoldeTipo(
            cloneNode(this._tipoMolde_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMoldeTipo(this);
    }

    public PTipoMolde getTipoMolde()
    {
        return this._tipoMolde_;
    }

    public void setTipoMolde(PTipoMolde node)
    {
        if(this._tipoMolde_ != null)
        {
            this._tipoMolde_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tipoMolde_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tipoMolde_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tipoMolde_ == child)
        {
            this._tipoMolde_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tipoMolde_ == oldChild)
        {
            setTipoMolde((PTipoMolde) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
