package com.koscom.springboot.service;

import com.koscom.springboot.domain.posts.PostRepository;
import com.koscom.springboot.domain.posts.Posts;
import com.koscom.springboot.web.dto.posts.PostsSaveRequestDto;
import com.koscom.springboot.web.dto.posts.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostsService postsService;

    @AfterEach
    void tearDown(){
        //postRepository.deleteAllInBatch(); //delete from table
        postRepository.deleteAll();  // JPA상태를 보고 자식 테이블까지 삭제할지 결정
    }

    @Test
    void postsService를통해서_수정이된다() {
        // 미리 저장된 값을 하나 생성해둠 ("1", "2");
        Posts save = postRepository.save(Posts.builder()
                .title("1")
                .content("2")
                .build());

        String title = "test";
        String content = "test2";

        PostsUpdateRequestDto dto = PostsUpdateRequestDto.builder()
                .title(title)
                .content(content)
                .build();

        postsService.update(save.getId(), dto);

        List<Posts> result = postRepository.findAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo(title);
        assertThat(result.get(0).getContent()).isEqualTo(content);
    }

}
