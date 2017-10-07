package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;
import no.uio.ifi.asp.scanner.TokenKind.*;

import static no.uio.ifi.asp.scanner.TokenKind.newLineToken;
import static no.uio.ifi.asp.scanner.TokenKind.returnToken;

/**
 *
 */
public class AspReturnStmt extends AspStmt{
    AspExpr expr;
    AspSuite boady;

    public AspReturnStmt(int i) {
        super(i);
    }

    public static AspReturnStmt parse(Scanner s) {
        Main.log.enterParser("AspReturnStmt");
        AspReturnStmt rStmt = new AspReturnStmt(s.curLineNum());

        skip(s, returnToken);
        rStmt.expr=AspExpr.parse(s);
        skip(s,newLineToken);
        Main.log.leaveParser("AspReturnStmt");
        return rStmt;

    }

}




