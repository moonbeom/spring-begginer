package hello.member.controller;

import hello.member.domain.Member;
import hello.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class MemberController {

        private final MemberService memberService; //final이기 때문에 반드시 초기화를 해야한다.

        @Autowired
        public MemberController(MemberService memberService) {
            this.memberService = memberService; //생성자에서 멤버 서비스를 초기화함.
        }
        //1.5 GetMapping
        //1.6 Json할 필요 없다.
        @GetMapping("/members/new")
        public String createFrom() {
            return "members/createMemberForm";
        }
        //1-8 post메소드에서  서버가 받아주지를 않으니 에러를 반환하기 때문에 포스트매핑을 해야한다.
        @PostMapping("/members/new")
    public String create(MemberForm form) {
            // 1-9 등록 요청을 받았으니 등록을 하면 끝이다. 멤버등록을 하자.
            Member member = new Member();
            member.setName(form.getName());

            memberService.join(member);

            return "redirect:/"; //redirect는 반환해주는거다. form으로 간다.
        }

//        @GetMapping("/members")
//        @ResponseBody
//    public String list(Model model){ //List <Member>
//            List<Member> members = memberService.findMembers();
//            return members.toString();  //members;
//        } //모델을 쓰는 이유
    @GetMapping("/members")
    public String list(Model model) {
            List<Member> members = memberService.findMembers(); // 서비스가 멤버를 가져오면 어케하냐.
            model.addAttribute("members", members); //여기 모델이 뷰로 간다. 멤버리스트를 만들어야한다.
            return "members/memberList"; // 어차피 뷰를 호출하는데 왜 모델을 사용하냐? 데이터를 담는 매개체다. 박스상자같은거.
        }
    }
