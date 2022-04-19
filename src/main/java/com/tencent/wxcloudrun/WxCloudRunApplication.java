package com.tencent.wxcloudrun;

import com.tencent.wxcloudrun.model.SysMenuVo;
import com.tencent.wxcloudrun.model.SysSettingVo;
import com.tencent.wxcloudrun.model.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = {"com.tencent.wxcloudrun.dao"})
public class WxCloudRunApplication {  

  public static void main(String[] args) {
    SpringApplication.run(WxCloudRunApplication.class, args);
  }
}


@Slf4j
@Controller
@RequestMapping("/")
class Index2Controller {


  @Value("${server.servlet.context-path:}")
  private String contextPath;


  /**
   * 端口
   */
  @Value("${server.port}")
  private String port;


  /**
   * 跳转首页
   */
  @GetMapping("")
  public void index1(HttpServletResponse response) {
    //内部重定向
    try {
      response.sendRedirect("/index");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GetMapping("index")
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("index");

    //系统信息
    modelAndView.addObject("sys", new SysSettingVo());

    modelAndView.addObject("loginUser", new SysUserVo());

    List<SysMenuVo> menuVoList = new ArrayList<>();

    SysMenuVo vo1 = new SysMenuVo();
    vo1.setMenuName("导航管理");
    vo1.setMenuId("1");
    menuVoList.add(vo1);
    modelAndView.addObject("menuList",menuVoList);

//    //登录用户系统菜单
//    List<SysMenuVo> menuVoList = sysUserMenuService.findByUserId(sysUserVo.getUserId()).getData();
//    modelAndView.addObject("menuList",menuVoList);
//
//    //登录用户快捷菜单
//    List<SysShortcutMenuVo> shortcutMenuVoList= sysShortcutMenuService.findByUserId(sysUserVo.getUserId()).getData();
//    modelAndView.addObject("shortcutMenuList",shortcutMenuVoList);

//    //后端公钥
//    String publicKey = RsaUtil.getPublicKey();
//    modelAndView.addObject("publicKey", publicKey);

    return modelAndView;
  }


  /**
   * 跳转实时系统硬件监控
   */
  @GetMapping("monitor")
  public ModelAndView monitor() {
    return new ModelAndView("monitor.html", "port", port);
  }

  /**
   * 跳转实时日志
   */
  @GetMapping("logging")
  public ModelAndView logging() {
    return new ModelAndView("logging.html", "port", port);
  }

}