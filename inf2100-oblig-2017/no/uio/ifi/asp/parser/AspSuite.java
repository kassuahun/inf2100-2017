package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;

public class AspSuite extends AspSyntax{
    AspSuite(int n) {
        super(n);
    }

    public static AspSuite parse(Scanner s) {
        Main.log.enterParser("AspSuite");

        Main.log.leaveParser("AspSuite");
        return null;
    }

    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
