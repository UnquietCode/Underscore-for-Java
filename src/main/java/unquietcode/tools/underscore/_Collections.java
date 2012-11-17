package unquietcode.tools.underscore;

import unquietcode.tools.underscore.lambdas.*;

import java.util.*;

/**
 * @author Ben Fagin
 * @version 11-16-2012
 */
public class _Collections {

	public static <_Input> void each(
		List<_Input> list,
		SimpleClosure3<_Input, Integer, List<_Input>> iterator
	){
		List<_Input> iList = Collections.unmodifiableList(list);

		for (int i=0; i < list.size(); ++i) {
			_Input elem = list.get(i);
			iterator.invoke(elem, i, iList);
		}
	}


	public static <_Key, _Value> void each(
		Map<_Key, _Value> map,
		SimpleClosure3<_Value, _Key, Map<_Key, _Value>> iterator
	){
		Map<_Key, _Value> iMap = Collections.unmodifiableMap(map);

		for (Map.Entry<_Key, _Value> entry : map.entrySet()) {
			iterator.invoke(entry.getValue(), entry.getKey(), iMap);
		}
	}

	public static <_Input, _Output> List<_Output> map(
		List<_Input> list,
		ValueClosure3<_Output, _Input, Integer, List<_Input>> iterator
	){
		List<_Input> iList = Collections.unmodifiableList(list);
		List<_Output> retval = new ArrayList<_Output>();

		for (int i=0; i < list.size(); ++i) {
			_Input elem = list.get(i);
			retval.add(iterator.invoke(elem, i, iList));
		}

		return retval;
	}

	public static <_Key, _Value, _Output> List<_Output> map(
		Map<_Key, _Value> map,
		ValueClosure3<_Output, _Value, _Key, Map<_Key, _Value>> iterator
	){
		Map<_Key, _Value> iMap = Collections.unmodifiableMap(map);
		List<_Output> retval = new ArrayList<_Output>();

		for (Map.Entry<_Key, _Value> entry : map.entrySet()) {
			retval.add(iterator.invoke(entry.getValue(), entry.getKey(), iMap));
		}

		return retval;
	}

	public static <_Input, _Output> _Output reduce(
		List<_Input> list,
		ValueClosure4<_Output, _Output, _Input, Integer, List<_Input>> iterator,
		_Output memo
	){
		List<_Input> iList = Collections.unmodifiableList(list);

		for (int i=0; i < list.size(); ++i) {
			_Input elem = list.get(i);
			memo = iterator.invoke(memo, elem, i, iList);
		}

		return memo;
	}

	public static <_Key, _Value, _Output> _Output reduce(
		Map<_Key, _Value> map,
		ValueClosure4<_Output, _Output, _Value, _Key, Map<_Key, _Value>> iterator,
		_Output memo
	){
		Map<_Key, _Value> iMap = Collections.unmodifiableMap(map);

		for (Map.Entry<_Key, _Value> entry : iMap.entrySet()) {
			memo = iterator.invoke(memo, entry.getValue(), entry.getKey(), iMap);
		}

		return memo;
	}

	public static <_Input, _Output> _Output reduceRight(
		List<_Input> list,
		ValueClosure4<_Output, _Output, _Input, Integer, List<_Input>> iterator,
		_Output memo
	){
		List<_Input> iList = Collections.unmodifiableList(list);

		for (int i=list.size()-1; i >= 0; --i) {
			_Input elem = list.get(i);
			memo = iterator.invoke(memo, elem, i, iList);
		}

		return memo;
	}

	public static <_Element> _Element find(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		List<_Element> iList = Collections.unmodifiableList(list);

		for (int i=0; i < list.size(); ++i) {
			_Element elem = list.get(i);
			Boolean result = iterator.invoke(elem, i, iList);

			if (result != null && result) {
				return elem;
			}
		}

		return null;
	}

	public static <_Key, _Value> _Value find(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		Map<_Key, _Value> iMap = Collections.unmodifiableMap(map);

		for (Map.Entry<_Key, _Value> entry : iMap.entrySet()) {
			Boolean result = iterator.invoke(entry.getValue(), entry.getKey(), iMap);

			if (result != null && result) {
				return entry.getValue();
			}
		}

		return null;
	}

	public static <_Element> List<_Element> filter(
		List<_Element> list,
		ValueClosure3<Boolean, _Element, Integer, List<_Element>> iterator
	){
		List<_Element> iList = Collections.unmodifiableList(list);
		List<_Element> retval = new ArrayList<_Element>();

		for (int i=0; i < list.size(); ++i) {
			_Element elem = list.get(i);
			Boolean result = iterator.invoke(elem, i, iList);

			if (result != null && result) {
				retval.add(elem);
			}
		}

		return retval;
	}

	public static <_Key, _Value> Map<_Key, _Value> filter(
		Map<_Key, _Value> map,
		ValueClosure3<Boolean, _Value, _Key, Map<_Key, _Value>> iterator
	){
		Map<_Key, _Value> iMap = Collections.unmodifiableMap(map);
		Map<_Key, _Value> retval = new HashMap<_Key, _Value>();

		for (Map.Entry<_Key, _Value> entry : map.entrySet()) {
			Boolean result = iterator.invoke(entry.getValue(), entry.getKey(), iMap);

			if (result != null && result) {
				retval.put(entry.getKey(), entry.getValue());
			}
		}

		return retval;
	}
}
