package org.thanos;

import org.thanos.ThanosLanguage.Context;
import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

@TruffleLanguage.Registration(id = ThanosLanguage.ID, name = "thanos", version = "0.1", internal = false)
public class ThanosLanguage extends TruffleLanguage<Context> {

    public static final String ID = "thanos";

    static class Context {
        Env env;

        Context(Env env) {
            this.env = env;
        }
    }

    @Override
    protected Context createContext(Env env) {
        System.out.println("Create Context for ThanosLanguage");
        return new Context(env);
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        RootNode root = new RootNode(this) {
            @Override
            public Object execute(VirtualFrame frame) {
                Object[] arguments = frame.getArguments();
                //To truffleObjects, then get their interops?
                //NormalizedTable tbl = new NormalizedTable(arguments[0], arguments[1], arguments[2]);
                Morpheus morph = new Morpheus();
                return morph;
            }
        };
        return Truffle.getRuntime().createCallTarget(root);
    }
}
