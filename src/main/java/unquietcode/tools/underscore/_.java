package unquietcode.tools.underscore;

import unquietcode.tools.underscore.lambdas.SimpleClosure3;
import unquietcode.tools.underscore.lambdas.ValueClosure3;
import unquietcode.tools.underscore.lambdas.ValueClosure4;

import java.util.List;
import java.util.Map;

/**
 * Underscore. Get it?
 *
 * @author Ben Fagin
 * @version 11-16-2012
 */
public class _ {

	//==o==o==o==o==o==o==| Each |==o==o==o==o==o==o==//

	/**
	 * Iterates over a list of elements, yielding each in turn to an iterator function.
	 *
	 * @param list
	 * @param iterator
	 * @param <_Element>
	 */
	public static <_Element> void each(
		List<_Element> list,
		SimpleClosure3<_Element, Integer, List<_Element>> iterator
	){
		_Collections.each(list, iterator);
	}

	public static <_Key, _Value> void each(
		Map<_Key, _Value> map,
		SimpleClosure3<_Value, _Key, Map<_Key, _Value>> iterator
	){
		_Collections.each(map, iterator);
	}

	/**
	 * Iterates over a list of elements, yielding each in turn to an iterator function.
	 *
	 * @param list
	 * @param iterator
	 * @param <_Element>
	 */
	public static <_Element> void forEach(
		List<_Element> list,
		SimpleClosure3<_Element, Integer, List<_Element>> iterator
	){
		each(list, iterator);
	}

	public static <_Key, _Value> void forEach(
		Map<_Key, _Value> map,
		SimpleClosure3<_Value, _Key, Map<_Key, _Value>> iterator
	){
		each(map, iterator);
	}

	//==o==o==o==o==o==o==| Map |==o==o==o==o==o==o==//

	public static <_Input, _Output> List<_Output> map(
		List<_Input> list,
		ValueClosure3<_Output, _Input, Integer, List<_Input>> iterator
	){
		return _Collections.map(list, iterator);
	}

	public static <_Key, _Value, _Output> List<_Output> map(
		Map<_Key, _Value> map,
		ValueClosure3<_Output, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return _Collections.map(map, iterator);
	}

	public static <_Input, _Output> List<_Output> collect(
		List<_Input> list,
		ValueClosure3<_Output, _Input, Integer, List<_Input>> iterator
	){
		return map(list, iterator);
	}

	public static <_Key, _Value, _Output> List<_Output> collect(
		Map<_Key, _Value> map,
		ValueClosure3<_Output, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return map(map, iterator);
	}

	//==o==o==o==o==o==o==| Reduce |==o==o==o==o==o==o==//

	public static <_Input, _Output> _Output reduce(
		List<_Input> list,
		ValueClosure4<_Output, _Output, _Input, Integer, List<_Input>> iterator,
		_Output memo
	){
		return _Collections.reduce(list, iterator, memo);
	}

	public static <_Key, _Value, _Output> _Output reduce(
		Map<_Key, _Value> map,
		ValueClosure4<_Output, _Output, _Value, _Key, Map<_Key, _Value>> iterator,
		_Output memo
	){
		return _Collections.reduce(map, iterator, memo);
	}

	public static <_Input, _Output> _Output foldl(
		List<_Input> list,
		ValueClosure4<_Output, _Output, _Input, Integer, List<_Input>> iterator,
		_Output memo
	){
		return reduce(list, iterator, memo);
	}

	public static <_Key, _Value, _Output> _Output foldl(
		Map<_Key, _Value> map,
		ValueClosure4<_Output, _Output, _Value, _Key, Map<_Key, _Value>> iterator,
		_Output memo
	){
		return reduce(map, iterator, memo);
	}

	public static <_Input, _Output> _Output reduceRight(
		List<_Input> list,
		ValueClosure4<_Output, _Output, _Input, Integer, List<_Input>> iterator,
		_Output memo
	){
		return _Collections.reduceRight(list, iterator, memo);
	}

	public static <_Input, _Output> _Output foldr(
		List<_Input> list,
		ValueClosure4<_Output, _Output, _Input, Integer, List<_Input>> iterator,
		_Output memo
	){
		return reduceRight(list, iterator, memo);
	}

	//==o==o==o==o==o==o==| find |==o==o==o==o==o==o==//

	public static <_Element> _Element find(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		return _Collections.find(list, iterator);
	}

	public static <_Key, _Value> _Value find(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return _Collections.find(map, iterator);
	}

	public static <_Element> _Element detect(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		return find(list, iterator);
	}

	public static <_Key, _Value> _Value  detect(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return find(map, iterator);
	}

	//==o==o==o==o==o==o==| filter |==o==o==o==o==o==o==//

	public static <_Element> List<_Element> filter(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		return _Collections.filter(list, iterator);
	}

	public static <_Key, _Value> Map<_Key, _Value> filter(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return _Collections.filter(map, iterator);
	}

	public static <_Element> List<_Element> select(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		return filter(list, iterator);
	}

	public static <_Key, _Value> Map<_Key, _Value> select(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return filter(map, iterator);
	}

	//==o==o==o==o==o==o==| where |==o==o==o==o==o==o==//

}
