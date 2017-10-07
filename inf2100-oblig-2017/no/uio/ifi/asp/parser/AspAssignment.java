package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

import java.util.ArrayList;

import static no.uio.ifi.asp.scanner.TokenKind.*;


/**
 *
 */
public class AspAssignment extends AspStmt{
    ArrayList<AspSubscription> sub = new ArrayList<>();
    AspName name;
    AspExpr expr;
    //newline token
    public AspAssignment(int i) {
        super(i);
    }

    public static AspAssignment parse(Scanner s) {
        Main.log.enterParser("AspAssignment");
        AspAssignment ass = new AspAssignment(s.curLineNum());

        test(s, nameToken)
        ass.name = new AspName.parse(s.curLineNum());
        skip(s,nameToken);

        //if [
        if(s.curToken().kind == leftBracketToken) {
            while(true){
                ass.sub.add(AspSubscription.parse(s.curLineNum()));
                //if [][
                if(s.curToken().kind != leftBracketToken){
                    break;
                }
            }
        }
        skip(s,equalToken);
        ass.expr= AspExpr.parse(s);
        skip(s,newLineToken);

        Main.log.leaveParser("AspAssignment");
        return ass;
    }
}
