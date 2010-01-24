package arden.runtime;

import java.lang.reflect.InvocationTargetException;

/**
 * 
 * Static helper methods.
 * 
 * @author Daniel Grunwald
 * 
 */
public final class RuntimeHelpers {
	public static ArdenValue changeTime(ArdenValue input, ArdenValue newTime) {
		if (newTime instanceof ArdenTime) {
			return input.setTime(((ArdenTime) newTime).value);
		} else {
			return input.setTime(ArdenValue.NOPRIMARYTIME);
		}
	}

	public static ArdenValue[] call(MedicalLogicModule mlm, ExecutionContext context, ArdenValue[] arguments) {
		try {
			return mlm.run(context, arguments);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	public static final double DEFAULT_URGENCY = 50;

	public static double urgencyGetPrimitiveValue(ArdenValue val) {
		if (val instanceof ArdenNumber)
			return ((ArdenNumber) val).value;
		else
			return DEFAULT_URGENCY;
	}

	public static DatabaseQuery constrainQueryWithinTo(DatabaseQuery q, ArdenValue start, ArdenValue end) {
		if (start instanceof ArdenTime && end instanceof ArdenTime)
			return q.occursWithinTo((ArdenTime) start, (ArdenTime) end);
		else
			return DatabaseQuery.NULL;
	}

	public static DatabaseQuery constrainQueryNotWithinTo(DatabaseQuery q, ArdenValue start, ArdenValue end) {
		if (start instanceof ArdenTime && end instanceof ArdenTime)
			return q.occursNotWithinTo((ArdenTime) start, (ArdenTime) end);
		else
			return DatabaseQuery.NULL;
	}
}
