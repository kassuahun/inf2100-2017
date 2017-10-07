package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

public class AspNoneLiteral extends AspAtom{
    TokenKind noneTokenKind;
    AspNoneLiteral(int n) {
        super(n);
    }

    public static AspNoneLiteral parse(Scanner s) {
        Main.log.enterParser("AspNoneLiteral");
        AspNoneLiteral nonToken = new AspNoneLiteral(s.curLineNum());

        nonToken.noneTokenKind = s.curToken().kind;
        skip(s,nonToken.noneTokenKind);

        Main.log.leaveParser("AspNoneLiteral");
        return nonToken;
    }

    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
