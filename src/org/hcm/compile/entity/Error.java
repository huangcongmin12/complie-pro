package org.hcm.compile.entity;

/**
 * 错误信息类
 * 
 * @author HCM
 */
public class Error {
	
	/**
	 * 错误序号
	 */
	public int id; 		
	
	/**
	 * 错误信息
	 */
	public String info; 
	
	/**
	 * 错误所在行
	 */
	public int line;
	
	/**
	 * 错误的单词
	 */
	public Word word; 

	public Error() {

	}

	public Error(int id, String info, int line, Word word) {
		this.id = id;
		this.info = info;
		this.line = line;
		this.word = word;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}
	
}
