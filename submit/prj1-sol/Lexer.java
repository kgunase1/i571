

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Lexer {

	public static void main(String[] args) throws SyntaxError {
		Scanner scanner = new Scanner(System.in);
      String inputString = scanner.nextLine();
      scanner.close();
		List<TokenEntity> tokenEntityList = scanner(inputString);
		if(!tokenEntityList.isEmpty()) {
			Parser parser = new Parser(tokenEntityList, tokenEntityList.get(0), 0);
			parser.recursiveParser();
		}
	}

	private static List<TokenEntity> scanner(String inputString) {
		List<TokenEntity> tokenEntityList = new ArrayList<>();
		List<String> reservedWordsList = new ArrayList<>();
		reservedWordsList.add("var");
		reservedWordsList.add("record");
		reservedWordsList.add("end");
		reservedWordsList.add("number");
		reservedWordsList.add("string");
		String declaration = inputString.trim();
		for(int i = 0; i < declaration.length();) {
			TokenEntity tokenEntity = new TokenEntity();
			Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]*");
			Matcher matcher = pattern.matcher(declaration);
			Pattern commentPattern = Pattern.compile("#.*");
			Matcher commentMatcher = commentPattern.matcher(declaration);
			if(Character.isWhitespace(declaration.charAt(0))) {
				declaration = declaration.substring(1, declaration.length());
				continue;
			}
			if(matcher.find() && !matcher.group().equals("")) {
				if(reservedWordsList.contains(matcher.group(0)))
					tokenEntity.setKind("reservedWord");
				else
					tokenEntity.setKind("identifier");	
					tokenEntity.setLexeme(matcher.group(0));
				declaration = declaration.substring(tokenEntity.getLexeme().length(), declaration.length());
			} else if(declaration.charAt(0) == ';') {
				tokenEntity.setKind("semiColon");
				tokenEntity.setLexeme(";");
				declaration = declaration.substring(1, declaration.length());
			} else if(declaration.charAt(0) == ':') {
				tokenEntity.setKind("colon");
				tokenEntity.setLexeme(":");
				declaration = declaration.substring(1, declaration.length());
			} else if(declaration.charAt(0) != '#') {
				tokenEntity.setKind(String.valueOf(declaration.charAt(0)));
				tokenEntity.setLexeme(String.valueOf(declaration.charAt(0)));
				declaration = declaration.substring(1, declaration.length());
			} else if(commentMatcher.find() && !commentMatcher.group().equals("")) {
				declaration = declaration.substring(commentMatcher.group().length(), declaration.length());
				continue;
			}
			if(!tokenEntity.getKind().equals("\s"))
				tokenEntityList.add(tokenEntity);
		}
		return tokenEntityList;
	}

}
