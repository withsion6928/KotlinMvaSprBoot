package com.example.kotlnspringbootmvc.controller.put

import com.example.kotlnspringbootmvc.model.http.Result
import com.example.kotlnspringbootmvc.model.http.UserRequest
import com.example.kotlnspringbootmvc.model.http.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutApiController {
    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return  "put-mapping"
    }

    //예전방식
    @RequestMapping(method= [RequestMethod.PUT], path = ["/request-mapping"])
    fun RequestMapping ():String{
        return "request-mapping(Put)"
    }


    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {

       return  UserResponse().apply{
            //1.result
            this.result = Result().apply{
                this.resultCode="ok"
                this.resultMessage="성공"
            }
            }.apply{
                this.description = "~~~~"
        }.apply {
            val userList = mutableListOf<UserRequest>();
            userList.add(userRequest);
            userList.add(UserRequest().apply {
                this.name = "a"
                this.age = 10
                this.email = "a@gmai.com"
                this.address = "a adrress"
                this.phoneNumber = "010-2222-1212"
            })
            userList.add(UserRequest().apply {
                this.name = "b"
                this.age = 20
                this.email = "b@gmai.com"
                this.address = "b adrress"
                this.phoneNumber = "010-1111-1212"
            })
            this.UserRequest = userList
        }
    }
}