package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.scanner.Scanner;

/**
 *
 */
public class AspFuncDef extends AspStmt{
    public AspFuncDef(int i) {
        super(i);
    }

    public static AspFuncDef parse(Scanner s) {
        Main.log.enterParser("AspFuncDef");
        AspFuncDef fOpr = new AspFuncDef(s.curLineNum());



        Main.log.leaveParser("AspFuncDef");
        return null;
    }

}
