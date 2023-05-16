package ASTnodes.Stm;

import ASTnodes.Exp.Exp;
import TypeDescriptor.TypeDescriptor;

public class SOP extends Stm {

	public SOP(TypeDescriptor type, Exp exp ,String id) {
		super(type);
		this.exp=exp;
		this.id= id;
	}
	private String id;
	private Exp exp;

	public Exp getLExp() {
		return exp;
	}

	public void setLExp(Exp exp) {
		this.exp = exp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
