package jp.co.seamark.neo4j.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import jp.co.seamark.neo4j.entity.EntityB;

@RepositoryRestResource
public interface EntityBRepository extends PagingAndSortingRepository<EntityB, Long> {

}
