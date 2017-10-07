package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;

import java.util.ArrayList;

import static no.uio.ifi.asp.scanner.TokenKind.notToken;
import static no.uio.ifi.asp.scanner.TokenKind.rightParToken;

public class AspComparison extends AspSyntax{

    ArrayList<AspTerm> terms = new ArrayList<AspTerm>();
    ArrayList<AspCompOpr> compOprs = new ArrayList<AspCompOpr>();

    AspComparison(int n) {
        super(n);
    }

    public static AspComparison parse(Scanner s) {
        Main.log.enterParser("AspComparison");

        AspComparison comp = new AspComparison(s.curLineNum());
        comp.terms.add(AspTerm.parse(s));

        while(true){
            if(!s.isCompOpr()) break;
            comp.compOprs.add(AspCompOpr.parse(s));
            comp.terms.add(AspTerm.parse(s));
        }

        Main.log.leaveParser("AspComparison");
        return comp;
    }

    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
