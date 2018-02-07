package jp.co.seamark.neo4j.converter;

import java.io.IOException;
import java.util.List;

import org.neo4j.ogm.typeconversion.AttributeConverter;
import org.springframework.core.GenericTypeResolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ListValuesConverter<T> implements AttributeConverter<List<T>, String> {
	protected ObjectMapper graphNodeConverter = new ObjectMapper();
	private final Class<?> type;

	public ListValuesConverter() {
		super();
		this.type = elementType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toGraphProperty(List<T> value) {
		try {
			return graphNodeConverter.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> toEntityAttribute(String value) {
		try {
			return graphNodeConverter.readValue(value, entityAttributeType());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected JavaType entityAttributeType(){
		return graphNodeConverter.getTypeFactory().constructCollectionLikeType(List.class, type);
	}

	protected Class<?> elementType(){
		return GenericTypeResolver.resolveTypeArgument(getClass(), ListValuesConverter.class);
	}
}
