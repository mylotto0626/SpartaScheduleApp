package dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleRequestDto {
    // 할일 = listTitle, content
    // 작성자 = username
    // 비밀번호 = password
    // 작성일 => 작성완료하면 응답 객체에 담기게

    private String listTitle;
    private String content;
    private String username;
    private String password;

}
