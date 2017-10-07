package no.uio.ifi.asp.parser;

import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.runtime.RuntimeReturnValue;
import no.uio.ifi.asp.runtime.RuntimeScope;
import no.uio.ifi.asp.runtime.RuntimeValue;
import no.uio.ifi.asp.scanner.Scanner;

import java.util.ArrayList;

public class AspPrimary extends AspSyntax{

    ArrayList<AspPrimarySuffix> prSuffix = new ArrayList<AspPrimarySuffix>();
    AspAtom atom = null;

    AspPrimary(int n) {
        super(n);
    }

    public static AspPrimary parse(Scanner s) {
        Main.log.enterParser("AspPrimary");
        AspPrimary primary = new AspPrimary(s.curLineNum());

        primary.atom = AspAtom.parse(s);
        if(s.isPrimaryPrefix()){
            while(true){
                primary.prSuffix.add(AspPrimarySuffix.parse(s));
                if (!s.isPrimaryPrefix()) {
                    break;
                }
            }
        }

        Main.log.leaveParser("AspPrimary");
        return primary;
    }

    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
