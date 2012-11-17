package unquietcode.tools.underscore;

import unquietcode.tools.underscore.lambdas.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
}
