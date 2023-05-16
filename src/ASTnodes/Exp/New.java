package ASTnodes.Exp;

import TypeDescriptor.TypeDescriptor;

public class New extends Exp{
	private Exp exp;
	public New(TypeDescriptor type, Exp exp) {
		super(type);
		this.exp = exp;
	}
	

	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}

}
