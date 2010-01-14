package arden.runtime;

/**
 * Base class for compiled logic etc. The compiler creates derived classes. An
 * instance of the derived class will be created whenever the MLM is executed.
 * 
 * @author Daniel Grunwald
 */
public abstract class MedicalLogicModuleImplementation {
	// All derived classes are expected to have a constructor taking:
	// (ExecutionContext context, MedicalLogicModule self, ArdenValue[]
	// arguments)
	// None of the arguments may be null.

	/** Executes the logic block. */
	public abstract boolean logic(ExecutionContext context);

	/**
	 * Executes the action block.
	 * 
	 * @return Returns the value(s) provided by the "return" statement, or
	 *         (Java) null if no return statement was executed.
	 */
	public abstract ArdenValue[] action(ExecutionContext context);

	/** Gets the urgency. */
	public double getUrgency() {
		return RuntimeHelpers.DEFAULT_URGENCY;
	}
}
