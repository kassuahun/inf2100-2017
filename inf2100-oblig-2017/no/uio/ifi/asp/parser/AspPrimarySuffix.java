package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;
import static no.uio.ifi.asp.scanner.TokenKind.leftBracketToken;

public abstract class AspPrimarySuffix extends AspSyntax{
    //static AspPrimarySuffix prSuffix = null;

    AspPrimarySuffix(int n) {
        super(n);
    }

    public static AspPrimarySuffix parse(Scanner s) {
        AspPrimarySuffix prSuffix = null;
        Main.log.enterParser("AspPrimarySuffix");
        //
        if(s.curToken().kind == leftBracketToken){
            prSuffix = AspSubscription.parse(s);
        }else if(s.curToken().kind == leftBracketToken){
            prSuffix = AspArguments.parse(s);
        }

        Main.log.leaveParser("AspPrimarySuffix");
        return prSuffix;
    }

    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
