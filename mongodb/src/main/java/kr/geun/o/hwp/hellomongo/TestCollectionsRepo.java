package kr.geun.o.hwp.hellomongo;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * TestCollectionsRepo
 *
 * @author akageun
 * @since 2019-12-06
 */
public interface TestCollectionsRepo extends MongoRepository<TestCollections, String> {
}
