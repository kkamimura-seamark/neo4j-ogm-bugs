package jp.co.seamark.neo4j.entity;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EntityA {
	@GraphId
	private Long id;
	
	private String name;
	
	private List<String> stringList = new ArrayList<>();
	private List<Integer> integerList = new ArrayList<>();

	public EntityA(String name) {
		super();
		this.name = name;
	}
	
	public EntityA addStringList(String val) {
		this.stringList.add(val);
		return this;
	}
	public EntityA addIntegerList(Integer val) {
		this.integerList.add(val);
		return this;
	}
}
