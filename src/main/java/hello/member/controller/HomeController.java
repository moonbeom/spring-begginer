package hello.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/") // "/ 얘는 이거 홈임. 그냥
    // 프레임워크는 그냥 사용법임 단순히
    public String home() {
        return "home"; //1.1이 "home"은 지정을 view를 가리킴. 스트링을 호출하려면 어노테이션 바디를 붙여줘야한다.
                        //1.2 view를 가리키니까 한번 view륾 만들어보자.
                        //1.3 resources에 home을 추가해보자. home.html
                        //1.4 memberController로 가보자.
    }
}
