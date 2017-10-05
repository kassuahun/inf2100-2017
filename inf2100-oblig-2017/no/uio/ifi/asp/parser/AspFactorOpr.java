package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

public class AspFactorOpr extends AspSyntax {
    TokenKind oprType;

    AspFactorOpr(int n) {
        super(n);
    }

    public static AspFactorOpr parse(Scanner s) {
        Main.log.enterParser("AspFactorOpr");
        AspFactorOpr fOpr = new AspFactorOpr(s.curLineNum());

        fOpr.oprType = s.curToken().kind;
        s.readNextToken();

        Main.log.leaveParser("AspFactorOpr");
        return fOpr;
    }

    @Override
    void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
