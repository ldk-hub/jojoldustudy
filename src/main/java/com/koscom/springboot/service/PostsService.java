package com.koscom.springboot.service;

import com.koscom.springboot.domain.posts.PostRepository;
import com.koscom.springboot.domain.posts.Posts;
import com.koscom.springboot.web.dto.posts.PostsResponseDto;
import com.koscom.springboot.web.dto.posts.PostsSaveRequestDto;
import com.koscom.springboot.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@RequiredArgsConstructor // final로 선언된 필드들은 생성자 항목으로 자동 포함시켜서 생성자 생성
@Service // spring bean 등록 & Service 클래스 선언
public class PostsService {
  private final PostRepository postsRepository;

  // 등록
  @Transactional
  public Long save (PostsSaveRequestDto requestDto) {
    Posts posts = postsRepository.save(requestDto.toEntity());
    return posts.getId();
  }

  // 수정
  @Transactional
  public Long update (Long id, PostsUpdateRequestDto dto) {
    //DB에서 가져온 값을 JPA 내부에서 캐시(1차캐시)
    Posts entity = postsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 없습니다. id=" +id));
    
    //Dirty checking
    //더티체킹 에대해서 공부하면좋음
    entity.update(dto.getTitle(), dto.getContent());

    return entity.getId();
  }

  //조회
  public PostsResponseDto findById(Long id){
    Posts entity = postsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 없습니다. id=" +id));
      return new PostsResponseDto(entity);
    //조회에서 통계집계쪽은 마이바티스를 선호함
  }

}