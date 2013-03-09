Underscore-for-Java
===================

An experiment with porting [Underscore.js](https://github.com/documentcloud/underscore) to Java. A smarter, fluent API would probably be much better
and easier to use.

Perhaps FlumeJava is a more polished alternative?

Example Usage
===================
```java
public void objectMap() {
	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("one", 1);
	map.put("two", 2);
	map.put("three", 3);

	List<String> transformed;

	transformed = _.map(map, new _Iterators.withValue.forMap<String, String, Integer>() {
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
```
```java
public void listReduce() {
	List<Integer> list = Arrays.asList(1, 2, 3);

	int sum = _.reduce(list, new _Iterators.withValue.memoized.forList<Integer, Integer>() {
		public Integer invoke(Integer memo, Integer value, Integer index, List<Integer> list) {
			return memo + value;
		}
	}, 0);

	System.out.println(sum);
}
```

So, yeah. We do strange things when we're bored.

Peace, love, and code.
