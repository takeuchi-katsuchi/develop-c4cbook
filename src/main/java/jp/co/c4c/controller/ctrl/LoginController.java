package jp.co.c4c.controller.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.controller.form.LoginForm;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.DetailService;

@Controller
@RequestMapping("/login")
@SessionAttributes("webSessionDto")
public class LoginController {

    @Autowired
    DetailService detailService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, LoginForm form, HttpServletRequest request) {
        form.setBk_M_MemBasicDtoList(detailService.getAllMembers());
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, BindingResult res, @RequestParam("memId") int memId, HttpServletRequest request) {
        webSessionDto.setMemId(memId);
        webSessionDto.setSessionId(request.getSession().getId());
        return "redirect:top";
    }

}
