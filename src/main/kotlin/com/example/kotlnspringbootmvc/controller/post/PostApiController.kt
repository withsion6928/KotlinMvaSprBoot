package com.example.kotlnspringbootmvc.controller.post

import com.example.kotlnspringbootmvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {
    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return  "post-mapping"
    }

    //예전방식
    @RequestMapping(method= [RequestMethod.POST], path = ["/request-mapping"])
    fun RequestMapping ():String{
        return "request-mapping(Post)"
    }

    //object mapper
    // json -> object
    // object -> json
    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest;
    }



}