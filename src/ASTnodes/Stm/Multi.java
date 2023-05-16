package ASTnodes.Stm;

import java.util.ArrayList;
import TypeDescriptor.TypeDescriptor;

public class Multi extends Stm{
	public Multi(TypeDescriptor type, ArrayList<Stm> stms) {
		super(type);
		this.stms = stms;
	}

	private ArrayList<Stm> stms;

	public ArrayList<Stm> getStms() {
		return stms;
	}

	public void setStms(ArrayList<Stm> stms) {
		this.stms = stms;
	}

}
