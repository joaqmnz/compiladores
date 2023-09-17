/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class AFamiliaInicio extends PInicio
{
    private PFamilia _familia_;

    public AFamiliaInicio()
    {
        // Constructor
    }

    public AFamiliaInicio(
        @SuppressWarnings("hiding") PFamilia _familia_)
    {
        // Constructor
        setFamilia(_familia_);

    }

    @Override
    public Object clone()
    {
        return new AFamiliaInicio(
            cloneNode(this._familia_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFamiliaInicio(this);
    }

    public PFamilia getFamilia()
    {
        return this._familia_;
    }

    public void setFamilia(PFamilia node)
    {
        if(this._familia_ != null)
        {
            this._familia_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._familia_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._familia_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._familia_ == child)
        {
            this._familia_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._familia_ == oldChild)
        {
            setFamilia((PFamilia) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
