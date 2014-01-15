package org.hcm.compile.entity;

import java.util.ArrayList;

/**
 * 单词类
 * 
 * @author HCM
 */
public class Word {
	public final static String KEY = "关键字";
	public final static String OPERATOR = "运算符";
	public final static String INT_CONST = "整形常量";
	public final static String CHAR_CONST = "字符常量";
	public final static String BOOL_CONST = "布尔常量";
	public final static String IDENTIFIER = "标志符";
	public final static String BOUNDARYSIGN = "界符";
	public final static String END = "结束符";
	public final static String UNIDEF = "未知类型";

	/**
	 * 关键字集合
	 */
	public static ArrayList<String> key = new ArrayList<String>();

	/**
	 * 界符集合
	 */
	public static ArrayList<String> boundarySign = new ArrayList<String>();

	/**
	 * 运算符集合
	 */
	public static ArrayList<String> operator = new ArrayList<String>();

	/**
	 * 单词编号
	 */
	public int id;

	/**
	 * 单词的值
	 */
	public String value;

	/**
	 * 单词类型
	 */
	public String type;

	/**
	 * 单词所在行
	 */
	public int line;

	public boolean flag = true;

	static {
		Word.operator.add("+");
		Word.operator.add("-");
		Word.operator.add("++");
		Word.operator.add("--");
		Word.operator.add("*");
		Word.operator.add("/");
		Word.operator.add(">");
		Word.operator.add("<");
		Word.operator.add(">=");
		Word.operator.add("<=");
		Word.operator.add("==");
		Word.operator.add("!=");
		Word.operator.add("=");
		Word.operator.add("&&");
		Word.operator.add("||");
		Word.operator.add("!");
		Word.operator.add(".");
		Word.operator.add("?");
		Word.operator.add("|");
		Word.operator.add("&");
		Word.boundarySign.add("(");
		Word.boundarySign.add(")");
		Word.boundarySign.add("{");
		Word.boundarySign.add("}");
		Word.boundarySign.add(";");
		Word.boundarySign.add(",");
		Word.key.add("void");
		Word.key.add("main");
		Word.key.add("int");
		Word.key.add("char");
		Word.key.add("if");
		Word.key.add("else");
		Word.key.add("while");
		Word.key.add("for");
		Word.key.add("printf");
		Word.key.add("scanf");
	}

	public Word() {
	}

	public Word(int id, String value, String type, int line) {
		this.id = id;
		this.value = value;
		this.type = type;
		this.line = line;
	}

	/**
	 * 判断单词是否为关键字
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isKey(String word) {
		return key.contains(word);
	}

	/**
	 * 判断单词是否为操作符
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isOperator(String word) {
		return operator.contains(word);
	}

	/**
	 * 判断单词是否为界符
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isBoundarySign(String word) {
		return boundarySign.contains(word);
	}

	/**
	 * 判断单词是否为算术运算符
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isArOP(String word) {
		if ((word.equals("+") || word.equals("-") || word.equals("*") || word.equals("/")))
			return true;
		else
			return false;
	}

	/**
	 * 判断单词是否为布尔运算符
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isBoolOP(String word) {
		if ((word.equals(">") || word.equals("<") || word.equals("==") || word.equals("!=") || word.equals("!") || word.equals("&&") || word
				.equals("||")))
			return true;
		else
			return false;
	}
}
