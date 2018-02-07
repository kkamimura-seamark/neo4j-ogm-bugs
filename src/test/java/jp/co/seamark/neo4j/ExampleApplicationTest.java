package jp.co.seamark.neo4j;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.seamark.neo4j.entity.EntityA;
import jp.co.seamark.neo4j.entity.EntityB;
import jp.co.seamark.neo4j.repository.EntityARepository;
import jp.co.seamark.neo4j.repository.EntityBRepository;
import jp.co.seamark.neo4j.vo.ValueObject;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ExampleApplicationTest {
	@Autowired
	private Session session;
	
	@Autowired
	private EntityARepository repoA;
	@Autowired
	private EntityBRepository repoB;
	
	@Test
	public void testEntityA() {
		EntityA entity1 = new EntityA("test1");
		entity1
			.addIntegerList(1)
			.addIntegerList(2)
			.addStringList("あいうえお")
			.addStringList("かきくけこ");
		EntityA entity2 = new EntityA("test2");
		entity2
			.addIntegerList(3)
			.addIntegerList(4)
			.addStringList("さしすせそ")
			.addStringList("たちつてと");
		
		// when
		EntityA saved1 = repoA.save(entity1);
		EntityA saved2 = repoA.save(entity2);

		Iterator<EntityA> loaded = repoA.findAll().iterator();
		assertThat(loaded.next(), is(entity1));
		assertThat(loaded.next(), is(entity2));
	}
	@Test
	public void testEntityB() {
		EntityB entity1 = new EntityB("test1");
		entity1
			.addIntegerList(1)
			.addIntegerList(2)
			.addStringList("あいうえお")
			.addStringList("かきくけこ")
			.addObjectList(new ValueObject("vo1", "バリューオブジェクト1"))
			.addObjectList(new ValueObject("vo2", "バリューオブジェクト2"))
			;
		EntityB entity2 = new EntityB("test2");
		entity2
			.addIntegerList(3)
			.addIntegerList(4)
			.addStringList("さしすせそ")
			.addStringList("たちつてと")
			.addObjectList(new ValueObject("vo3", "バリューオブジェクト3"))
			.addObjectList(new ValueObject("vo4", "バリューオブジェクト4"))
			;
		
		// when
		EntityB saved1 = repoB.save(entity1);
		EntityB saved2 = repoB.save(entity2);

		Iterator<EntityB> loaded = repoB.findAll().iterator();
		assertThat(loaded.next(), is(entity1));
		assertThat(loaded.next(), is(entity2));
	}

}
