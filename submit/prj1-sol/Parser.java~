package parser;

import java.util.List;

import org.json.simple.JSONArray;




public class Parser {
	private List<TokenEntity> tokensList;
	private TokenEntity nextToken;
	private int index;
	JSONArray jsonArray = new JSONArray();
	public Parser(List<TokenEntity> tokensList, TokenEntity nextToken, int index) {
		super();
		this.tokensList = tokensList;
		this.nextToken = nextToken;
		this.index = index;
	}

	private boolean peek(String expression) {
		return this.nextToken.getKind().equals(expression);
	}
	
	private void consume(String kind) throws SyntaxError {
		if(peek(kind))
			this.nextToken = this._nextToken();
		else {
			String message = "expecting" + this.nextToken.getKind() + "at " + this.nextToken.getLexeme();
			throw new SyntaxError(message);
		}
	}
	private TokenEntity _nextToken() {
		if(this.index < this.tokensList.size() - 1) {
			this.index++;
			return this.tokensList.get(this.index);
		} else {
			TokenEntity token = new TokenEntity();
			token.setKind("EOF");
			token.setLexeme("<EOF>");
			return token;
		}
			
	}

	public JSONArray recursiveParser() throws SyntaxError {
		try {
			JSONArray result = parse();
			if(!this.peek("EOF")) {
		  	String msg = "expecting end-of-input at " + this.nextToken.getLexeme();
		  	throw new SyntaxError(msg);
			}
			return result;
		  }
		  catch (Exception exception) {
			String msg = "expecting end-of-input at " + this.nextToken.getLexeme();
		  	throw new SyntaxError(msg);
		  }
	}
	public JSONArray parse() throws SyntaxError {
			while(this.peek("reservedWord") && this.nextToken.getLexeme().equals("var")) {
				consume("reservedWord");
				jsonArray = record();
			}
			System.out.print(jsonArray.toString());
		return jsonArray;
		
	}

	private JSONArray record() throws SyntaxError {
		JSONArray recordJsonArray = new JSONArray();
		while(!this.nextToken.getLexeme().equals("end") && 
		!this.nextToken.getKind().equals("EOF")) {
			JSONArray json = new JSONArray();
			json.add(this.nextToken.getLexeme());
			consume("identifier");
			consume("colon");
			if(this.peek("reservedWord") && this.nextToken.getLexeme().equals("record")) {
				consume("reservedWord");
				json.add(record());
			} else {
				json.add(this.nextToken.getLexeme());
				consume("reservedWord");
				consume("semiColon");
			}
			recordJsonArray.add(json);
		}
		if(this.nextToken.getLexeme().equals("end")) {
			consume("reservedWord");
			consume("semiColon");
		}
		return recordJsonArray;
	}

}
