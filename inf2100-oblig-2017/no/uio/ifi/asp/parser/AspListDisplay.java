package no.uio.ifi.asp.parser;

        import no.uio.ifi.asp.main.Main;
        import no.uio.ifi.asp.runtime.RuntimeReturnValue;
        import no.uio.ifi.asp.runtime.RuntimeScope;
        import no.uio.ifi.asp.runtime.RuntimeValue;
        import no.uio.ifi.asp.scanner.Scanner;
        import java.util.ArrayList;
        import static no.uio.ifi.asp.scanner.TokenKind.*;

public class AspListDisplay extends AspAtom {

    ArrayList<AspExpr> exprList = new ArrayList<AspExpr>();

    AspListDisplay(int n) {
        super(n);
    }

    public static AspListDisplay parse(Scanner s) {
        Main.log.enterParser("AspListDisplay");
        AspListDisplay listDisp = new AspListDisplay(s.curLineNum());

        if(s.curToken().kind == leftBracketToken) {
            skip(s,leftBracketToken);
            if(s.curToken().kind != rightBracketToken){
                while(true) {
                    listDisp.exprList.add(AspExpr.parse(s));
                    if(s.curToken().kind != commaToken) break;
                    skip(s,commaToken);
                }
            }
            skip(s,rightBracketToken);
        }
        Main.log.leaveParser("AspListDisplay");
        return listDisp;
    }

    @Override
    protected void prettyPrint() {

    }

    @Override
    RuntimeValue eval(RuntimeScope curScope) throws RuntimeReturnValue {
        return null;
    }
}
