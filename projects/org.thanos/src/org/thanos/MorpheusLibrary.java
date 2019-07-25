package org.thanos;

import com.oracle.truffle.api.library.GenerateLibrary;
import com.oracle.truffle.api.library.Library;
import com.oracle.truffle.api.library.LibraryFactory;

@GenerateLibrary
public abstract class MorpheusLibrary extends Library {

    //TODO: Currently, only `NormalizedTable.java` inherits from this.
    // I suppose that the goal of this library is to define a public interface
    // that would allow us to compare different implementations of the NT.

    //TODO: Should the argument types be specialized?
    //TODO: Is `leftScalarOp` and `rightScalarOp` too abstract?
    //TODO: (cont.) is there a better way to specify the `Op`?
    //TODO: [aggregateSum]: I want `axis` to only have three representable values: 0,1,-1
    public abstract Object aggregateSum(Object receiver, int axis);
    public abstract Object leftScalarOp(Object receiver, Object scalar, String op);
    public abstract Object rightScalarOp(Object receiver, Object scalar, String op);
    public abstract Object leftMatrixMul(Object receiver, Object matrix);
    public abstract Object rightMatrixMul(Object receiver, Object matrix);
    public abstract Object crossProduct(Object receiver);
    public abstract Object invertMatrix(Object receiver);


    //TODO: these are boilerplate-y. Can these not be directly inherited from somewhere?
    public static LibraryFactory<MorpheusLibrary> getFactory() {
        return FACTORY;
    }
    public static MorpheusLibrary getUncached() {
        return FACTORY.getUncached();
    }
    private static final LibraryFactory<MorpheusLibrary> FACTORY = LibraryFactory.resolve(MorpheusLibrary.class);
}
