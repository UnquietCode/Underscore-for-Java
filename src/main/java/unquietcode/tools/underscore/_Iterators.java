package unquietcode.tools.underscore;

import unquietcode.tools.underscore.lambdas.SimpleClosure3;
import unquietcode.tools.underscore.lambdas.ValueClosure1;
import unquietcode.tools.underscore.lambdas.ValueClosure3;
import unquietcode.tools.underscore.lambdas.ValueClosure4;

import java.util.List;
import java.util.Map;

/**
 * Semantic wrappers for the various closures used by the Underscore methods.
 */
public class _Iterators {

	public interface listFilter<_Element> extends withValue.forList<Boolean, _Element> {
		@Override Boolean invoke(_Element element, Integer index, List<_Element> list);
	}

	public interface mapFilter<_Key, _Value> extends withValue.forMap<Boolean, _Key, _Value> {
		@Override Boolean invoke(_Value value, _Key key, Map<_Key, _Value> map);
	}

	public interface forList<_Element> extends SimpleClosure3<_Element, Integer, List<_Element>> {
		@Override void invoke(_Element element, Integer index, List<_Element> list);
	}

	public interface forMap<_Key, _Value> extends SimpleClosure3< _Value, _Key, Map<_Key, _Value>> {
		@Override void invoke(_Value value, _Key key, Map<_Key, _Value> map);
	}


	public static class withValue {

		public interface forList<_Output, _Element> extends ValueClosure3<_Output, _Element, Integer, List<_Element>> {
			@Override _Output invoke(_Element element, Integer index, List<_Element> list);
		}

		public interface forMap<_Output, _Key, _Value> extends ValueClosure3<_Output, _Value, _Key, Map<_Key, _Value>> {
			@Override _Output invoke(_Value value, _Key key, Map<_Key, _Value> map);
		}


		public static class memoized {
			public interface forList<_Output, _Element> extends ValueClosure4<_Output, _Output, _Element, Integer, List<_Element>> {
				@Override _Output invoke(_Output memo, _Element element, Integer index, List<_Element> list);
			}

			public interface forMap<_Output, _Key, _Value> extends ValueClosure4<_Output, _Output, _Value, _Key, Map<_Key, _Value>> {
				@Override _Output invoke(_Output memo, _Value value, _Key key, Map<_Key, _Value> map);
			}
		}
	}
}
