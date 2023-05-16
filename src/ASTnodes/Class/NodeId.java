package ASTnodes.Class;

import TypeDescriptor.TypeDescriptor;

public class NodeId extends NodeAST {

	private String name;
	
	public NodeId(TypeDescriptor type,String name) {
		super(type);
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
