package com.zhunan.demo.Controllers;

import com.zhunan.demo.Models.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//测试HTTP 接口GET请求
@RestController
public class GetController {

    private Map<String,Object> params=new HashMap<>();

    /**
     * 功能描述  测试restful协议，从路径中获取字段
     * @param cityId
     * @param userId
     * @return
     */
//    @RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)
//    public Object findUser(@PathVariable("city_id") String cityId,@PathVariable("user_id") String userId){
//
//        params.clear();
//        params.put("cityId",cityId);
//        params.put("userId",userId);
//        return params;
//    }

    /**
     * 功能描述   测试接口GET请求
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from, int size){
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;
    }

    /**
     *功能描述    默认值，是否是必须参数
     * @RequestParam(defaultValue="设置的默认值"，name="参数别名") 参数类型(int)  参数（from）
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "0",name = "page") int from,int size){
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;

    }

    /**
     * 功能描述  bean对象传参
     * 注意：1、注意需要指定HTTP请求头为 Content-Type为application/json
     *      2、使用body传递数据
     * @param user
     * @return
     */
    @RequestMapping(value = "/v1/save_user")
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user",user);
        return params;
    }

    /**
     * 功能描述  测试获取HTTP头信息
     * @param accessToken
     * @param id
     * @return
     */
    @RequestMapping(value = "/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken,@RequestHeader("name") String id){
        params.clear();
        params.put("access_token",accessToken);
        params.put("id",id);
        return params;
    }

    @RequestMapping(value = "/v1/test_request")
    public Object testRequest(HttpServletRequest request){
        params.clear();
        String id=request.getParameter("id");
        params.put("id",id);
        return params;

    }

    @GetMapping(value = "/v1/test_json")
    public Object tennyson(){
        return new User(111,"abc","111111",new Date());

    }

}
