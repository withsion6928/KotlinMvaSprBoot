package com.example.kotlnspringbootmvc.controller.response

import com.example.kotlnspringbootmvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {
    //1. get 4xx
    @GetMapping("")
    fun getMapping(@RequestParam age :Int?): ResponseEntity<String> {
        /*if(age == null){
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            return ResponseEntity.status(400).body("age값은 필수입니다.")
        }
        if(age < 20){
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            return ResponseEntity.status(400).body("age값은 20보다 커야합니다. ")
        }

        return ResponseEntity.ok("Ok")
        */
        return age?.let {
            if(age < 20){
                //return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                return ResponseEntity.status(400).body("age값은 20보다 커야합니다. ")
            }
            ResponseEntity.ok("Ok")
        }?: kotlin.run {
            return ResponseEntity.status(400).body("age값은 필수입니다.")
        }
    }
    @PostMapping
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest)
    }
    @PutMapping
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }
    @DeleteMapping("/{id}")
    fun putMapping(@PathVariable id:Int): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
}