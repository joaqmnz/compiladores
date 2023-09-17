/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class APrimitivoTipo extends PTipo
{
    private PTipoPrimitivo _tipoPrimitivo_;

    public APrimitivoTipo()
    {
        // Constructor
    }

    public APrimitivoTipo(
        @SuppressWarnings("hiding") PTipoPrimitivo _tipoPrimitivo_)
    {
        // Constructor
        setTipoPrimitivo(_tipoPrimitivo_);

    }

    @Override
    public Object clone()
    {
        return new APrimitivoTipo(
            cloneNode(this._tipoPrimitivo_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPrimitivoTipo(this);
    }

    public PTipoPrimitivo getTipoPrimitivo()
    {
        return this._tipoPrimitivo_;
    }

    public void setTipoPrimitivo(PTipoPrimitivo node)
    {
        if(this._tipoPrimitivo_ != null)
        {
            this._tipoPrimitivo_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tipoPrimitivo_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tipoPrimitivo_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tipoPrimitivo_ == child)
        {
            this._tipoPrimitivo_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tipoPrimitivo_ == oldChild)
        {
            setTipoPrimitivo((PTipoPrimitivo) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
