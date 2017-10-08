package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

import java.util.ArrayList;

import static no.uio.ifi.asp.scanner.TokenKind.*;
import static no.uio.ifi.asp.scanner.TokenKind.ifToken;

public class AspIfStmt extends AspStmt {

    ArrayList<AspExpr> condList = new ArrayList<AspExpr>();
    ArrayList<AspSuite> suteList = new ArrayList<AspSuite>();
    AspSuite elsesute;

    AspExpr condition;
    // Statement thenStmt;
    // Statement elseStmt; // optional

    public AspIfStmt(int i) {
        super(i);
    }

    public static AspIfStmt parse(Scanner s) {
        Main.log.enterParser("AspIfStmt");
        AspIfStmt ifStmt = new AspIfStmt(s.curLineNum());

        skip(s, ifToken);

        while (true){
            ifStmt.condList.add(AspExpr.parse(s));
            skip(s,colonToken);
            ifStmt.suteList.add(AspSuite.parse(s));
            if(s.curToken().kind != elifToken) break;
            skip(s, elifToken);
        }
        if (s.curToken().kind == elifToken)
        {
            skip(s, elseToken);
            skip(s,colonToken);
            //ifStmt.suteList.add(AspSuite.parse(s));
            ifStmt.elsesute = AspSuite.parse(s);
        }

        Main.log.leaveParser("AspIfStmt");
        return null;
    }
}
