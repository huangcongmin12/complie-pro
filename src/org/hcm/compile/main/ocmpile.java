package org.hcm.compile.main;

import java.io.IOException;

import org.hcm.compile.lexing.LexAnalyse;
import org.hcm.compile.parsing.Parser;
import org.hcm.compile.utils.FileInput;

/**
 * 
 * @author HCM
 *
 */
public class ocmpile {
	public static void main(String[] args) throws IOException {
		String fileName = "test00.c";
		lexAnalyse(fileName);
		if (parser(fileName)) {
			fourElem(fileName);
		} else {
			System.out.println("\n语法分析出错，不能生成四元式");
		}
	}

	/**
	 * 词法分析
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void lexAnalyse(String fileName) throws IOException {
		LexAnalyse lex = new LexAnalyse();
		lex.lexAnalyse1(fileName);
		System.out.println("输出信息到文件：" + lex.outputWordList() + "\n");
	}

	/**
	 * 语法分析
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static boolean parser(String fileName) throws IOException {
		Parser parser = new Parser(new LexAnalyse(FileInput.readFile(fileName)));
		parser.grammerAnalyse();
		System.out.println("输出信息到文件：" + parser.outputLL1() + "\n");
		return true;
	}

	/**
	 * 生成四元式
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public static void fourElem(String fileName) throws IOException {
		Parser parser = new Parser(new LexAnalyse(FileInput.readFile(fileName)));
		parser.grammerAnalyse();
		System.out.println("输出信息到文件：" + parser.outputFourElem());
	}

}
