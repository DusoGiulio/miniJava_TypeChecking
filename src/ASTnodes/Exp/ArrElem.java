package ASTnodes.Exp;

import TypeDescriptor.TypeDescriptor;

public class ArrElem extends Cast{

	private Exp expEl;

	public ArrElem(TypeDescriptor type, Exp exp, Exp expEl) {
		super(type, exp);
		this.setExpEl(expEl);
	}

	public Exp getExpEl() {
		return expEl;
	}

	public void setExpEl(Exp expEl) {
		this.expEl = expEl;
	}

}
