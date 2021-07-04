package com.example.kotlnspringbootmvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {

    //1. path Variable
    //2. request param

    @DeleteMapping(path=["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value="name") _name : String,
        @RequestParam(name="age") _age : Int
    ) : String{
        println(_name)
        println(_age)
        return "$_name $_age"
    }

    @DeleteMapping(path = ["/delete-mapping/{name}/{age}"])
    fun deleteMappingPath(@PathVariable(value = "name") _name:String,
                          @PathVariable(value = "age") _age:String )
            : String {
        println(_name)
        println(_age)
        return "$_name $_age"
    }



}