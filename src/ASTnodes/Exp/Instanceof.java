package ASTnodes.Exp;

import TypeDescriptor.TypeDescriptor;

public class Instanceof extends Exp{

	public Instanceof(TypeDescriptor type, Exp exp) {
		super(type);
		this.exp = exp;
	}

	private Exp exp;

	public Exp getExp() {
		return exp;
	}

	public void setExp(Exp exp) {
		this.exp = exp;
	}
}

