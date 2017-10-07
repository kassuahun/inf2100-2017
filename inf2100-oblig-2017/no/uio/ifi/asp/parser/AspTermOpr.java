package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

public class AspTermOpr extends AspSyntax {
    TokenKind tOprKind;

    AspTermOpr(int n) {
        super(n);
    }

    public static AspTermOpr parse(Scanner s) {
        Main.log.enterParser("AspTermOpr");
        AspTermOpr tOpr = new AspTermOpr(s.curLineNum());

        tOpr.tOprKind = s.curToken().kind;
        skip(s,tOpr.tOprKind);

       Main.log.leaveParser("AspTermOpr");
        return tOpr;
    }

    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
