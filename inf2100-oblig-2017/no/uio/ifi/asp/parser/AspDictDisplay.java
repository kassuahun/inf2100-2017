package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

import java.util.ArrayList;

import static no.uio.ifi.asp.scanner.TokenKind.*;

public class AspDictDisplay extends AspAtom{
    ArrayList<AspStringLiteral> strLitList = new ArrayList<AspStringLiteral>();
    ArrayList<AspExpr> exprsList = new ArrayList<AspExpr>();

    AspDictDisplay(int n) {
        super(n);
    }

    public static AspDictDisplay parse(Scanner s) {
        Main.log.enterParser("AspDictDisplay");
        AspDictDisplay dictDisplay = new AspDictDisplay(s.curLineNum());

        skip(s,leftBraceToken);
        if (s.curToken().kind != rightBraceToken)
        {
            while(true){
               dictDisplay.strLitList.add(AspStringLiteral.parse(s));
               skip(s,colonToken);
               dictDisplay.exprsList.add(AspExpr.parse(s));
               if (s.curToken().kind!=commaToken) break;
               skip(s,commaToken);
            }

        }
        skip(s, rightBraceToken);

        Main.log.leaveParser("AspDictDisplay");
        return dictDisplay;
    }


    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
