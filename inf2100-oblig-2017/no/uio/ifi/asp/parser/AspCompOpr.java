package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

public class AspCompOpr extends AspSyntax {
    TokenKind compOprKind;

    AspCompOpr(int n) {
        super(n);
    }

    public static AspCompOpr parse(Scanner s) {
        Main.log.enterParser("AspCompOpr");
        AspCompOpr compOpr = new AspCompOpr(s.curLineNum());
        compOpr.compOprKind = s.curToken().kind;

        Main.log.leaveParser("AspCompOpr");
        return compOpr;
    }


    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
