package jp.co.seamark.neo4j.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValueObject {

	private final String name;
	private final String description;
}
