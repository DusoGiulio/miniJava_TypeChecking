package ASTnodes.Stm;

import ASTnodes.Exp.Exp;
import TypeDescriptor.TypeDescriptor;

public class ASSIGN extends Stm{
	public ASSIGN(TypeDescriptor type, /*Exp dotExp,*/Exp exp, String id) {
		super(type);
		this.exp=exp;
		this.id= id;
		//this.dotExp=dotExp;
	}
	private String id;
	private Exp exp;
	//private Exp dotExp;

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

/*	public Exp getDotExp() {
		return dotExp;
	}

	public void setDotExp(Exp dotExp) {
		this.dotExp = dotExp;
	}*/
	

}
