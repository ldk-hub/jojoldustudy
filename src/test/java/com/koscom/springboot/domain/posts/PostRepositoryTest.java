package com.koscom.springboot.domain.posts;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    //테스트 진행 후 꼭 있어야함.
    @AfterEach//중요필수
    void tearDown(){
      postRepository.deleteAll();  //테스트케이스별로 영향받지 않는 구조로 됨.초기화작업임
    }

    @Test
    void 게시글저장_불러오기(){
         String title = "테스트 타이틀";
         String content = "테스트 본문";

         postRepository.save(Posts.builder()
                 .title(title)
                 .content(content)
                 .build());


         List<Posts> result = postRepository.findAll();


         System.out.println(result.get(0).getId());// db가 만들어준 값
         System.out.println(result.get(0).getTitle());//내가 넣어준 값

         assertThat(result.get(0).getTitle()).isEqualTo(title);
         assertThat(result.get(0).getContent()).isEqualTo(content);
    }

    @Test
    void 게시글저장_불러오기2(){
        String title = "테스트 타이틀";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .build());


        List<Posts> result = postRepository.findAll();


        System.out.println(result.size());// db가 만들어준 값


        assertThat(result).hasSize(1);
    }

    @Test
    void 게시글저장_불러오기3(){
        String title = "테스트 타이틀";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .build());


        List<Posts> result = postRepository.findAll();


        System.out.println(result.size());// db가 만들어준 값


        assertThat(result).hasSize(1);
    }

    @Test
    public void 등록시간_수정시간이_저장된다() {
        //given
        //이 날짜기능이 1.8버전이상에서의 강력한 날짜기능이됨.
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //지금 등록한 일시와 수정일시는 최소한 2019년 보다는 뒤에있을거라는 확신
        //매일 수행할때마다 테스트 일시가 변경되니 특정일시를 확정할 수 없는 테스트
        

        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now); //2019년보다는 생성일이 뒤에있느냐
        assertThat(posts.getModifiedDate()).isAfter(now); // 2019년보다는 수정일이 뒤에있느냐 검증
    }



}
