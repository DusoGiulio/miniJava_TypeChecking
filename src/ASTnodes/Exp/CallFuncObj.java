package ASTnodes.Exp;

import java.util.ArrayList;

import TypeDescriptor.TypeDescriptor;

public class CallFuncObj extends Exp{

	public CallFuncObj(TypeDescriptor type, Exp lexp, ArrayList<Exp> list) {
		super(type);
		this.lexp = lexp;
		this.rexp = list;
	}
	private Exp lexp;
	private ArrayList<Exp> rexp;
	public Exp getLexp() {
		return lexp;
	}
	public void setLexp(Exp lexp) {
		this.lexp = lexp;
	}
	public ArrayList<Exp> getRexp() {
		return rexp;
	}
	public void setRexp(ArrayList<Exp> rexp) {
		this.rexp = rexp;
	}

}
