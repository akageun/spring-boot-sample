package kr.geun.o.hwp.hellomongo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TestCollections
 *
 * @author akageun
 * @since 2019-12-04
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "new_collections")
public class TestCollections {

    @Id
    private String id;
    private String username;
    private String email;

    @Builder
    public TestCollections(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
