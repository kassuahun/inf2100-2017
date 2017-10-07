package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;

public class AspStringLiteral extends AspAtom{
    AspStringLiteral(int n) {
        super(n);
    }

    public static AspStringLiteral parse(Scanner s) {
        Main.log.enterParser("AspStringLiteral");
        AspStringLiteral strLit = new AspStringLiteral(s.curLineNum());


        Main.log.leaveParser("AspStringLiteral");
        return strLit;
    }

    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
