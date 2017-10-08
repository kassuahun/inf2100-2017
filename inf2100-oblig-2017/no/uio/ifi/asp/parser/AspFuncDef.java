package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

import java.util.ArrayList;

import static no.uio.ifi.asp.scanner.TokenKind.*;

/**
 *
 */
public class AspFuncDef extends AspStmt{

    ArrayList<AspName> argNameList = new ArrayList<AspName>();
    AspName funcName;
    AspSuite funcSuite;

    public AspFuncDef(int i) {
        super(i);
    }

    public static AspFuncDef parse(Scanner s) {
        Main.log.enterParser("AspFuncDef");
        AspFuncDef funcDef = new AspFuncDef(s.curLineNum());

            skip(s, defToken);
            funcDef.funcName = AspName.parse(s);
            skip(s,leftParToken);

            if (s.curToken().kind != rightParToken){
                while (true){
                funcDef.argNameList.add(AspName.parse(s));
                if(s.curToken().kind != rightParToken) break;
                skip(s, commaToken);
                }
            }

            skip(s, rightParToken);
            skip(s,colonToken);
            funcDef.funcSuite = AspSuite.parse(s);

        Main.log.leaveParser("AspFuncDef");
        return funcDef;
    }
}
