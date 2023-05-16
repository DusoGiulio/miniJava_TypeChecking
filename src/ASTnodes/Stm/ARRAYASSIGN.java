package ASTnodes.Stm;

import ASTnodes.Exp.Exp;
import TypeDescriptor.TypeDescriptor;

public class ARRAYASSIGN extends ASSIGN{

	public ARRAYASSIGN(TypeDescriptor type,/*Exp dotexp, */ Exp lexp, Exp rexp, String id) {
		super(type,lexp,id);
		this.rexp = rexp;
		//this.dotexp=dotexp;
		
	}
	private Exp rexp;
	//private Exp dotexp;

	public Exp getRexp() {
		return rexp;
	}
	public void setRexp(Exp rexp) {
		this.rexp = rexp;
	}
	/*public Exp getDotExp() {
		return dotexp;
	}
	public void setDotExp(Exp lexp) {
		this.dotexp = lexp;
	}*/
}
