package ex4;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Regex {
	
	public Map<String, String> rightComment;
	
	public Map<String, String> wrongSLComment;
	
	public Map<String, String> wrongBLIComment;
	
	public Map<String, String> wrongBLEComment;
	
	//String[] errorsInitBlock = { "*/", "/8", "?*", "?8", "?/", "/?" };
	//String[] errorsFimBlock = { "8/", "*?", "8?", "* /" };
	//String[] errorsInline = { "/?", "?/", "/ /", "??", "\\", "\\/"};
	
	public Regex() {
		this.rightComment = new HashMap<>();
		this.wrongSLComment = new HashMap<>();
		this.wrongBLIComment = new HashMap<>();
		this.wrongBLEComment = new HashMap<>();
		
		this.addRegexInArray();
	}
	
	public void addRegexInArray() {
		
		this.rightComment.put("//", "\\/[\\/]+.*"); // SL COMMENT
		this.rightComment.put("/**/", "/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/"); // BL COMMENT
	
		// WRONG SL COMMENT
		this.wrongSLComment.put("/?", "\\/[\\?]+.*");
		this.wrongSLComment.put("?/", "\\?[\\/]+.*");
		this.wrongSLComment.put("/ /", "\\/[ ]+[\\/]+.*");
		this.wrongSLComment.put("??", "\\?[\\?].*");
		this.wrongSLComment.put("\\\\", "\\\\[\\\\]+.*");
		this.wrongSLComment.put("\\/", "\\\\[\\/]+.*"); // \/
		this.wrongSLComment.put("/"+"\\", "\\/[\\\\]+.*"); // /\
		this.wrongSLComment.put("||", "\\|[\\|]+.*"); // ||

		// WRONG BLOCK INIT COMMENT
		this.wrongBLIComment.put("*/", "\\*[\\/]+.*");  //ola mundo */teste*/ 123
		this.wrongBLIComment.put("/8", "\\/[8]+.*");
		this.wrongBLIComment.put("?*", "\\?[\\*]+.*");
		this.wrongBLIComment.put("?8", "\\?[8]+.*");
		this.wrongBLIComment.put("/?", "\\/[\\?]+.*");
	
		
		// WRONG BLOCK END COMMENT
		this.wrongBLEComment.put("/*", "\\/[//*]+.*");
		this.wrongBLEComment.put("8/", "8[\\/]");
		this.wrongBLEComment.put("*?", "\\*[\\?]");
		this.wrongBLEComment.put("8?", "8[\\?]");
		this.wrongBLEComment.put("* /", "\\*[ ][\\/]");

		
	}
	
	public Boolean checkIfCommentIsRight(String code) {
		for(Map.Entry<String, String> regex : this.rightComment.entrySet()) {
			Pattern p = Pattern.compile(regex.getValue());
			Matcher m = p.matcher(code);
			
			if(m.find()){
				JOptionPane.showMessageDialog(null, "Sintaxe correta!\n" + code.replaceAll("/\\*.*\\*/|/\\/.*", ""));
				return true;
			}
		}
		
		return false;
		
	}
	
	public Boolean verifyWrongSL(String code) {
		
		for(Map.Entry<String, String> regex : this.wrongSLComment.entrySet()) {
			Pattern p = Pattern.compile(regex.getValue());
			Matcher m = p.matcher(code);
			
			if(m.find()){
				JOptionPane.showMessageDialog(null, "Sintaxe errada!\n" + code
						+ "\n Sintaxe correta: " + this.fixSLComment(regex.getKey(), code));
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean verifyWrongBL(String code) {

		Boolean insideBlock = false;
		
		for(Map.Entry<String, String> regex : this.wrongBLIComment.entrySet()) {
			Pattern p = Pattern.compile(regex.getValue());
			Matcher m = p.matcher(code);
			
			if(code.contains("/*"))
				insideBlock = true;

			if(m.find() || insideBlock){
				String fixedCode = this.fixBLIComment(regex.getKey(), code);
				System.out.println("ENTROU 1");
				for(Map.Entry<String, String> regex1 : this.wrongBLEComment.entrySet()) {
					Pattern p1 = Pattern.compile(regex1.getValue());
					Matcher m1 = p1.matcher(fixedCode);
					System.out.println(regex1.getKey());

					if(m1.find()){	
						JOptionPane.showMessageDialog(null, "Sintaxe errada!\n" + code
								+ "\nSintaxe correta: " + this.fixBLEComment(regex1.getKey(), fixedCode));
						
						return true;
					}
				}
				
				JOptionPane.showMessageDialog(null, "Sintaxe errada!\n" + code
						+ "\nSintaxe correta: " + fixedCode);
				
				return true;
			}
		}
		
		return false;
	}

	public String fixSLComment(String regex, String code) {
		System.out.println(regex);
		return code.replace(regex, "//");
	}
	
	public String fixBLIComment(String regex, String code) {
	
		return code.replace(regex, "/*");
	}
	
	public String fixBLEComment(String regex, String code) {
		System.out.println(regex + " - " + code);

		return code.replace(regex, "*/");
	}
	
}
