package jp.co.seamark.neo4j.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import jp.co.seamark.neo4j.entity.EntityA;

@RepositoryRestResource
public interface EntityARepository extends PagingAndSortingRepository<EntityA, Long> {

}
