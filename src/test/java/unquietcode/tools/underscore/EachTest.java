package unquietcode.tools.underscore;

import org.junit.Test;
import unquietcode.tools.underscore.lambdas.SimpleClosure3;
import unquietcode.tools.underscore.lambdas.ValueClosure3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ben Fagin
 * @version 11-16-2012
 */
public class EachTest {
	// TODO bring in the assertion stream from logmachine
	// TODO turn these into Groovy tests, muuuuch easier to create collections

	// always use the basic closures, but offer the other ones as 'semantic wrappers'

	@Test
	public void listEach() {
		List<Integer> list = Arrays.asList(1, 2, 3);

		_.each(list, new SimpleClosure3<Integer, Integer, List<Integer>>() {
			public void invoke(Integer elem, Integer index, List<Integer> list) {
				System.out.println(elem);
			}
		});
	}

	@Test
	public void objectEach() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);

		_.each(map, new SimpleClosure3<Integer, String, Map<String, Integer>>() {
			public void invoke(Integer value, String key, Map<String, Integer> map) {
				System.out.println(value);
			}
		});
	}

	@Test
	public void listMap() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		List<String> transformed;

		transformed = _.map(list, new _Iterators.withValue.forList<String, Integer>() {
			public String invoke(Integer integer, Integer index, List<Integer> list) {
				return "'"+integer.toString()+"'";
			}
		});

		_.each(transformed, new _Iterators.forList<String>() {
			public void invoke(String element, Integer index, List<String> list) {
				System.out.println(element);
			}
		});
	}

	@Test
	public void objectMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);

		List<String> transformed;

		transformed = _.map(map, new ValueClosure3<String, Integer, String, Map<String, Integer>>() {
			public String invoke(Integer value, String key, Map<String, Integer> map) {
				return key + " : " + value;
			}
		});

		_.each(transformed, new _Iterators.forList<String>() {
			public void invoke(String element, Integer index, List<String> list) {
				System.out.println(element);
			}
		});
	}

	@Test
	public void listReduce() {
		List<Integer> list = Arrays.asList(1, 2, 3);

		int sum = _.reduce(list, new _Iterators.withValue.memoized.forList<Integer, Integer>() {
			public Integer invoke(Integer memo, Integer value, Integer index, List<Integer> list) {
				return memo + value;
			}
		}, 0);

		System.out.println(sum);
	}

	@Test
	public void mapReduce() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);

		int sum = _.reduce(map, new _Iterators.withValue.memoized.forMap<Integer, String, Integer>() {
			public Integer invoke(Integer memo, Integer value, String key, Map<String, Integer> map) {
				return memo + value;
			}
		}, 0);

		System.out.println(sum);
	}

	@Test
	public void listReduceRight() {
		List<String> list = Arrays.asList("a", "b", "c");

		String string = __.foldr(list, new _Iterators.withValue.memoized.forList<String, String>() {
			public String invoke(String memo, String elem, Integer index, List<String> list) {
				return memo + elem;
			}
		}, "");

		System.out.println(string);
	}

	@Test
	public void listFind() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Integer even = _.find(list, new _Iterators.listFilter<Integer>() {
			public Boolean invoke(Integer elem, Integer index, List<Integer> list) {
				return elem % 2 == 0;
			}
		});

		System.out.println(even);
	}

	@Test
	public void listFilter() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> evens = _.filter(list, new _Iterators.listFilter<Integer>() {
			public Boolean invoke(Integer elem, Integer index, List<Integer> list) {
				return elem % 2 == 0;
			}
		});

		System.out.println(evens);
	}

	@Test
	public void listReject() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> odds = _.reject(list, new _Iterators.listFilter<Integer>() {
			public Boolean invoke(Integer elem, Integer index, List<Integer> list) {
				return elem % 2 == 0;
			}
		});

		System.out.println(odds);
	}
}
