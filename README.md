# Comment_reply
comment와 reply(대댓글)에 대해 알아보자.
---

JAVA1.6 / 
Mybatis / 
Lombok / 
ajax json /
--
### Specification
  1. 게시글이 생성이 되고, 해당 게시물에 댓글이 달린 경우, 그 댓글에 대한 reply를 작성합니다.
  2. 게시글 댓글 대댓글에 대해서 수정이 가능합니다.
  3. 댓글과 대댓글에 해당 댓글의 작성자 아이디를 보여줍니다.

### 생각해볼 것.
  1. DB 구조
     >게시글이 있다면 그것에 달리는 것이 comment, 다시 또 그 Comments에 달리는 것이 Reply
  2. 정보 전달의 형태?
     >Json? ArrayList<VO> 에 담아서 model의 형태로? 
  3. 게시글과 comment와 reply에 DB 연결의 형태는?


### 방법
  1. DB 구조
     > ##### [Board]
       > B_num : 게시글의 고유 식별 번호입니다.(b_num) <br>
       > B_title <br>
       > B_content <br>
       > B_user_id : 게시글 및 댓글, 대댓글의 작성자가 모두 다를 수 있기에 각각의 DB 파트마다 user_id를 설정합니다.<br>
     > ##### [Comment]
       > C_num : Commnet 고유 식별 번호입니다.(b_num)<br>
       > Com_posted_num : 댓글을 단 게시글의 num입니다.(B_num을 외래키로 설정합니다. 왜? B_num이 존재하지 않는다면 댓글을 달 게시물이 없기 때문입니다.)<br>
       > C_content<br>
       > C_user_id : 댓글을 남긴 아이디가 set 됩니다.<br>
     > ##### [Reply]
       > R_num : 대댓글의 고유 식별 번호입니다.(b_num)<br>
       > reply_posted_num : 대댓글을 단 코멘트의 게시글 num입니다.<br>
       > reply_board_num : 대댓글이 달린 게시글의 num입니다. <br>
       > R_content<br>
       > R_user_id : 게시글 및 댓글, 대댓글의 작성자가 모두 다를 수 있기에 각각의 DB 파트마다 user_id를 설정합니다.<br>

#### 처음 설정한 DB는 위와 같습니다. 다만, comment와 Reply의 table의 항목을 고려해봤을 때, 두 개의 테이블이 필요하지 않을 것 같기에 생각을 바꿨습니다.
또한, 정보의 관점에서 table을 두개 넣는 것보다 한개의 table에서 DB를 서칭하는 것이 더 효과적일 것이라고 생각을 했습니다.


    #### [Comment_reply DB table]
     ---
       > c_r_num : 댓글 대댓글의 고유 식별 번호 입니다.<br>
       > C_r_posted_num : 댓글 대댓글을 단 게시글의 식별 번호입니다(B_num과 FK 설정)<br>
       > c_r_comments : 댓글 대댓글의 내용입니다.<br>
       > c_r_user_id : 댓글 대댓글의 작성자입니다.<br>
       > c_r_Parent_com : 대댓글의 경우에는 부모 com이 필요함을 인지.<br>
                         댓글의 경우, '0'으로 세팅하고, 대댓글의 경우, 상위 댓글의 c_r_num이 세팅됩니다.<br>
     ---

목표 : 동기 통신을 이용하여 진행하며, model 객체에 각각의 값을 담아 뷰단으로 넘겨서 댓글 대댓글을 구현.

#### ERD 구조

![image](https://github.com/HyungjuLee95/CommentReply/assets/111270174/5438cb20-7a17-4360-b29e-cdf7c8cc40c1)


#### 클래스 구성(controller, model, service)
![image](https://github.com/HyungjuLee95/CommentReply/assets/111270174/f55046f9-b30a-4636-8a06-09c2e645219a)




     
