package unquietcode.tools.underscore.lambdas;

/**
 * @author Ben Fagin
 * @version 11-16-2012
 */
public interface ValueClosure2<Z, A,B> {
	Z invoke(A a, B b);
}
