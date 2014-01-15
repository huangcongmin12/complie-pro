package org.hcm.compile.entity;

/**
 * 错误信息类
 */
public class Error {
	public int id; 		// 错误序号；
	public String info;	// 错误信息；
	public int line;	// 错误所在行
	public Word word;	// 错误的单词

	public Error() {

	}

	public Error(int id, String info, int line, Word word) {
		this.id = id;
		this.info = info;
		this.line = line;
		this.word = word;
	}
}
