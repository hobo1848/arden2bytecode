package arden.compiler;

import arden.compiler.node.PMappingFactor;
import arden.compiler.node.TIdentifier;

final class DestinationVariable extends Variable {
	final PMappingFactor mapping;

	public DestinationVariable(TIdentifier name, PMappingFactor mapping) {
		super(name);
		this.mapping = mapping;
	}
}
