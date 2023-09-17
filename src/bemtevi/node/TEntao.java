/* This file was generated by SableCC (http://www.sablecc.org/). */

package bemtevi.node;

import bemtevi.analysis.*;

@SuppressWarnings("nls")
public final class TEntao extends Token
{
    public TEntao()
    {
        super.setText("entao");
    }

    public TEntao(int line, int pos)
    {
        super.setText("entao");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TEntao(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTEntao(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TEntao text.");
    }
}
