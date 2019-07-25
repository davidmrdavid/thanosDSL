package org.thanos;


import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.morpheus.Tensor;
import com.oracle.truffle.api.morpheus.TensorAdapter;


//TODO: why final?
public final class Morpheus extends BuiltinObject {

    Tensor S = null;
    Tensor K = null;
    Tensor R = null;

    private static final BuiltinDescriptor DESCRIPTOR = describe(MorpheusFactory.getFactories());

    @Override
    protected BuiltinDescriptor getBuiltinDescriptor() {
        return DESCRIPTOR;
    }

    @Builtin
    abstract static class Build extends BuiltinNode {
        @Specialization(limit = "2")
        //@CompilerDirectives.TruffleBoundary
        Object doDefault(Morpheus receiver, TruffleObject S, TruffleObject K, TruffleObject R,
                         @CachedLibrary("S") InteropLibrary interopS,
                         @CachedLibrary("K") InteropLibrary interopK,
                         @CachedLibrary("R") InteropLibrary interopR) {
            Tensor tensorS = new TensorAdapter(S, interopS);
            Tensor tensorK = new TensorAdapter(K, interopK);
            Tensor tensorR = new TensorAdapter(R, interopR);
            receiver.S = tensorS;
            receiver.K = tensorK;
            receiver.R = tensorR;

            //TODO: cannot seem to return void for an in-place update.
            //yet, the receiver pointer *is* updating and that can be tested
            //easily. This must be an issue with the BuiltinNode
            return receiver;
        }
    }

    @Builtin
    abstract static class TestTosTerone extends BuiltinNode {
        @Specialization
            //@CompilerDirectives.TruffleBoundary
        Object doDefault(Morpheus receiver, Object arg){
            return receiver.K.test();
        }
    }

    //TODO: `Builtin` is not documented
    //QUESTIONS
    // 1. Why return Object instead of Tensor (chumer's recommendation). Wouldn't Tensor provide an extra layer of
    // type safety?
    // 2. The TruffleBoundary seems unnecessary, no?
    // 3. `@Builtin` is not documented


    /*
    @Builtin
    abstract static class aggregateSum extends BuiltinNode {
        @Specialization(limit = "2")
        //@CompilerDirectives.TruffleBoundary
        Object doDefault(VirtualFrame frame, Morpheus2 receiver,
                         int axis,
                         @CachedLibrary("receiver.S") Tensors.TensorLibrary tensorlibS,
                         @CachedLibrary("receiver.K") Tensors.TensorLibrary tensorlibK,
                         @CachedLibrary("receiver.R") Tensors.TensorLibrary tensorlibR)
                {
            return null;
        }
    }
    */

}
