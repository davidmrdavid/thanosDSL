package org.thanos;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.interop.*;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.morpheus.Tensor;

import java.util.ArrayList;
import java.util.Arrays;

//TODO: should this class be static?
//@ExportLibrary(MorpheusLibrary.class)
@ExportLibrary(InteropLibrary.class)
public class NormalizedTable implements TruffleObject {

/*    //TODO: should they be public?
    final Tensor S;
    final Tensor K;
    final Tensor R;
    private boolean transposed = false; //TODO: if true, use alternative rules

    // TODO: how to read these directly from the library
    // TODO: Are ArrayLists allowed?
    private ArrayList<String> members = new ArrayList<String>(
            Arrays.asList("multiply", "add"));

    public NormalizedTable(TruffleObject S, TruffleObject K, TruffleObject R) {
        this.S = new Tensors().new Tensor(S, null);
        this.K = new Tensors().new Tensor(K, null);;
        this.R = new Tensors().new Tensor(R, null);;
    }

    // ============= TensorInterface




    // ============= guards
    public boolean IsTransposed(){
        return this.transposed;
    }

    // ============= Interop-boilerplate
    @ExportMessage
    public Object invokeMember(String member, Object[] arguments) throws
            UnsupportedMessageException, ArityException,
            UnknownIdentifierException, UnsupportedTypeException {
*/
        /*int expectedArity = 2;
        int numArgs = arguments.length;

        if(arguments.length != 2){
            //TODO: is this the right exception
            throw ArityException.create(expectedArity, numArgs);
        }

        Object arg1 = arguments[0];
        Object arg2 = arguments[1];
        try{
            switch (member){
                case "multiply":
                    return multiply(arg1, arg2, node);
                case "add":
                    return add(arg1, arg2);
                default:
                    // TODO: is this the right exception?
                    throw UnknownIdentifierException.create(member);
            }

        }
        catch (InvalidArrayIndexException e){
            // TODO: need better exception
            throw UnsupportedMessageException.create();
        }*/
        //return null;
    //}

    /*@ExportMessage
    public boolean isString() {
        return true;
    }

    // TODO: find a better toStr representation
    @ExportMessage
    public String asString() {
        return "THANOS: Normalized Table <S, K, R>";
    }

    @ExportMessage
    final boolean hasMembers() {
        return true;
    }

    // TODO: where would this be called? By me in invokeMember?
    @ExportMessage
    final boolean isMemberInvocable(String member) {
        // best guess, docs don't specify its behaviour
        return members.contains(member);
    }

    // TODO: where would this be called By me in invokeMember?
    @ExportMessage
    final Object getMembers(boolean includeInternal) throws UnsupportedMessageException {
        // best guess, docs don't specify its behaviour
        return members;
    }*/
}
