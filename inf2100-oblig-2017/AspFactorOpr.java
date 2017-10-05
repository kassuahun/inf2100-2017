import no.uio.ifi.asp.main.Main;
import no.uio.ifi.asp.parser.AspSyntax;
import no.uio.ifi.asp.scanner.Scanner;
import no.uio.ifi.asp.scanner.TokenKind;

/**
 *
 */
public class AspFactorOpr extends AspSyntax{
    TokenKind oprType;

    public AspFactorOpr(int lNum) {
        super(lNum);
    }

    @Override
    protected void prettyPrint() {

    }

    public static AspFactorOpr parse(Scanner s) {
        Main.log.enterParser("factor opr");
        AspFactorOpr fOpr = new AspFactorOpr(s.curLineNum());

        fOpr.oprType = s.curToken().kind;
        s.readNextToken();

        Main.log.leaveParser("factor opr");
        return fOpr;
    }

}
