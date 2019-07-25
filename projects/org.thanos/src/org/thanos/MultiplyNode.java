package org.thanos;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.nodes.Node;

import java.util.ArrayList;

// TODO: should it be static? It was static in an example that @chumer showed me
// TODO: How to define thanos-specific exceptions?
// TODO: should this have `@NodeChildren`? The compiler did not enforce it
public abstract class MultiplyNode extends Node {

    /*abstract Object execute(Object argument1, Object argument2) throws UnsupportedTypeException;


    //TODO: would Truffle automatically check if the objects could be casted as scalar `int`s
    //TODO: would `long` be a more general type? Should I instead have an equivalent method for float, int, double, etc?
    @Specialization
    int mulScalars(int scalar1, int scalar2) {
        return scalar1 * scalar2;
    }

    @Specialization(guards = "tensors.isTensor(tensor)", limit = "2")
    Object doDefault(int scalar, Object tensor, @CachedLibrary("tensor") Tensors.TensorLibrary tensors){
        return null;//tensors.multiply(scalar, tensor);
    }*/

    //Below is some commented-out code from an older implementation. I have not fully replicated its fully behavior
    //yet.

    /*
    @Specialization(limit = "2", guards = "isVector(vec, interop)")
    Object mulScalarByVec(int scalar, Object vec,
                          @CachedLibrary("vec") InteropLibrary interop)
            throws UnsupportedTypeException  {

        if(interop.hasArrayElements(vec)){
            try {
                long size = interop.getArraySize(vec);
                ArrayList<Long> result = new ArrayList<Long>();
                for(int index = 0; index < size; index++){
                    Object e = interop.readArrayElement(vec,index);
                    // TODO: the number may be some other numeric type. Whats best practice here?
                    if(interop.hasArrayElements(e) || !(interop.fitsInLong(e))){
                        Object[] args = {scalar, vec};
                        String hint = "try other types";
                        throw UnsupportedTypeException.create(args, hint);
                    }
                    long eNum = interop.asLong(e);
                    result.add(eNum * scalar);
                }
                return result;
            }
            catch(UnsupportedMessageException | InvalidArrayIndexException e){
                // TODO: have to throw thanos-specific error
                // throwing this for the time being.
                Object[] args = {scalar, vec};
                String hint = "try other types";
                throw UnsupportedTypeException.create(args, hint);
            }
        }
        else{
            Object[] args = {scalar, vec};
            String hint = "try other types";
            throw UnsupportedTypeException.create(args, hint);
        }
    }

    @Specialization(limit = "2", guards = "isMatrix(matrix, interop)")
    Object mulScalarByMatrix(int scalar, Object matrix,
                             @CachedLibrary("matrix") InteropLibrary interop) {

        if(isMatrix(matrix, interop)){
            try {
                Dims dims = getMatrixDims(matrix, interop);
                long size1 = dims.getDim1();
                long size2 = dims.getDim2();
                ArrayList<Long> result = new ArrayList<Long>();
                for(int dim1 = 0; dim1 < size1; dim1++) {
                    for (int dim2 = 0; dim2 < size2; dim2++) {
                        long elem = accessMatrix(matrix, dim1, dim2, interop);
                    }
                }
                return result;
            }
            catch(UnsupportedMessageException e){
                // TODO: have to throw thanos-specific error
                return null;
            }
        }
        else {
            // TODO: have to throw thanos-specific error
            return null;
        }
    }

    // TODO: to be implemented
    @Fallback
    Object toBeImplemented(Object arg1, Object arg2) throws UnsupportedTypeException {
        Object[] provided = {arg1, arg2};
        String hint = "Try other types";
        throw UnsupportedTypeException.create(provided, hint);
    }


    // =========== HELPER METHODS AND POTENTIAL INTEROP EXTENSIONS
    // TODO: consider implementing a parametrizable `isArrayOfDim` method
    // TODO: we could have an interop method that casts everything to a numeric type?
    // TODO: can we use a more specialized type than `Object`?

    boolean isVector(Object obj, InteropLibrary interop) {
        if(interop.hasArrayElements(obj)){
            try{
                Object element = interop.readArrayElement(obj,0);
                return interop.hasArrayElements(element);
            }
            catch (UnsupportedMessageException | InvalidArrayIndexException e){
                // TODO: throw thanos-specific error? can guards even return exceptions
                // in any case, this suggest that the types are not specialized enough!
                return false;
            }
        }
        return false;
    }

    // TODO: I believe this can be written more succintly
    boolean isMatrix(Object obj, InteropLibrary interop) {
        try{
            if (interop.hasArrayElements(obj)) {
                long size = interop.getArraySize(obj);

                for (int index = 0; index < size; index++) {
                    if (!interop.hasArrayElements(obj)) {
                        return false;
                    }
                }
                return true;
            }
        }
        catch (UnsupportedMessageException e) {
            return false;
        }
        return false;
    }

    // TODO: should throw exception?
    // It would also be possible to implement this recursivel and/or by using an array of dims
    // Given our use case, I assume everything is numeric so I just cast to long in here.
    long accessMatrix(Object obj, long dim1, long dim2, InteropLibrary interop) throws UnsupportedMessageException {
        try{
            Object e1 = interop.readArrayElement(obj, dim1);
            Object e2 = interop.readArrayElement(e1, dim2);
            if(interop.fitsInLong(e2)) {
                long num = interop.asLong(e2);
                return num;
            }
            return -1;
        }
        catch (InvalidArrayIndexException e){
            //TODO: create custom exceptions
            return -1;

        }

    }

    //TODO: should throw exception? Perhaps type of matrix should be more specialized
    // Assumes that all indexes have the same dimensions. How to check this properly?
    // Should I supress some of the errors?
    Dims getMatrixDims(Object matrix, InteropLibrary interop) throws  UnsupportedMessageException {
        try {
            long dim1 = interop.getArraySize(matrix);
            Object elem = interop.readArrayElement(matrix, 0);
            long dim2 = interop.getArraySize(elem);
            Dims dims = new Dims(dim1, dim2);
            return dims;
        }
        catch(InvalidArrayIndexException e){
            return null;
        }

    }*/

    // Make arrray access multi-dimensional and numeric by default
    // Implement basic MORPHEUS multiplication
    // I believe the chumer library tutorial shows how to abstract away these helper functions
}
