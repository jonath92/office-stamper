package pro.verron.officestamper.api;

import pro.verron.officestamper.utils.TriFunction;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Represents a custom function encapsulating a name, parameter types, and a functional implementation.
 * This record provides a structure for defining and handling generic functions with dynamic argument types.
 *
 * @param name the name of the function
 * @param parameterTypes the parameter types expected by the function
 * @param function the implementation of the function that accepts a list of arguments and produces a result
 */
public record CustomFunction(
        String name,
        List<Class<?>> parameterTypes,
        Function<List<Object>, Object> function
) {
    /**
     * The NeedsFunctionImpl interface specifies a contract for classes that require the implementation
     * of a function that operates on a specific type and produces a result.
     *
     * @param <T> the type of the input to the function
     */
    public interface NeedsFunctionImpl<T> {
        void withImplementation(Function<T, ?> function);
    }

    /**
     * Represents a contract for classes that require the implementation of a BiFunction.
     * A BiFunction is a functional interface that accepts two input arguments of types T and U,
     * and produces a result.
     *
     * @param <T> the type of the first input to the BiFunction
     * @param <U> the type of the second input to the BiFunction
     */
    public interface NeedsBiFunctionImpl<T, U> {
        void withImplementation(BiFunction<T, U, ?> object);
    }

    /**
     * Represents a contract for classes requiring the implementation of a TriFunction.
     * A TriFunction is a functional interface that accepts three input arguments of types T, U, and V,
     * and produces a result.
     *
     * @param <T> the type of the first input to the TriFunction
     * @param <U> the type of the second input to the TriFunction
     * @param <V> the type of the third input to the TriFunction
     */
    public interface NeedsTriFunctionImpl<T, U, V> {
        void withImplementation(TriFunction<T, U, V, ?> function);
    }
}
