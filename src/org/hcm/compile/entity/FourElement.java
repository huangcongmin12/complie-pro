package org.hcm.compile.entity;

/**
 * 四元式节点
 */
public class FourElement {
	
	public int id;
	public String op;
	public String arg1;
	public String arg2;
	public Object result;

	public FourElement() {
	}

	public FourElement(int id, String op, String arg1, String arg2, String result) {
		this.id = id;
		this.op = op;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.result = result;
	}
}
