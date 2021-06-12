package com.example.kotlnspringbootmvc.controller.get

import com.example.kotlnspringbootmvc.model.http.UserRequest
import org.apache.catalina.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController{
    @GetMapping(*["/hello","/abcd"])
    fun hello(): String {
        return "hello kotlin2222"
    }

    @RequestMapping(method = [RequestMethod.GET], path =["/request-mapping"])
    fun requestMapping(): String {
        return "mapping"

    }
    @GetMapping("/get-mapping/path-varialbe/{name}/{age}")
    fun pathVriable(@PathVariable name: String, @PathVariable age: Int): String {
        println("name: $name")
        println("age: $age")
        return "name:$name age:$age"
    }

    @GetMapping("/get-mapping/path-varialbe2/{name}/{age}")
    fun pathVriable2(@PathVariable(value = "name") _name: String, @PathVariable age: Int): String {
        var name : String = "hello"
        println("name: $_name")
        println("age: $age")
        println("localName $name")
        return "name:${_name} age:$age"
    }


    @GetMapping("/get-mapping/query-param")
    fun QueryParm(@RequestParam name :String, @RequestParam age: Int): String {
        println("name: $name")
        println("age: $age")
        return "name:$name age:$age"
    }

    @GetMapping("/get-mapping/query-param/object")
    fun QueryParmObject(userRequest: UserRequest) : UserRequest{
        println(userRequest);
        return userRequest;
    }

    @GetMapping("/get-mapping/query-param/map")
    fun QueryParamMap(@RequestParam map : Map<String , Any>): Map<String, Any> {
        println(map)
        return map;
    }


}