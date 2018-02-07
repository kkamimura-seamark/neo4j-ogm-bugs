package jp.co.seamark.neo4j.entity;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import jp.co.seamark.neo4j.converter.VoListConverter;
import jp.co.seamark.neo4j.vo.ValueObject;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EntityB {
	@GraphId
	private Long id;
	
	private String name;
	
	private List<String> stringList = new ArrayList<>();
	private List<Integer> integerList = new ArrayList<>();
	
	@Convert(VoListConverter.class)
	private List<ValueObject> objectList = new ArrayList<>();

	public EntityB(String name) {
		super();
		this.name = name;
	}
	public EntityB addStringList(String val) {
		this.stringList.add(val);
		return this;
	}
	public EntityB addIntegerList(Integer val) {
		this.integerList.add(val);
		return this;
	}
	public EntityB addObjectList(ValueObject val) {
		this.objectList.add(val);
		return this;
	}
}
