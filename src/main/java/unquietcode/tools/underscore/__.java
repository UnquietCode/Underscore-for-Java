package unquietcode.tools.underscore;

import unquietcode.tools.underscore.lambdas.SimpleClosure3;
import unquietcode.tools.underscore.lambdas.ValueClosure3;
import unquietcode.tools.underscore.lambdas.ValueClosure4;

import java.util.List;
import java.util.Map;

/**
 * Aliases for underscore methods.
 *
 * @author Ben Fagin
 * @version 11-16-2012
 */
public class __ {

	//==o==o==o==o==o==o==| Each |==o==o==o==o==o==o==//

	public static <_Element> void forEach(
		List<_Element> list,
		SimpleClosure3<_Element, Integer, List<_Element>> iterator
	){
		_.each(list, iterator);
	}

	public static <_Key, _Value> void forEach(
		Map<_Key, _Value> map,
		SimpleClosure3<_Value, _Key, Map<_Key, _Value>> iterator
	){
		_.each(map, iterator);
	}

	//==o==o==o==o==o==o==| Map |==o==o==o==o==o==o==//

	public static <_Input, _Output> List<_Output> collect(
		List<_Input> list,
		ValueClosure3<_Output, _Input, Integer, List<_Input>> iterator
	){
		return _.map(list, iterator);
	}

	public static <_Key, _Value, _Output> List<_Output> collect(
		Map<_Key, _Value> map,
		ValueClosure3<_Output, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return _.map(map, iterator);
	}

	//==o==o==o==o==o==o==| Reduce |==o==o==o==o==o==o==//

	public static <_Input, _Output> _Output foldl(
		List<_Input> list,
		ValueClosure4<_Output, _Output, _Input, Integer, List<_Input>> iterator,
		_Output memo
	){
		return _.reduce(list, iterator, memo);
	}

	public static <_Key, _Value, _Output> _Output foldl(
		Map<_Key, _Value> map,
		ValueClosure4<_Output, _Output, _Value, _Key, Map<_Key, _Value>> iterator,
		_Output memo
	){
		return _.reduce(map, iterator, memo);
	}

	public static <_Input, _Output> _Output foldr(
		List<_Input> list,
		ValueClosure4<_Output, _Output, _Input, Integer, List<_Input>> iterator,
		_Output memo
	){
		return _.reduceRight(list, iterator, memo);
	}

	//==o==o==o==o==o==o==| find |==o==o==o==o==o==o==//

	public static <_Element> _Element detect(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		return _.find(list, iterator);
	}

	public static <_Key, _Value> _Value  detect(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return _.find(map, iterator);
	}

	//==o==o==o==o==o==o==| filter |==o==o==o==o==o==o==//

	public static <_Element> List<_Element> select(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		return _.filter(list, iterator);
	}

	public static <_Key, _Value> Map<_Key, _Value> select(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return _.filter(map, iterator);
	}

	//==o==o==o==o==o==o==| all |==o==o==o==o==o==o==//

	public static <_Element> boolean every(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		return _.all(list, iterator);
	}

	public static <_Key, _Value> boolean every(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return _.all(map, iterator);
	}

	//==o==o==o==o==o==o==| any |==o==o==o==o==o==o==//

	public static <_Element> boolean some(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		return _.any(list, iterator);
	}

	public static <_Key, _Value> boolean some(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		return _.any(map, iterator);
	}
}
