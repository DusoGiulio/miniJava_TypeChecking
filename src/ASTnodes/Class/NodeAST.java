package ASTnodes.Class;

import TypeDescriptor.TypeDescriptor;

public  abstract class NodeAST {
	public NodeAST(TypeDescriptor type) {
		super();
		this.type = type;
	}

	private TypeDescriptor type;

	public TypeDescriptor getType() {
		return type;
	}

	public void setType(TypeDescriptor type) {
		this.type = type;
	}
}
