package com.koscom.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter//롬복 oop에서는 세터 사용 X
@NoArgsConstructor//디폴트 생성자 거의필수 넣어야함.
@Entity//자바 표준엔티티
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pk 채번 방식
    private Long id; // pk(auto increament, bigint)
    
    @Column(length = 500, nullable = false)//바차사이즈, 낫널설정
    private String title;

    @Column(length = 2000, nullable = false)//바차사이즈, 낫널설정
    private String content;

    private String author; //@Column 없으면 varchar(255) 자동으로입력됨. nullable = true

    @Builder//lombok의 빌더 
    public Posts(String title, String content, String author) {//id가 없고 나머지 필드만 있는 생성자임
        this.title = title;
        this.content = content;
        this.author = author;
    }


}
